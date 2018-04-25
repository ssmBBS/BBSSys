package com.spring.bbs.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/25 0025.
 */
public class SendEmail {
    Properties props = new Properties();
    public static void send(String toEmail , String content) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.163.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            MailSSLSocketFactory sf = null;
            sf = new MailSSLSocketFactory();
            // 设置信任所有的主机
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);

            Session session = Session.getDefaultInstance(props, new Authenticator(){
                @Override
                public PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("yxj873534617@163.com","w8t4u1314");
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("yxj873534617@163.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("账号激活邮件");
            message.setContent(content , "text/html;charset=utf-8");
            //message.setText("sb");
            Transport.send(message);

        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
