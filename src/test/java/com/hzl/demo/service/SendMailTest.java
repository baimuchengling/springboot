package com.hzl.demo.service;

import com.hzl.demo.pojo.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @Auther:
 * @Date: 2018/12/16 15:29
 * @Description:
 *//*
 * @program: springboot
 * @description:
 * @author:
 * @create: 2018-12-16-15-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailTest {
    @Resource
    SendMailService sendMailService;
    @Test
    public void SendMailTextTest(){
        Mail mail=new Mail();
        mail.setFrom("1119641581@qq.com");
        mail.setTo("1119641581@qq.com");
        mail.setSubject("我的java实现发text邮件功能mail");
        mail.setContent("今天是2018年12月16日，我在用java写发送邮件的功能！");
        sendMailService.sendMailText(mail);
        System.out.println("send text mail success!");
    }

    @Test
    public void SendMailHtmlTest(){
        String content="<html>\n"+"<body>\n"+"<h2><b>"+"这是我的第一封html的邮件"+"</b></h2>\n"
                +"</body></html>";
        Mail mail=new Mail();
        mail.setFrom("1119641581@qq.com");
        mail.setTo("1119641581@qq.com");
        mail.setSubject("我的java实现发html邮件功能mail");
        mail.setContent(content);
        sendMailService.sendMailHtml(mail);
        System.out.println("send html mail success!");
    }
    @Test
    public void SendMailAttachTest(){
        String content="<html>\n"+"<body>\n"+"<h2><b>"+"这是我的第一封html的邮件"+"</b></h2>\n"
                +"</body></html>";
        String filepath="/Users/zhilin/Documents/test.pages";
        Mail mail=new Mail();
        mail.setFrom("1119641581@qq.com");
        mail.setTo("1119641581@qq.com");
        mail.setSubject("我的java实现发带附件attach邮件功能mail");
        mail.setContent(content);
        mail.setFilepath(filepath);
        sendMailService.sendMailAttach(mail);
        System.out.println("send attach mail success!");
    }
    @Test
    public void sendMailInlinResourceTest() throws MessagingException {
        String imgId="001";
        String content="<html>\n"+"<body>\n"+"<h2><b>"+"这是我的第一封带插入图片的邮件"+"</b></h2>\n"
                +"<img src=\'cid:"+imgId+"\'></img>\n"
                +"结束"+"</body></html>";
        String imgpath="/Users/zhilin/Documents/mac命令总结.pages";

        Mail mail=new Mail();
        mail.setFrom("1119641581@qq.com");
        mail.setTo("1119641581@qq.com");
        mail.setSubject("我的java实现发插入图片邮件功能mail");
        mail.setContent(content);
        mail.setImgpath(imgpath);
        mail.setImgId(imgId);
        sendMailService.sendMailInlinResource(mail);
        System.out.println("send attach mail success!");
    }
}
