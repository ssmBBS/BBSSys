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
    public Object setJson(@RequestParam(value="name") String accountName,@RequestParam(value = "password") String password) throws IOException {
        //ObjectMapper类是Jackson库的主要类。它提供一些功能将java对象转换成json
        ObjectMapper mapper=new ObjectMapper();
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

    @RequestMapping(value = "/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/registerPage")
    public String registerPage(){
        return "register";
    }


}
