package com.spring.bbs.web;

import com.spring.bbs.dto.ResultInfo;
import com.spring.bbs.entity.Account;
import com.spring.bbs.service.RegisterService;
import com.spring.bbs.service.impl.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
 *         Created by RickZhou on 2018/4/27 0027.
 */
@Controller
public class indexController {
    @RequestMapping(value = "/mainPage")
    @ResponseBody
    Object mainPage(HttpSession session){
        ResultInfo resultInfo=new ResultInfo();
        Account account= (Account) session.getAttribute("account");
        resultInfo.setData(account);
        return resultInfo;
    }
    @RequestMapping(value = "/outLogin")
    void outLogin(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        session.invalidate();
        request.getRequestDispatcher("login.html").forward(request,response);
    }

}
