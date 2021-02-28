package com.example.simpleandroidproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewLv;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    private void setView() {
        // 绑定点击事件
//        listViewLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
        listViewLv.setOnItemClickListener((parent, view, position, id) ->
            Toast.makeText(getApplicationContext(), ""+list.get(position), Toast.LENGTH_SHORT).show()
        );
    }

    public void initView() {
        listViewLv = findViewById(R.id.list_view_lv);
        list = new ArrayList<>();
        list.add("数据1");
        list.add("数据2");
        list.add("数据3");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
            getApplicationContext(), android.R.layout.simple_expandable_list_item_1, list
        );
        listViewLv.setAdapter(arrayAdapter);
    }
}

