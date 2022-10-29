package com.cookandroid.project_testactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpPop extends AppCompatActivity {
    Button btnYes, btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pop_signup);

        Intent inIntent = getIntent();
        btnYes = (Button) findViewById(R.id.btnYes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outYesIntent = new Intent(getApplicationContext(), GoodsActivity.class);
                outYesIntent.putExtra("allowSignUp", true);
                setResult(RESULT_OK, outYesIntent);
                finish();
            }
        });
        btnNo = (Button) findViewById(R.id.btnNo);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outNoIntent = new Intent(getApplicationContext(), GoodsActivity.class);
                outNoIntent.putExtra("allowSignUp", false);
                setResult(RESULT_OK, outNoIntent);
                finish();
            }
        });
    }
}
