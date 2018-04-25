package com.spring.bbs.web;

import com.spring.bbs.entity.Account;
import com.spring.bbs.service.AccountService;
import com.spring.bbs.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
}
