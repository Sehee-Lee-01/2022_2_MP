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

import androidx.appcompat.app.AppCompatActivity;

public class GoodsActivity extends AppCompatActivity {
    Button btnReturn;
    ListView listGoods;
    String[] data = {"dog", "cat", "pie", "rabbit", "5", "6", "7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
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
