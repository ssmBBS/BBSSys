package com.spring.bbs.dao;

import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author 严旭江 Yan 873534617@qq.com
 * @date 2018/4/24-22:09
 * @Version 1.0
 */
@Repository
public interface AccountDao {
    AccountDao findAccount(String accountName,String password);
}
