package com.spring.bbs.dao;

import com.spring.bbs.entity.Discuss;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description DiscussDao
 * @Author RickZhou
 * @date 2018/4/24-23:53
 * @Version 1.0
 */
@Repository
public interface DiscussDao {
    /**
     * 通过commentId获取discuss
     * order By createTime
     * @param id comment的id
     * @return
     */


    /**
     * 通过commentId 和 serialId 删除discuss
     * @param discuss 要删除的对象
     */
    void delete(Discuss discuss);

    /**
     * 插入
     * @param discuss
     */
    void insert(Discuss discuss);

    //没有更改功能
    /*获得指定id的comments*/
    List<Discuss>selectById(@Param("commentid")Integer commentid);

}
