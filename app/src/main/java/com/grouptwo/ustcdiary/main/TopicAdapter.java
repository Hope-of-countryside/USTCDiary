package com.grouptwo.ustcdiary.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.grouptwo.ustcdiary.R;

import java.util.List;

public class TopicAdapter extends ArrayAdapter <Topic>{
    private int resourceId;
    public TopicAdapter(Context context, int textViewResourceId, List<Topic> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Topic topic = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView topicImage = (ImageView) view.findViewById(R.id.topic_image);
        TextView topicName = (TextView) view.findViewById(R.id.topic_name);
        topicImage.setImageResource(topic.getImageId());
        topicName.setText(topic.getName());
        return view;
    }
}
///test
