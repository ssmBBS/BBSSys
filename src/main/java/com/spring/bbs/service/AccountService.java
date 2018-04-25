package com.spring.bbs.service;

import com.spring.bbs.entity.Account;

import java.util.List;

/**
 * @Description TODO
 * @Author RickZhou
 * @date 2018/4/24-17:27
 * @Version 1.0
 */
public interface AccountService {
    Account getAccount(String name);
    boolean isAccount(String accountName,String password);
    List<Account> getAllAccounts();
    void insert(String name,String password,String email);
    void RegisterValidate(String email,String account,String password);
}
