package com.cookandroid.project_testactivity.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.cookandroid.project_testactivity.MainActivity;
import com.cookandroid.project_testactivity.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpFragment extends Fragment {
    private Boolean isTestedID = false;
    private Button btnSignUp, btnValidID;
    private TextView invalidID, validID, announcePW;
    private EditText editID, editPW, editName, editPhone, editAddress;
    private RadioButton radAccept;
    SharedPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_signup, container, false);

        btnValidID = (Button) rootView.findViewById(R.id.btnValidID);
        editID = (EditText) rootView.findViewById(R.id.editID);
        invalidID = (TextView) rootView.findViewById(R.id.invalidID);
        validID = (TextView) rootView.findViewById(R.id.validID);
        btnValidID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 아이디 유효성 검사(중복 검사), 화면 전환 안하고 중복 될 때 빨간 글씨 visible, 아니면 파란글씨 visible
                String signUpID = editID.getText().toString();
                if (signUpID.equals("")) {
                    Toast.makeText(getActivity(), "ID를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    // 아이디 중복 검사
                    if (isIDValid(signUpID)) {
                        invalidID.setVisibility(View.GONE);
                        validID.setVisibility(View.VISIBLE);
                        isTestedID = true; // 중복 검사하고 통과되면 중복검사 전역변수 True로 바꾸기
                    } else {
                        invalidID.setVisibility(View.VISIBLE);
                        validID.setVisibility(View.GONE);
                        isTestedID = false;
                    }
                }
            }
        });

        btnSignUp = (Button) rootView.findViewById(R.id.btnSignUp);
        editPW = (EditText) rootView.findViewById(R.id.editPW);
        announcePW = (TextView) rootView.findViewById(R.id.announcePW);
        editName = (EditText) rootView.findViewById(R.id.editName);
        editPhone = (EditText) rootView.findViewById(R.id.editPhone);
        editAddress = (EditText) rootView.findViewById(R.id.editAddress);
        radAccept = (RadioButton) rootView.findViewById(R.id.radAccept);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                announcePW.setVisibility(View.GONE);

                // 회원 정보 정보 저장
                String userID = editID.getText().toString();
                String userPW = editPW.getText().toString();
                String userName = editName.getText().toString();
                String userPhone = editPhone.getText().toString();
                String userAddress = editAddress.getText().toString();

                if (userID.equals("") && userPW.equals("") && userName.equals("") && userPhone.equals("") && userAddress.equals("")) {
                    Toast.makeText(getActivity(), "모든 항목을 공란없이 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (!isTestedID) {
                    Toast.makeText(getActivity(), "ID 중복검사를 해주세요.", Toast.LENGTH_SHORT).show();
                } else if ((userPW.length() < 8) || (userPW.length() > 13)) {
                    Toast.makeText(getActivity(), "비밀번호를 8~12자리로 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (!isPWValid(userPW)) {
                    announcePW.setVisibility(View.VISIBLE);
                } else if (!radAccept.isChecked()) {
                    Toast.makeText(getActivity(), "개인정보 활용에 동의해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    ArrayList<String> userInfo = new ArrayList<String>();
                    userInfo.add(userID);
                    userInfo.add(userPW);
                    userInfo.add(userName);
                    userInfo.add(userPhone);
                    userInfo.add(userAddress);
                    insertUserInfo(userInfo); // 모두 ArrayList로 저장
                    Toast.makeText(getActivity(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    MainActivity activity = (MainActivity) getActivity(); // 로그인 페이지로 이동
                    activity.onFragmentChanged(0);
                }
            }
        });
        return rootView;
    }

    private boolean isIDValid(String signUpID) {
        prefs = getActivity().getSharedPreferences("person_info", 0);
        // 기존에 저장된 ID 나열 불러오기
        String userIDListSt = prefs.getString("userIDListSt", "");
        if (!userIDListSt.equals("")) {
            try {
                JSONArray userIDList = new JSONArray(userIDListSt);
                // 아이디 확인
                for (int i = 0; i < userIDList.length(); i++) {
                    if (signUpID.equals(userIDList.optString(i))) {
                        Toast.makeText(getActivity(), "중복된 아이디가 있습니다.", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(getActivity(), "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
        return true;
    }

    private boolean isPWValid(String password) {
        String val_symbol = "([0-9].*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*[0-9])";
        String val_alpha = "([a-z].*[A-Z])|([A-Z].*[a-z])";
        Pattern pattern_symbol = Pattern.compile(val_symbol);
        Pattern pattern_alpha = Pattern.compile(val_alpha);
        Matcher matcher_symbol = pattern_symbol.matcher(password);
        Matcher matcher_alpha = pattern_alpha.matcher(password);

        if (!(matcher_symbol.find() && matcher_alpha.find())) {
            Toast.makeText(getActivity(), "비밀번호를 조건에 맞게 입력해주세요.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    //SharedPreferences에 ArrayList 형식의 데이터를 저장
    private void insertUserInfo(ArrayList<String> values) {
        prefs = getActivity().getSharedPreferences("person_info", 0);
        SharedPreferences.Editor editor = prefs.edit();
        String[] infoList = new String[]{"userIDListSt", "userPWListSt", "userNameListSt", "userPhoneListSt", "userAddressListSt"};
        // 기존에 저장된 ID, PW, 이름, 전화번호, 주소 나열 불러와서 끝에 각각 저장
        for (int j = 0; j < infoList.length; j++) {
            // 나열 불러오기
            String listSt = prefs.getString(infoList[j], "");
            try {
                JSONArray a;
                if (listSt.equals("")) {
                    a = new JSONArray();
                } else {
                    a = new JSONArray(listSt); // 나열을 JSONArray로 변환
                }
                a.put(values.get(j)); // 변환 후 입력한 정보 추가 후 저장
                editor.putString(infoList[j], a.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        editor.apply();
    }
}
