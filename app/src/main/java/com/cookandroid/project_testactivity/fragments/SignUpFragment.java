package com.cookandroid.project_testactivity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.project_testactivity.MainActivity;
import com.cookandroid.project_testactivity.R;

public class SignUpFragment extends Fragment {
    private Boolean isTestedID = Boolean.FALSE;
    private Button btnSignUp, btnValidID;
    private TextView testID, invalidID, validID, announcePW;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_signup, container, false);

        btnValidID = (Button) rootView.findViewById(R.id.btnValidID);
        btnValidID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 아이디 유효성 검사(중복 검사), 화면 전환 안하고 중복 될 때 빨간 글씨 visible, 아니면 파란글씨 visible

                // 중복 검사하고 중복검사 전역변수 True로 바꾸기
                isTestedID = Boolean.TRUE;
            }
        });

        Button btnSignUp = (Button) rootView.findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                // 아이디 유효성 검사 여부 확인 안했으면 알림
                // 비밀번호 유효성 검사(자릿수, 특수키), 화면 전환 안하고 중복 될 때 빨간 글씨 visible
                //"※ 유효하지 않은 비밀번호입니다.(8~20자리, 영문 및 숫자)", "※ 비밀번호를 입력해주세요.(8~20자리, 영문 및 숫자)"

                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(0);
            }
        });
        return rootView;
    }
}
