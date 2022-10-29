package com.cookandroid.project_testactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.cookandroid.project_testactivity.fragments.LogInFragment;
import com.cookandroid.project_testactivity.fragments.SignUpFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager = getSupportFragmentManager();
    private LogInFragment logInFragment;
    private SignUpFragment signUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent inIntent = getIntent();
        final int indexValue = inIntent.getIntExtra("index", 0);

        logInFragment = new LogInFragment();
        signUpFragment = new SignUpFragment();

        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if (indexValue == 0) {
            fragmentTransaction.add(R.id.fragmentMain, logInFragment);

        } else if (indexValue == 1) {
            fragmentTransaction.add(R.id.fragmentMain, signUpFragment);
        }
        fragmentTransaction.commit();
    }

    public void onFragmentChanged(int index) {
        if (index == 0) {
            if (logInFragment == null)
                logInFragment = new LogInFragment();
            manager.beginTransaction().replace(R.id.fragmentMain, logInFragment).commit();
        } else if (index == 1) {
            if (signUpFragment == null)
                signUpFragment = new SignUpFragment();
            manager.beginTransaction().replace(R.id.fragmentMain, signUpFragment).commit();
        }
    }
}
