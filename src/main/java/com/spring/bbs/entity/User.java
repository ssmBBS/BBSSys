package com.spring.bbs.entity;

/**
 * @Description 用户类
 * @Author 严旭江 Yan 873534617@qq.com
 * @date 2018/4/24-12:52
 * @Version 1.0
 */
public class User {
    private Integer id;
    private String userName;
    private String password;

    public User(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
