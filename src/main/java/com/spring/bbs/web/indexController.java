package com.spring.bbs.web;

import com.spring.bbs.dto.ResultInfo;
import com.spring.bbs.entity.Account;
import com.spring.bbs.entity.Comment;
import com.spring.bbs.service.RegisterService;
import com.spring.bbs.service.impl.RegisterServiceImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        /*
        * 结束session会话*/
        session.invalidate();
        request.getRequestDispatcher("login.html").forward(request,response);
    }
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    Object upload(HttpSession session,@RequestParam("task_title")String title, @RequestParam("type")String type, @RequestParam("details")String text, @RequestParam("pic")MultipartFile pic,HttpServletRequest request) throws ServletException, IOException {
        Account account= (Account) session.getAttribute("account");

        /*Comment comment=new Comment( account.getAccountName(),pic,text,title);*/
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setResult(true);
            System.out.println(title+type+text);
            // 获取图片原始文件名
            String originalFilename;
            originalFilename = pic.getOriginalFilename();
            System.out.println(originalFilename);
            // 文件名使用当前时间
            String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            // 获取上传图片的扩展名(jpg/png/...)
            String extension = FilenameUtils.getExtension(originalFilename);
            // 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
            String path = "\\User\\"+account.getAccountName()+"\\commentPicture\\" + name + "." + extension;
            // 图片上传的绝对路径
            String url = request.getSession().getServletContext().getRealPath("") + path;
            File dir = new File(url);
            if(!dir.exists()) {
                dir.mkdirs();
            }
            // 上传图片
            pic.transferTo(new File(url));
            return resultInfo;

    }
}
