package com.grouptwo.ustcdiary.topicActivity.contact;


/**
 * Date:2019/10/26
 * Time:12:58
 * author:wenjun
 * 用于保存联系人信息的JavaBean
 */
public class User {
    private String name;
    private String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public User(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //重写toString方法
    public String toString() {
        return this.name + " - " + this.phone;
    }
}
