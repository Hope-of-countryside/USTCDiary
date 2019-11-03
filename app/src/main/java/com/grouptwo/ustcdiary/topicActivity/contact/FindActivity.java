package com.grouptwo.ustcdiary.topicActivity.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.grouptwo.ustcdiary.R;

public class FindActivity extends AppCompatActivity {

    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        searchView=findViewById(R.id.sv);
        searchView.setIconifiedByDefault(true);
        searchView.setSubmitButtonEnabled(true);//设置提交按钮

        //设置文本监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                setTitle("正在搜索");
                Toast.makeText(FindActivity.this,s+": 此用户不存在",Toast.LENGTH_SHORT).show();
                return false;
            }

            //输入字符的监听
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

}
