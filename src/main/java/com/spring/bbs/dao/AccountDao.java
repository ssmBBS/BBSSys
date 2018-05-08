package com.spring.bbs.dao;

import com.spring.bbs.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author RickZhou
 * @date 2018/4/24-22:09
 * @Version 1.0
 */
@Repository
public interface AccountDao {
    public Account queryByName(@Param("accountName") String accountName);

    public List<Account> queryAll();
    public void insertAccount(@Param("accountName")String accountName,@Param("password") String password,@Param("email") String email);
}
