package com.cookandroid.project_testactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

public class InfoPop extends AppCompatActivity {
    TextView txtUserID, txtUserName, txtUserPhone, txtUserAddress;
    Button btnBack;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInsanceState) {
        super.onCreate(savedInsanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pop_info);

        Intent inIntent = getIntent();
        String userID = inIntent.getStringExtra("userID");

        txtUserID = (TextView) findViewById(R.id.txtUserID);
        txtUserName = (TextView) findViewById(R.id.txtUserName);
        txtUserPhone = (TextView) findViewById(R.id.txtUserPhone);
        txtUserAddress = (TextView) findViewById(R.id.txtUserAddress);

        if (savedInsanceState == null) {
            txtUserID.setText(userID);
            String[] userInfo = getUserInfo(userID);
            txtUserName.setText(userInfo[0]);
            txtUserPhone.setText(userInfo[1]);
            txtUserAddress.setText(userInfo[2]);
        }

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private String[] getUserInfo(String userID) {
        String[] userInfoList = new String[3]; // 배열 생성
        userInfoList[0]= "nonInfo";
        userInfoList[1]= "nonInfo";
        userInfoList[2]= "nonInfo";

        prefs = getSharedPreferences("person_info", 0);
        // 아이디 인덱스 확인
        int idxID = -1;
        String userIDListSt = prefs.getString("userIDListSt", "");
        try {
            JSONArray userIDList = new JSONArray(userIDListSt);
            for (int i = 0; i < userIDList.length(); i++) {
                if (userID.equals(userIDList.optString(i))) {
                    idxID = i;
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // 인덱스 확인 후 값 불러오기
        String[] infoList = new String[]{"userNameListSt", "userPhoneListSt", "userAddressListSt"};
        for (int j = 0; j < infoList.length; j++) {
            // 기존에 저장된 나열 불러오기
            String listSt = prefs.getString(infoList[j], "");
            try {
                JSONArray a = new JSONArray(listSt);
                String info = a.optString(idxID);
                userInfoList[j] = info;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return userInfoList;
    }
}
