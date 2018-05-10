package com.spring.bbs.entity;

import java.util.Date;

/**
 * @Description 说说类
 * @Author 严旭江 Yan 873534617@qq.com
 * @date 2018/4/24-17:15
 * @Version 1.0
 */
public class Comment {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**id*/
    private Integer id;
    /**发起说说的账户id*/
    private String accountid;
    /**pic  说说里面的图片路径*/
    private String pic;
    /**点赞数目*/
    private Integer likes;
    /**comment的发起日期*/
    private Date commentDate;
    /**最新回复的日期*/
    private Date recentDate;


    /*说说的类型*/
    private String type;
    /*内容*/
    private String content;
    /*comment的title*/
    private String title;
    public Comment(){

    }

    public Comment(String accountid, String pic) {
        this.accountid = accountid;
        this.pic = pic;
        this.likes = 0;
        this.commentDate = new Date();
        this.recentDate = new Date();
    }
    public Comment(String accountid, String pic,String content,String title,String type){
      this.accountid=accountid;
        this.pic = pic;
        this.likes = 0;
        this.commentDate = new Date();
        this.recentDate = new Date();
        this.content=content;
        this.title=title;
        this.type=type;
    }
    public Comment(Integer id,String accountid, String pic, Integer likes, Date commentDate, Date recentDate,String content,String title,String type) {
        this.id=id;
        this.accountid = accountid;
        this.pic = pic;
        this.likes = likes;
        this.commentDate = commentDate;
        this.recentDate = recentDate;
        this.content=content;
        this.title=title;
        this.type=type;
    }



}
