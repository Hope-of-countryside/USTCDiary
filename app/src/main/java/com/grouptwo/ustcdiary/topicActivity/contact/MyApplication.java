package com.grouptwo.ustcdiary.topicActivity.contact;

import android.app.Application;

/**
 * Date:2019/10/26
 * Time:13:42
 * author:wenjun
 * 如果没有在manifest中配置这个，则回闪退
 */
public class MyApplication extends Application {
    private DatabaseMethod method;

    /**
     * 创建时调用
     * */
    @Override
    public void onCreate() {
        super.onCreate();
        method = new DatabaseMethod(this);
    }

    /**
     * 后台进程终止，前台程序需要内存时调用此方法，用于释放内存
     * 用于关闭数据库连接
     * */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        method.getClose();
    }

    public DatabaseMethod getMethod(){
        return method;
    }

}
