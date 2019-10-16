package com.grouptwo.ustcdiary.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.grouptwo.ustcdiary.R;
import com.grouptwo.ustcdiary.topicActivity.contactActivity;
import com.grouptwo.ustcdiary.topicActivity.diaryActivity;
import com.grouptwo.ustcdiary.topicActivity.memoryActivity;

import java.util.ArrayList;
import java.util.List;

public class mainActivity extends AppCompatActivity {

    private List<Topic> topicList = new ArrayList<>();


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
        });
    }

    private void initTopic(){
        Topic contact = new Topic("contact",R.drawable.contact);
        Topic diary = new Topic("diary",R.drawable.diary);
        Topic memory = new Topic("memory",R.drawable.memory);
        topicList.add(contact);
        topicList.add(diary);
        topicList.add(memory);
    }
}
