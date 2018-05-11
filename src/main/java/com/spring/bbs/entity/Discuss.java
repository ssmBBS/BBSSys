package com.spring.bbs.entity;

import java.util.Date;

/**
 * @Description 回复类
 * @Author RickZhou
 * @date 2018/4/24-17:20
 * @Version 1.0
 */
public class Discuss {
    /**用户的id*/
    private String accountid;
    /**说说的id*/
    private Integer commentid;
    /**回复的内容*/
    private String content;
    /**回复对应的序列号 在该说说中的序列*/
    //unnecessary, order by time desc
    //private integer serialNo;
    /**回复的时间*/
    private Date createTime;

    public Discuss(String accountid, Integer commentid, String content){
        this.accountid = accountid;
        this.commentid = commentid;
        this.content = content;
        this.createTime=new Date();
    }

    public Discuss(String accountid, Integer commentid, String content, Date createTime) {
        this.accountid = accountid;
        this.commentid = commentid;
        this.content = content;
        this.createTime = createTime;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public integer getSerialNo() {
//        return serialNo;
//    }
//
//    public void setSerialNo(integer serialNo) {
//        this.serialNo = serialNo;
//    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
