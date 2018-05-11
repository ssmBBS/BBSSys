package com.spring.bbs.dao;

import com.spring.bbs.entity.FriendRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/5/11 0011.
 */
public interface FriendDao {
    List<FriendRelation>selectByName(@Param("accountid")String accountid);
    void insert(FriendRelation friendRelation);
    void insertByName(@Param("account1id")String accountName,@Param("account2id")String friendName);
}
