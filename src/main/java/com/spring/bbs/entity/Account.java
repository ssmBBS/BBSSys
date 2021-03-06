package com.spring.bbs.entity;

import java.util.Date;

/**
 * @Description 用户类
 * @Author 严旭江 Yan 873534617@qq.com
 * @date 2018/4/24-12:52
 * @Version 1.0
 */
public class Account {
    /**用户的id*/
    private Integer id;
    /**账号名字 用于登录*/
    private String accountName;
    /**账户密码*/
    private String password;
    /**账户的头像路径*/
    private String picPath;
    /**email*/
    private String email;
    /**账户的权限*/
    private Integer rights;
    /* 用户验证码*/
    private String activadeCode;
    /*注册时间*/
    private Date date=new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /*验证用户状态*/
    private int status=0;

    public String getActivadeCode() {
        return activadeCode;
    }

    public void setActivadeCode(String activadeCode) {
        this.activadeCode = activadeCode;
    }

    public Account(){

    }

    public Account(String accountName, String password, String email, Integer rights) {
        this.accountName = accountName;
        this.password = password;
        this.email = email;
        this.rights = rights;
    }

    public Account(String accountName, String password, String picPath, String email, Integer rights) {
        this.accountName = accountName;
        this.password = password;
        this.picPath = picPath;
        this.email = email;
        this.rights = rights;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRights() {
        return rights;
    }

    public void setRights(Integer rights) {
        this.rights = rights;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
