package com.spring.bbs.dao;

import com.spring.bbs.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author RickZhou
 * @date 2018/4/25-17:24
 * @Version 1.0
 */
@Repository
public interface CommentDao {
    /**查询所有的comment  默认按照最近回复时间降序*/
    List<Comment> select();
    /**查询功能 like  %content% */
    List<Comment> selectByKey(@Param("key")String key);
    /**插入一个新的comment*/
    int insert(Comment comment);
    /**delete a comment*/
    int delete(Comment comment);
    /**update*/
    int update(Comment comment);

    /**获取总数*/
    int selectCount();
    /*获取指定用户所发的Comment*/
    List<Comment> selectByName(@Param("accountName")String accountName);
    /*获取指定类型的Comment*/
    List<Comment> selectByType(@Param("type")String type);
}
