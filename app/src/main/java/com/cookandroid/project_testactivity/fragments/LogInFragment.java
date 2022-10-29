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

import com.cookandroid.project_testactivity.GoodsActivity;
import com.cookandroid.project_testactivity.MainActivity;
import com.cookandroid.project_testactivity.R;

public class LogInFragment extends Fragment {
    // 로그인 했으면 이름 "00님 안녕하세요." 하고 상품확인 버튼만 보이게
    Button btnToLogIn, btnToGoods, btnToSignUp;
    EditText editID, editPW;
    TextView announce;
    String loginID, loginPW, userID, userPW;
    SharedPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);
        editID = (EditText) rootView.findViewById(R.id.editID);
        editPW = (EditText) rootView.findViewById(R.id.editPW);

        if (savedInstanceState == null) {
            prefs = getActivity().getSharedPreferences("person_info", 0);
            userID = prefs.getString("userID", "");
            userPW = prefs.getString("userPW", "");
            editID.setText(userID);
            editPW.setText(userPW);
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
                    if (loginID.equals(userID) && loginPW.equals(userPW)) {
                        Intent intent = new Intent(getActivity(), GoodsActivity.class);
                        // 로그인 했다고 전달
                        intent.putExtra("isLogin", true);
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
}
