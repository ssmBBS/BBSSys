package com.spring.bbs.service.impl;

import com.spring.bbs.dao.AccountDao;
import com.spring.bbs.entity.Account;
import com.spring.bbs.service.AccountService;
import com.spring.bbs.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 用户业务Service
 * @Author RickZhou
 * @date 2018/4/24-17:26
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    static AccountDao accountDao;
    /*
    *
    * 检查该用户是否存在*/
    @Override
    public boolean isAccount(String accountName, String password) {
        List<Account>accounts=accountDao.queryAll();
        for (Account account:accounts){
            if(account.getAccountName().equals(accountName)&&account.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    /*
    * 获得所有的Account用户
    * */
    @Override
    public List<Account> getAllAccounts() {
        return accountDao.queryAll();
    }
    /*
       * 注册插入用户*/
    @Override
    public void RegisterValidate(String email,String accountName,String password) {
        Account account=new Account();
        account.setAccountName(accountName);
        StringBuffer sb=new StringBuffer("尊敬的"+account.getAccountName()+":<br>"+"点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"http://localhost:8080/magic/register.do?action=activate&activecode=");
        sb.append(account.getActivadeCode());
        sb.append("\">");
        sb.append("点我激活注册");
        sb.append("</a>");

        //发送邮件
        SendEmail.send(email, sb.toString());
        System.out.println("发送邮件");
    }

}
