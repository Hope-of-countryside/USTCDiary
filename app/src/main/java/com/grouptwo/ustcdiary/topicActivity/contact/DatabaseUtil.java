package com.grouptwo.ustcdiary.topicActivity.contact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Date:2019/10/26
 * Time:12:41
 * author:wenjun
 * 数据库操作类，需要继承SQLiteOpenHelper
 */
    public class DatabaseUtil extends SQLiteOpenHelper {
        //数据库名称
        private static final String DATABASE_NAME = "PhoneBook.db";
        //版本号
        private static final int DATABASE_VERSION = 1;

        public DatabaseUtil(Context context){

            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        //在onCreate方法中操作数据库
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            createTable(sqLiteDatabase);
        }


        // 第一次操作数据库的时候 新建表 只调用一次
        private void createTable(SQLiteDatabase db){
            //执行sql语句
            db.execSQL("create table UserInfo(" +
                    "id integer primary key autoincrement," +
                    "userName text," +
                    "userPhone text)");
        }

        // 当版本号version改变才调用
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "create table user(username varchar,pwd varchar)";
            db.execSQL(sql);
        }
    }

