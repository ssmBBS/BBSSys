package com.spring.bbs.service;

import com.spring.bbs.entity.Account;

import javax.xml.rpc.ServiceException;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/27 0027.
 */
public interface RegisterService {
    void RegisterValidate(String accountName,String password,String email);
    void processActivate( String validateCode) throws ServiceException;
    Account getAccount();
}
