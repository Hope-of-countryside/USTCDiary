package com.grouptwo.ustcdiary.topicActivity.contact;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.grouptwo.ustcdiary.R;

import java.util.ArrayList;
import java.util.List;

public class contactActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textNum;
    private Button addButton,findButton;
    private ListView listView;
    private List<User> list,newList;
    private DatabaseMethod method;
    private MyAdapter adapter;
    private int listNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
        //初始化控件
        initWidget();
        //实例
        DatabaseMethod();
        //显示ListView
        showListView();
        //显示listView的条目数量
        linkmanNum();
        //根据输入查询数据显示
        find();
    }

    //处理查询的数据
    public void find(){
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //点击后跳到查阅界面
                    Intent intent=new Intent(contactActivity.this,FindActivity.class);
                    startActivity(intent);
            }
        });
    }


    /**
     * 初始化控件
     * */
    private void initWidget(){
        //找到控件
        addButton = findViewById(R.id.main_add);
        findButton=findViewById(R.id.main_search);
        listView = findViewById(R.id.main_list_view);
        textNum = findViewById(R.id.main_num);
        newList = new ArrayList<>();
        list = new ArrayList<>();
    }


    /**
     * 显示ListView
     * */
    public void showListView(){
        //查询数据
        /**
         * 添加数据到链表中
         * **/
        list = method.inquireData();

        /**
         * 创建并绑定自定义的适配器
         * */
        adapter = new MyAdapter(this,R.layout.phone_item,list);
        //通过适配器来显示listView的内容
        listView.setAdapter(adapter);

        /**
         * ListView事件监听
         * */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dialogList();
                listNum = i;
            }
        });

        addButton.setOnClickListener(this);
    }

    /**
     * 普通对话框，删除联系人
     * */
    public void dialogNormal(){
        //AlertDialog 不能直接通过构造方法构建，而要由 AlertDialog.Builder 类来创建
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        DialogInterface.OnClickListener dialogOnClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                User userDel = list.get(listNum);
                switch (i){
                    case DialogInterface.BUTTON_POSITIVE:
                        //通过查找名字来删除
                        method.delData("userName=?",new String[]{userDel.getName()});
                        //刷新数据
                        refresh();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                    default:
                        break;
                }
            }
        };
        //设置对话框的标题和内容
        builder.setTitle("删除联系人");
        builder.setMessage("确定要删除吗？");
        //为对话框添加yes no 按钮
        builder.setPositiveButton("确定", dialogOnClick);
        builder.setNegativeButton("取消",dialogOnClick);
        builder.create().show();
    }

    /**
     * 对话框的选项列表
     * */
    public void dialogList(){
        final String[] items = {"拨打电话","发送短信","编辑","删除"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                //拿到当前选中项的 User 对象
                User userNum = list.get(listNum);
                Intent intent;
                switch (i){
                    //拨打电话,通过intent调用系统的拨号器
                    case 0: intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + userNum.getPhone()));
                        startActivity(intent);
                        break;
                    //发送短信，通过intent调用系统短信
                    case 1: intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsto:" + userNum.getPhone()));
                        startActivity(intent);
                        break;
                    case 2: intent = new Intent(contactActivity.this,AddData.class);
                        //传入当前选中项的姓名和电话以在编辑页面中显示在输入框中
                        intent.putExtra("edit_name",userNum.getName());
                        intent.putExtra("edit_phone",userNum.getPhone());
                        //点击边界，则讲requestCode设置为2
                        startActivityForResult(intent,2);
                        break;
                    //弹出对话框提示是否删除
                    case 3: dialogNormal();
                        break;
                    default:
                        break;
                }
            }
        });
        builder.create().show();
    }

    //刷新
    public void refresh(){
        //最后查询数据刷新列表
        getNotifyData();
    }

    //页面顶部显示ListView条目数
    public void linkmanNum(){
        textNum.setText("("+list.size()+")");
    }

    //点击添加按钮
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_add:
                //跳转到 AddData Activity 传入请求码 1
                Intent intent = new Intent(contactActivity.this,AddData.class);
                startActivityForResult(intent,1);
                break;
            default:
                break;
        }
    }

    public void DatabaseMethod(){

        method = ((MyApplication)this.getApplication()).getMethod();
    }

    /**
     * 当页面回到此活动时，调用此方法，刷新ListView
     * */
    @Override
    protected void onResume() {
        super.onResume();
        getNotifyData();
    }

    /**
     * 这个是用来动态刷新 * */
    public void getNotifyData(){
        newList = method.inquireData();
        list.clear();
        list.addAll(newList);
        linkmanNum();
        adapter.notifyDataSetChanged();
    }


    /**
     * 上一个页面传回来的值，通过requestCode可以知道上一个行为
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            //请求码为1，表示点击了添加按钮
            case 1:  //198
                //执行添加方法
                if (resultCode == RESULT_OK) {
                    String[] key = data.getStringArrayExtra("key");
                    String[] values = data.getStringArrayExtra("values");
                    method.addData("UserInfo", key, values);
                }
                break;
            //请求码为2，表示点击了编辑按钮
            case 2:   //167
                //执行修改方法
                if (resultCode == RESULT_OK) {
                    User user = list.get(listNum);
                    String name = data.getStringExtra("name");
                    String phone = data.getStringExtra("phone");
                    String[] values = {name, phone, user.getName()};
                    method.update(values);
                }
                break;
        }
    }
}
