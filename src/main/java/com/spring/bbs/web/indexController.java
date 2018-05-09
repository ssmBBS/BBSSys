package com.spring.bbs.web;

import com.spring.bbs.dto.ResultInfo;
import com.spring.bbs.entity.Account;
import com.spring.bbs.entity.Comment;
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
    void upload(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Account account= (Account) session.getAttribute("account");
        String title=request.getParameter("title");
        String type=request.getParameter("type");
        String text=request.getParameter("details");
        *//*Comment comment=new Comment( account.getAccountName(),pic,text,title);*//*
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
            return resultInfo;*/
        String title=null;
        String type=null;
        String text=null;
        ResultInfo resultInfo=new ResultInfo();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setFileSizeMax(1024 * 1024);
        Account account= (Account) session.getAttribute("account");
        FileItemIterator items = null;
        try {
            items = sfu.getItemIterator(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        String contextPathString = request.getSession().getServletContext()
                .getRealPath("/");
        // 文件名使用当前时间
        String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String path= "Users\\"+account.getAccountName()+"\\commentPicture";
        contextPathString +=path;
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
        File parentfile = new File(contextPathString);
        if (!parentfile.exists() && !parentfile.isDirectory()) {
            if (!parentfile.mkdir())
                System.out.println("目录创建失败");
        }
        FileItemStream fileItemStream = null;
        String fieldName = null;
        InputStream inputStream = null;
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while (items.hasNext()) {
                fileItemStream = items.next();
                try {
                    inputStream = fileItemStream.openStream();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    System.out.println("图片太大了！");
                    resultInfo.setResult(false);
                    return;
                }
                /*提取非图片部分*/
                if (fileItemStream.isFormField()) {
                    fieldName = new String(fileItemStream.getFieldName().getBytes(
                            "ISO-8859-1"), "utf-8");
                    if (fieldName.equals("title")) {
                        title = Streams.asString(inputStream, "utf-8");

                    } else if (fieldName.equals("type")) {
                        type = Streams.asString(inputStream, "utf-8");

                    } else if (fieldName.equals("details")) {
                        text = Streams.asString(inputStream, "utf-8");
                    }
                    } else {

                    }
                    continue;
                }
            String fileName=name+".jpg";
            File mFile = new File(parentfile, fileName);
            bos = new BufferedOutputStream(new FileOutputStream(mFile));
            bis = new BufferedInputStream(inputStream);
            try {
                while ((len = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                }

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("图片太大了！");
                resultInfo.setResult(false);
              return;
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("main.html").forward(request,response);
    }
}
