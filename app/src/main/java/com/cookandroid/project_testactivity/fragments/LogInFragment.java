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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.project_testactivity.GoodsActivity;
import com.cookandroid.project_testactivity.MainActivity;
import com.cookandroid.project_testactivity.R;

public class LogInFragment extends Fragment {
    // 로그인 했으면 이름 "00님 안녕하세요." 하고 상품확인 버튼만 보이게
    Button btnToLogIn, btnToGoods, btnToSignUp;
    EditText editID, editPW;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);
        editID = (EditText) rootView.findViewById(R.id.editID);
        editPW = (EditText) rootView.findViewById(R.id.editPW);

        if (savedInstanceState == null) {
            SharedPreferences prefs = getActivity().getSharedPreferences("person_info", 0);
            String userID = prefs.getString("userID", "");
            String userPW = prefs.getString("userPW", "");
            editID.setText(userID);
            editPW.setText(userPW);
        }

        btnToLogIn = (Button) rootView.findViewById(R.id.btnLogIn);
        btnToLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인 유무 변경
                SharedPreferences prefs = getActivity().getSharedPreferences("person_info", 0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isLogin", false);
                editor.apply();

                Intent intent = new Intent(getActivity(), GoodsActivity.class);
                startActivity(intent);
            }
        });

        btnToGoods = (Button) rootView.findViewById(R.id.btnGoods);
        btnToGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GoodsActivity.class);
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
