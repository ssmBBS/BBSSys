package com.spring.bbs.entity;

import java.util.Date;

/**
 * @Description 聊天记录
 * @Author 严旭江 Yan 873534617@qq.com
 * @date 2018/4/24-17:24
 * @Version 1.0
 */
public class ChatRecord {
    /**两天二者的id*/
    private Integer account1Id;
    private Integer account2Id;
    /**聊天的时间*/
    private Date chatTime;
    /**聊天的内容*/
    private String content;

    public ChatRecord(){

    }

    public ChatRecord(Integer account1Id, Integer account2Id, String content) {
        this.account1Id = account1Id;
        this.account2Id = account2Id;
        chatTime = new Date();
        this.content = content;
    }

    public Integer getAccount1Id() {
        return account1Id;
    }

    public void setAccount1Id(Integer account1Id) {
        this.account1Id = account1Id;
    }

    public Integer getAccount2Id() {
        return account2Id;
    }

    public void setAccount2Id(Integer account2Id) {
        this.account2Id = account2Id;
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
