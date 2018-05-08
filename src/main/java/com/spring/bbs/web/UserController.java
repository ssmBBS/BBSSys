package com.spring.bbs.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.bbs.dto.ResultInfo;
import com.spring.bbs.entity.Account;
import com.spring.bbs.service.AccountService;
import com.spring.bbs.service.RegisterService;
import com.spring.bbs.service.impl.AccountServiceImpl;
import com.spring.bbs.service.impl.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/25 0025.
 */
@Controller
public class UserController {
    @Autowired
    RegisterService registerService;
    @Autowired
    AccountService accountService;
    /*
    * 处理登陆页面请求*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object setJson(@RequestParam(value="accountName") String accountName,@RequestParam(value = "password") String password,HttpSession session) throws IOException {
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
            session.setAttribute("account",account);
        }
        return resultInfo;

    }
    /*
    *验证用户名或邮箱是否存在 */
    @RequestMapping(value = "/validate",method = RequestMethod.POST)
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
    @RequestMapping(value = "/registor",method = RequestMethod.POST)
    @ResponseBody
    public Object register(HttpServletRequest request,HttpServletResponse response,HttpSession session,@RequestParam(value = "accountName")String accountName, @RequestParam(value = "password")String password, @RequestParam(value = "email")String email) throws ServletException, IOException {
        registerService.RegisterValidate(accountName, password, email);//发邮箱激活
        session.getServletContext().setAttribute("service",registerService);
        session.setAttribute("account",registerService.getAccount());
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setResult(true);
        Account account=null;
        resultInfo.setData(account);
        return resultInfo;
    }
    @RequestMapping(value = "/activate")
    public void activate(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam(value = "activecode")String validateCode) throws ServletException, IOException, ServiceException {
        RegisterService service= (RegisterServiceImpl)session.getServletContext().getAttribute("service");
        service.processActivate(validateCode);//调用激活方法
        String contextPathString = session.getServletContext()
                .getRealPath("/");
        System.out.println(contextPathString);
        String id=service.getAccount().getAccountName();
        contextPathString += "Users";
        System.out.println(contextPathString);
        File parentfile = new File(contextPathString);
        if (!parentfile.exists() && !parentfile.isDirectory()) {
            if (!parentfile.mkdir())
                System.out.println("目录创建失败");
        }
        contextPathString+="\\"+id;
        System.out.println(contextPathString);
        File parentfile0 = new File(contextPathString);
        if (!parentfile0.exists() && !parentfile0.isDirectory()) {
            if (!parentfile0.mkdir())
                System.out.println("目录创建失败");
        }
        String comment=contextPathString+"\\commentPicture";
        System.out.println(comment);
        File parentfile1 = new File(comment);
        if (!parentfile1.exists() && !parentfile1.isDirectory()) {
            if (!parentfile1.mkdir())
                System.out.println("目录创建失败");
        }
        String picture=contextPathString+"\\picture";
        System.out.println(picture);
        File parentfile2 = new File(picture);
        if (!parentfile2.exists() && !parentfile2.isDirectory()) {
            if (!parentfile2.mkdir())
                System.out.println("目录创建失败");
        }
        Account account=service.getUser();
        session.setAttribute("account",account);
        request.getRequestDispatcher("register_success.html").forward(request,response);
    }
    @RequestMapping(value = "/registerPage")
    public String registerPage(){
        return "register";
    }


}
