package com.spring.bbs.web;

import com.spring.bbs.dao.CommentDao;
import com.spring.bbs.dao.DiscussDao;
import com.spring.bbs.dto.ResultInfo;
import com.spring.bbs.entity.Account;
import com.spring.bbs.entity.Comment;
import com.spring.bbs.entity.Discuss;
import com.spring.bbs.service.RegisterService;
import com.spring.bbs.service.impl.RegisterServiceImpl;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
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
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/27 0027.
 */
@Controller
public class indexController {
    @Autowired
    CommentDao commentDao;
    @Autowired
    DiscussDao discussDao;
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
    @RequestMapping(value = "/content")
    void doContent(@RequestParam("type") String type,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    session.setAttribute("type",type);
    request.getRequestDispatcher("content.html").forward(request,response);
    }
    @RequestMapping(value = "/blog")
    void doContent(@RequestParam("id") Integer id,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        session.setAttribute("id",id);
        request.getRequestDispatcher("content.html").forward(request,response);
    }
    /*查看我发的帖子*/
    @RequestMapping(value = "/myBlog")
    @ResponseBody
    Object myBlog(HttpSession session) {
       Account account= (Account) session.getAttribute("account");
       ResultInfo resultInfo=new ResultInfo();
       List<Comment>comments=commentDao.selectByName(account.getAccountName());
       resultInfo.setData(comments);
       return resultInfo;
    }
    /*获得对应id的帖子的所有回复*/
    @RequestMapping(value = "/getDisicuss")
    @ResponseBody
    Object getDisicuss(HttpSession session) {
        Integer id= (Integer) session.getAttribute("id");
        ResultInfo resultInfo=new ResultInfo();
        List<Discuss>discusses=discussDao.selectById(id);
        resultInfo.setData(discusses);
        Account account= (Account) session.getAttribute("account");
        resultInfo.setReason(account.getAccountName());
        return resultInfo;
    }
    @RequestMapping(value = "/getBlogById")
    @ResponseBody
    Object doContent(HttpSession session) throws ServletException, IOException {
        Integer id= (Integer) session.getAttribute("id");
        Comment comment=commentDao.selectById(id);
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setData(comment);
        return resultInfo;
    }
    @RequestMapping(value = "/addDiscuss")
    @ResponseBody
    Object addDiscuss(HttpSession session,@RequestParam("content")String content) throws ServletException, IOException {
        Integer id= (Integer) session.getAttribute("id");
        Account account= (Account) session.getAttribute("account");
        ResultInfo resultInfo=new ResultInfo();
        Discuss discuss=new Discuss(account.getAccountName(),id,content);
        discussDao.insert(discuss);
        resultInfo.setResult(true);
        resultInfo.setData(discuss);
        return resultInfo;
    }
    @RequestMapping(value = "/getContent")
    @ResponseBody
    Object getContent(@RequestParam("type") String type){
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setResult(true);
        List<Comment>comments=commentDao.selectByType(type);
        resultInfo.setData(comments);
        return resultInfo;
    }
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    void upload(@RequestParam("title")String title,@RequestParam("details")String text,@RequestParam("type")String type,@RequestParam("pic")MultipartFile pic,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account= (Account) session.getAttribute("account");
        System.out.println(title+text+type);
        String picPath=null;
        //*Comment comment=new Comment( account.getAccountName(),pic,text,title);*//*
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setResult(true);
            System.out.println(title+type+text);
            if(pic!=null){
                // 获取图片原始文件名
                String originalFilename;
                originalFilename = pic.getOriginalFilename();
                System.out.println(originalFilename);
                // 文件名使用当前时间
                String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                // 获取上传图片的扩展名(jpg/png/...)
                String extension = FilenameUtils.getExtension(originalFilename);
                File parent=new File(request.getSession().getServletContext()
                        .getRealPath("/")+"\\Users");
                if (!parent.exists() && !parent.isDirectory()) {
                    if (!parent.mkdir())
                        System.out.println("目录创建失败");
                }
                File parent0=new File(request.getSession().getServletContext()
                        .getRealPath("/")+"\\Users\\"+account.getAccountName());
                if (!parent0.exists() && !parent0.isDirectory()) {
                    if (!parent0.mkdir())
                        System.out.println("目录创建失败");
                }
                File parent1=new File(request.getSession().getServletContext()
                        .getRealPath("/")+"\\Users\\"+account.getAccountName()+"\\commentPicture");
                if (!parent1.exists() && !parent1.isDirectory()) {
                    if (!parent1.mkdir())
                        System.out.println("目录创建失败");
                }
                // 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
                String path = "Users\\"+account.getAccountName()+"\\commentPicture\\" + name + "." + extension;
                // 图片上传的绝对路径
                String url = request.getSession().getServletContext().getRealPath("") + path;
                File dir = new File(url);
                if(!dir.exists()) {
                    dir.mkdirs();
                }
                // 上传图片
                pic.transferTo(new File(url));
                picPath=path;
            }
            else {
                picPath="";
            }
        Comment comment=new Comment(account.getAccountName(),picPath,text,title,type);
        commentDao.insert(comment);
        request.getRequestDispatcher("mainPage.html").forward(request,response);
    }
}
