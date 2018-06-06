package com.kbq.component.base.model.bean;

/**
 * Author: 柯葆青
 * Date: 2018/06/06
 * Description: 用户信息实体类
 */
public class UserBean {
    private int id;
    private String name;

    public UserBean() {
    }

    public UserBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
