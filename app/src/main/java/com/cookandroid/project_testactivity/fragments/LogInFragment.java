package com.cookandroid.project_testactivity.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.project_testactivity.GoodsActivity;
import com.cookandroid.project_testactivity.MainActivity;
import com.cookandroid.project_testactivity.R;

public class LogInFragment extends Fragment {
    // 로그인 했으면 이름 "00님 안녕하세요." 하고 상품확인 버튼만 보이게
    Button btnToLogIn, btnToGoods, btnToSignUp;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);
        btnToLogIn = (Button) rootView.findViewById(R.id.btnLogIn);

//        btnToLogIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MainActivity activity = (MainActivity) getActivity();
//                activity.onFragmentChanged(0);
//            }
//        });

        btnToGoods = (Button) rootView.findViewById(R.id.btnGoods);
//        btnToGoods.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), GoodsActivity.class);
//                startActivity(intent);
//            }
//        });

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
