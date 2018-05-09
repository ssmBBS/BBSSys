package com.spring.bbs.service;

import com.spring.bbs.entity.Comment;

import java.util.List;

/**
 * @Description TODO
 * @Author RickZhou
 * @date 2018/4/24-17:27
 * @Version 1.0
 */
public interface CommentService {
    List<Comment>serchByName(String accountName);
    void insertComment(Comment comment);
}
