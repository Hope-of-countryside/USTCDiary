package com.grouptwo.ustcdiary.topicActivity.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.grouptwo.ustcdiary.R;

import java.util.List;

/**
 * Date:2019/10/26
 * Time:13:51
 * author:wenjun
 * 适配器继承ArrayAdapter
 */
public class MyAdapter extends ArrayAdapter<User> {
    int resource;
    public MyAdapter(Context context, int resource, List<User> list){
        super(context,resource,list);
        this.resource = resource;
    }

    //重写getView获得自己想要的显示效果
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resource,parent,false);
            holder = new ViewHolder();
            holder.tv_name = convertView.findViewById(R.id.item_name);
            holder.tv_phone = convertView.findViewById(R.id.item_phone);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_name.setText(user.getName());
        holder.tv_phone.setText(user.getPhone());
        return convertView;
    }

    class ViewHolder{
        TextView tv_name;
        TextView tv_phone;
    }
}
