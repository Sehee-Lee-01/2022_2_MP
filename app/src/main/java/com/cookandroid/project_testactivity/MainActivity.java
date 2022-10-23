package com.cookandroid.project_testactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.cookandroid.project_testactivity.fragments.LogInFragment;
import com.cookandroid.project_testactivity.fragments.SignUpFragment;

public class MainActivity extends AppCompatActivity {
    private LogInFragment logInFragment;
    private SignUpFragment signUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        logInFragment = new LogInFragment();
        signUpFragment = new SignUpFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentMain,logInFragment);
        fragmentTransaction.commit();
    }

    public void onFragmentChanged(int index){
        if(index==0){
            FragmentManager fm1 = getSupportFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            ft1.replace(R.id.fragmentMain, logInFragment);
            ft1.commit();
        } else if (index ==1){
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.replace(R.id.fragmentMain, signUpFragment);
            ft2.commit();
        }
    }
}
