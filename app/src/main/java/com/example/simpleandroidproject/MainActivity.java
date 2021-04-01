package com.example.simpleandroidproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simpleandroidproject.activities.LayoutsTest;
import com.example.simpleandroidproject.util.PageEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    private ListView listViewLv;
    private List<PageEntity> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    private void setView() {
        // 绑定点击事件
        listViewLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PageEntity pageEntity = list.get(i);
                if (pageEntity.cls != null) {
                    goNextPage(MainActivity.this, pageEntity.cls);
                    return;
                }
                Toast.makeText(getApplicationContext(), ""+pageEntity.name, Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), LayoutsTest.class);
        /*listViewLv.setOnItemClickListener((parent, view, position, id) ->
            Toast.makeText(getApplicationContext(), ""+list.get(position), Toast.LENGTH_SHORT).show()
        );*/
    }

    public void initView() {
        listViewLv = findViewById(R.id.list_view_lv);
        list = new ArrayList<>();
        list.add(new PageEntity("数字加减", LayoutsTest.class));
        list.add(new PageEntity("数据2"));
        list.add(new PageEntity("数据3"));
        final ArrayList<String> nameList = new ArrayList<>();
        list.forEach(new Consumer<PageEntity>() {
            @Override
            public void accept(PageEntity pageEntity) {
                nameList.add(pageEntity.name);
            }
        });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
            getApplicationContext(), android.R.layout.simple_expandable_list_item_1, nameList
        );
        listViewLv.setAdapter(arrayAdapter);
    }

    // 跳转页面
    public void goNextPage(Context context, Class cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        startActivity(intent);
    }
}

