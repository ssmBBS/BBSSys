package com.spring.bbs.entity;

import java.util.Date;

/**
 * @Description 说说类
 * @Author 严旭江 Yan 873534617@qq.com
 * @date 2018/4/24-17:15
 * @Version 1.0
 */
public class Comment {
    /**id*/
    private Integer id;
    /**发起说说的账户id*/
    private Integer accountId;
    /**pic  说说里面的图片路径*/
    private String pic;
    /**点赞数目*/
    private Integer likes;
    /**comment的发起日期*/
    private Date commentDate;
    /**最新回复的日期*/
    private Date recentDate;

    public Comment(){

    }

    public Comment(Integer accountId, String pic) {
        this.accountId = accountId;
        this.pic = pic;
        this.likes = 0;
        this.commentDate = new Date();
        this.recentDate = new Date();
    }

    public Comment(Integer accountId, String pic, Integer likes, Date commentDate, Date recentDate) {
        this.accountId = accountId;
        this.pic = pic;
        this.likes = likes;
        this.commentDate = commentDate;
        this.recentDate = recentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Date getRecentDate() {
        return recentDate;
    }

    public void setRecentDate(Date recentDate) {
        this.recentDate = recentDate;
    }
}