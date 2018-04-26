package com.spring.bbs.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.bbs.dto.ResultInfo;
import com.spring.bbs.entity.Account;
import com.spring.bbs.service.AccountService;
import com.spring.bbs.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/25 0025.
 */
@Controller
public class UserController {
    @Autowired
    AccountService accountService;
    @RequestMapping(value = "/register")
    public ModelAndView register(){
    ModelAndView modelAndView=new ModelAndView();
    accountService.insert("rick","123456","819894286@qq.com");
    List<Account> accounts=accountService.getAllAccounts();
    modelAndView.addObject("accounts",accounts);
    modelAndView.setViewName("success");
    return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object setJson(@RequestParam(value="accountName") String accountName,@RequestParam(value = "password") String password) throws IOException {
        //ObjectMapper类是Jackson库的主要类。它提供一些功能将java对象转换成json
        ResultInfo resultInfo=new ResultInfo();
        boolean judge=accountService.isAccount(accountName,password);
        if(judge==false){
            resultInfo.setResult(judge);
            Account account=null;
            resultInfo.setData(account);
        }
        else {
            resultInfo.setResult(judge);
            Account account=accountService.getAccount(accountName);
        }
        return resultInfo;

    }

    @RequestMapping(value = "/validate")
    @ResponseBody
    public Object registValidate(@RequestParam(value="accountName") String accountName,@RequestParam(value = "email") String email){
        ResultInfo resultInfo=new ResultInfo();
        List<Account> accounts=accountService.getAllAccounts();
        boolean result=true;
        String reason="";
        for(Account account:accounts){
            if(account.getAccountName().equals(accountName)){
                result=false;
                reason="name";
                resultInfo.setResult(result);
                resultInfo.setReason(reason);
                return resultInfo;
            }
            if(account.getEmail().equals(email)){
                result=false;
                reason="email";
                resultInfo.setResult(result);
                resultInfo.setReason(reason);
                return resultInfo;
            }
        }
        resultInfo.setResult(result);
        return resultInfo;
    }

    @RequestMapping(value = "/registerPage")
    public String registerPage(){
        return "register";
    }


}
