package com.spring.bbs.service.impl;

import com.spring.bbs.dao.AccountDao;
import com.spring.bbs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户业务Service
 * @Author 严旭江 Yan 873534617@qq.com
 * @date 2018/4/24-17:26
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;
}
