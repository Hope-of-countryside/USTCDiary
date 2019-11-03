package com.grouptwo.ustcdiary.topicActivity.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2019/10/26
 * Time:12:48
 * author:wenjun
 */
public class DatabaseMethod {

    private DatabaseUtil du;
    private SQLiteDatabase db;

    //构造器
    public DatabaseMethod(Context context){
        du = new DatabaseUtil(context);
        /**SQLiteOpenHelper的子类通过getReadableDatabase()和getWritableDatabase()
        方法来获取 SQLiteDatabase实例对象，并保证以同步方式访问，相当于打开数据库db
         */
        db = du.getWritableDatabase();
    }


     // 添加数据
    public void addData(String tableName, String[] key, String[] values){
        ContentValues contentValues = new ContentValues();
        for(int i = 0; i < key.length; i ++){
            contentValues.put(key[i],values[i]);
        }
        /**
         * 调用sqLite的方法
         * 第一个参数是表名称。
         * 第二个参数是空列的默认值。
         * 第三个参数是ContentValues封装的列的名称和对应的列值。
         */

        db.insert(tableName,null,contentValues);
        contentValues.clear();
    }

    //删除数据
    public int delData(String where, String[] values){
        int del_data;
        //直接调用delete来删除
        del_data = db.delete("UserInfo",where,values);
        return del_data;
    }


    //修改数据
    public void update(String[] values){
        db.execSQL("update UserInfo set userName=?,userPhone=? where userName=? ",values);
    }

    //查询数据
    public List<User> inquireData(){
        List<User> list = new ArrayList<>();
        /**
         * 在 Android 中通过 Cursor 类来实现，
         * 使用 SQLiteDatabase.query() 方法会得到一个 Cursor 对象。
         */
        Cursor cursor = db.rawQuery("select userName,userPhone" +
                " from UserInfo",null);
        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            String phone = cursor.getString(1);

            //用javabean封装数据
            User user = new User();
            user.setName(name);
            user.setPhone(phone);
            list.add(user);
        }

        return list;
    }

    //根据名字查询数据
    public  User inquireData(String Findname){
        User seacherUser = null;
        Cursor cursor = db.query("UserInfo",null,"name=?",new  String[]{"Findname"},null,null,null);
        while(cursor.moveToNext()) {
            String name = cursor.getString(0);
            String phone = cursor.getString(1);
            seacherUser = new User();
            seacherUser.setName(name);
            seacherUser.setPhone(phone);
        }
        return seacherUser;
    }

    //关闭数据库连接
    public void getClose(){
        if(db != null){
            db.close();
        }
    }
}
