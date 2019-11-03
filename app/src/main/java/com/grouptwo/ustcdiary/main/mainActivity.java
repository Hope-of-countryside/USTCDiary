package com.grouptwo.ustcdiary.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.grouptwo.ustcdiary.R;
import com.grouptwo.ustcdiary.topicActivity.contact.contactActivity;
import com.grouptwo.ustcdiary.topicActivity.diaryActivity;
import com.grouptwo.ustcdiary.topicActivity.memoryActivity;

import java.util.ArrayList;
import java.util.List;

public class mainActivity extends AppCompatActivity implements View.OnClickListener {

    //ListView嵌入的内容
    private List<Topic> topicList = new ArrayList<>();
    //mainActivity上方的线性布局
    private LinearLayout activityMainTop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTopic();
        TopicAdapter adapter = new TopicAdapter(mainActivity.this,R.layout.topic_item,topicList);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Topic topic = topicList.get(i);
                goToWhichActivity(topic);
                }
            }
        );
        activityMainTop = (LinearLayout) findViewById(R.id.activity_main_top);
        activityMainTop.setOnClickListener(this);
    }

    private void initTopic(){
        Topic contact = new Topic("contact",R.drawable.contact);
        Topic diary = new Topic("diary",R.drawable.diary);
        Topic memory = new Topic("memory",R.drawable.memory);
        topicList.add(contact);
        topicList.add(diary);
        topicList.add(memory);
    }
    //选择去哪个活动
    private void goToWhichActivity(Topic topic){
        switch(topic.getName()){
            case "contact":
                startActivity(new Intent(mainActivity.this, contactActivity.class));
                break;
            case "diary":
                startActivity(new Intent(mainActivity.this, diaryActivity.class));
                break;
            case "memory":
                startActivity(new Intent(mainActivity.this, memoryActivity.class));
                break;
        }
    }

    //上侧点击事件监听，实现名字和图片的修改

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.activity_main_top:


        }
    }
}
//test
