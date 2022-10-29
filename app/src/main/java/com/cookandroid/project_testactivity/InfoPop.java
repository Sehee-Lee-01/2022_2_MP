package com.cookandroid.project_testactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoPop extends AppCompatActivity {
    TextView txtUserID, txtUserName, txtUserPhone, txtUserAddress;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInsanceState) {
        super.onCreate(savedInsanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pop_info);

        txtUserID = (TextView) findViewById(R.id.txtUserID);
        txtUserName = (TextView) findViewById(R.id.txtUserName);
        txtUserPhone = (TextView) findViewById(R.id.txtUserPhone);
        txtUserAddress = (TextView) findViewById(R.id.txtUserAddress);

        if (savedInsanceState == null) {
            SharedPreferences prefs = getSharedPreferences("person_info", 0);
            String userID = prefs.getString("userID", "");
            String userName = prefs.getString("userName", "");
            String userPhone = prefs.getString("userPhone", "");
            String userAddress = prefs.getString("userAddress", "");

            txtUserID.setText(userID);
            txtUserName.setText(userName);
            txtUserPhone.setText(userPhone);
            txtUserAddress.setText(userAddress);
        }
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
