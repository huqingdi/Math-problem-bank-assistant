package com.example.expandablelist.bean;

/**
 * Created by 增冠 on 2018/8/17.
 */

public class TypeBean {
    public int category;
    public String name = "知识点";

    public TypeBean(int i,int lei) {
        this.name =lei+"级第"+(i+1)+"个"+name;
        category=lei;
    }
}
