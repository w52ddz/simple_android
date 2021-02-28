package com.example.simpleandroidproject.activities;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simpleandroidproject.R;

public class LayoutsTest extends AppCompatActivity implements View.OnClickListener {

    // 设置count变量
    private int count;
    // 定义全局变量保存textView
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 文本容器
//        TextView textView = findViewById(R.id.content_text);
        mTextView = findViewById(R.id.content_text);
        // 按钮
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSub = findViewById(R.id.btn_sub);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("点击", "点击了按钮");
//            }
//        });

        // 使用Java8语法设置事件监听，只有一个点击事件时使用
//        btnAdd.setOnClickListener((v) -> {
//            count++;
//            textView.setText(String.valueOf(count));
//        });
    }

    // mac快速生成代码 option + enter
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                count++;
                break;
            case R.id.btn_sub:
                count--;
                break;
        }
        mTextView.setText(String.valueOf(count));
    }
}