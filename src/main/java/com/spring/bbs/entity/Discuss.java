package com.spring.bbs.entity;

import java.util.Date;

/**
 * @Description 回复类
 * @Author 严旭江 Yan 873534617@qq.com
 * @date 2018/4/24-17:20
 * @Version 1.0
 */
public class Discuss {
    /**用户的id*/
    private Integer accountId;
    /**说说的id*/
    private Integer commentId;
    /**回复的内容*/
    private String content;
    /**回复对应的序列号 在该说说中的序列*/
    //unnecessary, order by time desc
    //private Integer serialNo;
    /**回复的时间*/
    private Date createTime;

    public Discuss(){

    }

    public Discuss(Integer accountId, Integer commentId, String content) {
        this.accountId = accountId;
        this.commentId = commentId;
        this.content = content;
        //this.serialNo = 1;//初始序列号为1
        this.createTime = new Date();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public Integer getSerialNo() {
//        return serialNo;
//    }
//
//    public void setSerialNo(Integer serialNo) {
//        this.serialNo = serialNo;
//    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
