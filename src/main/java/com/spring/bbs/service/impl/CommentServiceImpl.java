package com.spring.bbs.service.impl;

import com.spring.bbs.dao.CommentDao;
import com.spring.bbs.entity.Comment;
import com.spring.bbs.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author RickZhou
 * @date 2018/4/24-17:28
 * @Version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Override
    public List<Comment> serchByName(String accountName) {
        return commentDao.selectByName(accountName);
    }

    @Override
    public void insertComment(Comment comment) {
        commentDao.insert(comment);
    }

   /* public static void main(String []args){
        Comment comment=new Comment("rick","aa","hello","123");
        commentDao.insert(comment);
    }*/
}
