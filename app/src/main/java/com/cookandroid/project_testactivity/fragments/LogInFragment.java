package com.cookandroid.project_testactivity.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.style.UpdateLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.cookandroid.project_testactivity.GoodsActivity;
import com.cookandroid.project_testactivity.MainActivity;
import com.cookandroid.project_testactivity.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class LogInFragment extends Fragment {
    Button btnToLogIn, btnToGoods, btnToSignUp;
    EditText editID, editPW;
    TextView announce;
    String loginID, loginPW, userID;
    SharedPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);
        editID = (EditText) rootView.findViewById(R.id.editID);
        editPW = (EditText) rootView.findViewById(R.id.editPW);

        if (savedInstanceState == null) {
            String[] userInfo = getLatestUserInfo();
            editID.setText(userInfo[0]);
            editPW.setText(userInfo[1]);
        }
        // 로그인 하고 목록 보기
        btnToLogIn = (Button) rootView.findViewById(R.id.btnLogIn); // 로그인 버튼
        announce = (TextView) rootView.findViewById(R.id.announce); // 로그인이 잘못 되었을 때 나오는 안내 text
        btnToLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력한 값
                loginID = editID.getText().toString();
                loginPW = editPW.getText().toString();
                // 프래퍼런스 저장 값(userID, userPW)과 비교하고 맞으면 실행 아니면 알림
                if (loginID.equals("")) {
                    Toast.makeText(getActivity(), "ID를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (loginPW.equals("")) {
                    Toast.makeText(getActivity(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    if (checkUserInfo(loginID, loginPW)) {
                        Intent intent = new Intent(getActivity(), GoodsActivity.class);
                        // 로그인 했다고 전달(로그인 여부, 아이디 전달)
                        intent.putExtra("isLogin", true);
                        intent.putExtra("userID", userID);
                        startActivity(intent);
                    } else {
                        String annID = "ID가 잘못되었거나 비밀번호가 잘못되었습니다.";
                        announce.setText(annID);
                        announce.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        // 로그인 안하고 목록보기
        btnToGoods = (Button) rootView.findViewById(R.id.btnGoods);
        btnToGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GoodsActivity.class);
                // 로그인 안했다고 전달
                intent.putExtra("isLogin", false);
                startActivity(intent);
            }
        });

        btnToSignUp = (Button) rootView.findViewById(R.id.btnSignUp);
        btnToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(1);
            }
        });
        return rootView;
    }

    //SharedPreferences에 최근 회원 정보 불러오기
    private String[] getLatestUserInfo() {
        String[] latestUserInfo = new String[2]; // 배열 생성(ID, PW)
        prefs = getActivity().getSharedPreferences("person_info", 0);
        String[] infoList = new String[]{"userIDListSt", "userPWListSt"};
        for (int j = 0; j < infoList.length; j++) {
            // 기존에 저장된 ID, PW 나열 불러오기
            String listSt = prefs.getString(infoList[j], "");
            if (listSt != null) {
                try {
                    // 기존 정보를 JSONArray로 불러오기
                    JSONArray a = new JSONArray(listSt);
                    String info = a.optString(a.length() - 1); // 최근 회원정보
                    latestUserInfo[j] = info;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return latestUserInfo;
    }

    //SharedPreferences에서 로그인 정보 맞는지 확인
    private boolean checkUserInfo(String loginID, String loginPW) {
        boolean isID = false;
        int idxPW = -1;
        prefs = getActivity().getSharedPreferences("person_info", 0);
        // 기존에 저장된 ID, PW 나열 불러오기
        String userIDListSt = prefs.getString("userIDListSt", "");
        String userPWListSt = prefs.getString("userPWListSt", "");
        JSONArray userIDList, userPWList;
        if (userIDListSt != null) {
            try {
                userIDList = new JSONArray(userIDListSt);
                // 아이디 확인
                for (int i = 0; i < userIDList.length(); i++) {
                    if (loginID.equals(userIDList.optString(i))) {
                        isID = true;
                        idxPW = i;
                        break;
                    }
                }
                // 아이디 맞으면 비번 확인
                if ((isID) && (userPWListSt != null)) {
                    try {
                        userPWList = new JSONArray(userPWListSt);
                        // 비번 확인
                        if (loginPW.equals(userPWList.optString(idxPW))) {
                            return true;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
