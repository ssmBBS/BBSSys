package com.spring.bbs.service.impl;

import com.spring.bbs.entity.Account;
import com.spring.bbs.service.AccountService;
import com.spring.bbs.service.RegisterService;
import com.spring.bbs.utils.MD5Util;
import com.spring.bbs.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.rpc.ServiceException;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/27 0027.
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    private Account account;
    @Autowired
    AccountService accountService;
    @Override
    public void RegisterValidate(String accountName, String password, String email) {
        account=new Account();
        account.setAccountName(accountName);
        account.setPassword(password);
        account.setEmail(email);
        System.out.print(email);
        account.setActivadeCode(MD5Util.encode2hex(email));
        ///邮件的内容


        StringBuffer sb=new StringBuffer("尊敬的"+account.getAccountName()+":<br>"+"点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"http://localhost:8080/activate.do?activecode=");
        /*sb.append(email);
        sb.append("&validateCode=");*/
        sb.append(account.getActivadeCode());
        sb.append("\">");
        sb.append("点我激活注册");
        sb.append("</a>");

        //发送邮件
        SendEmail.send(email, sb.toString());
        System.out.println("发送邮件");
    }

    @Override
    public void processActivate(String validateCode) throws ServiceException {
        if(account!=null) {
            //验证用户激活状态
            if(account.getStatus()==0) {
                ///没激活
                    //验证激活码是否正确
                    if(validateCode.equals(account.getActivadeCode())) {
                        //激活成功， //并更新用户的激活状态，为已激活

                        System.out.println("==sq==="+account.getStatus());
                        account.setStatus(1);//把状态改为激活
                        System.out.println("==sh==="+account.getStatus());
                       accountService.insert(account.getAccountName(),account.getPassword(),account.getEmail());

                    } else {
                        throw new ServiceException("激活码不正确");
                    }

            } else {
                throw new ServiceException("邮箱已激活，请登录！");
            }
        } else {
            throw new ServiceException("该邮箱未注册（邮箱地址不存在）！");
        }

    }
    @Override
    public Account getAccount() {
        return account;
    }
}
