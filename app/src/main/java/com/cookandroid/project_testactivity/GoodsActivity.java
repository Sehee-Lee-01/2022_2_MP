package com.cookandroid.project_testactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class GoodsActivity extends AppCompatActivity {
    Button btnPop;
    ListView listGoods;
    String[] data = {"dog", "cat", "pie", "rabbit", "5", "6", "7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods);

        Intent inIntent = getIntent();
        boolean isLogin = inIntent.getBooleanExtra("isLogin", false);

        btnPop = (Button) findViewById(R.id.btnPop);
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == InfoPop.RESULT_OK) {
                            Intent inIntent = result.getData();
                            boolean resultSignUp = inIntent.getBooleanExtra("allowSignUp", false);
                            if (resultSignUp) {
                                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                                // 회원가입 프래그먼트로 이동
                                outIntent.putExtra("index", 1);
                                startActivity(outIntent);
                            } else {
                                Toast.makeText(getApplicationContext(), "회원가입을 취소합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인 된 상태인 경우
                if (isLogin) {
                    // 회원 정보 보여주기(팝업)
                    Intent intent = new Intent(getApplicationContext(), InfoPop.class);
                    startActivity(intent);
                } else {
                    // 안된 상태인 경우
                    // 가입 여부 물어보기 (팝업)
                    Intent intentSignUp = new Intent(getApplicationContext(), SignUpPop.class);
                    // **반환값 가져오기, allowSignUp 부여
                    activityResultLauncher.launch(intentSignUp);
                }
            }
        });
        listGoods = (ListView) findViewById(R.id.listGoods);
        ListAdapter adapter = new ListAdapter();
        listGoods.setAdapter((adapter));
    }

    class ListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.goods_row, null);
            }
            TextView sub_name = (TextView) view.findViewById(R.id.goodsName);
            ImageView sub_image = (ImageView) view.findViewById(R.id.goodsImage);
            CheckBox sub_check = (CheckBox) view.findViewById(R.id.goodsCheck);
            sub_name.setText(data[i]);
            sub_image.setImageResource(R.drawable.rabbit);
            return view;
        }
    }
}
