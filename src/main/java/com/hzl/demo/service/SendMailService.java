package com.hzl.demo.service;

import com.hzl.demo.pojo.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Auther: 志林
 * @Date: 2018/12/16 14:34
 * @Description:
 *//*
 * @program: springboot
 * @description: 邮件发送逻辑
 * @author: 志林
 * @create: 2018-12-16-14-34
 */
@Service
public class SendMailService {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender javaMailSender;
    //发送文本
    public void sendMailText(Mail mail){
        logger.info("发送文本邮件开始");
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(mail.getFrom());
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getContent());

        javaMailSender.send(simpleMailMessage);
        logger.info("send over");
    }
    public void sendMailHtml(Mail mail){
        logger.info("发送HTML邮件开始");
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent(),true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendMailAttach(Mail mail) {
        logger.info("发送附件邮件开始");
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper= null;
        try {
            helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent(),true);
            //设置附件,若发送多个附件，添加如下的多个就好啦
            FileSystemResource filestream=new FileSystemResource(new File(mail.getFilepath()));
            String filename=filestream.getFilename();
            helper.addAttachment(filename,filestream);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public void sendMailInlinResource(Mail mail) throws MessagingException {
        logger.info("发送带图片邮件开始");
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(mail.getFrom());
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getContent(),true);
        FileSystemResource res=new FileSystemResource(new File(mail.getImgpath()));
        String resId=mail.getImgId();
        helper.addInline(resId,res);
        javaMailSender.send(mimeMessage);
    }
}
