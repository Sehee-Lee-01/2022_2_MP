package com.cookandroid.project_testactivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    Button btnSignUp;
    TextView txtSignUp, txtID, txtPW, txtName, txtPhone, txtAddress, txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txtSignUp = (TextView) findViewById(R.id.txtSignUp);
        txtSignUp.setTextSize(30);
        txtSignUp.setTypeface(Typeface.DEFAULT_BOLD);

        txtID = (TextView) findViewById(R.id.txtID);
        txtPW = (TextView) findViewById(R.id.txtPW);
        txtName = (TextView) findViewById(R.id.txtName);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtInfo = (TextView) findViewById(R.id.txtInfo);



    }

}
