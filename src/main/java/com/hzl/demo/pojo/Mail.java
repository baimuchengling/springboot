package com.hzl.demo.pojo;

/**
 * @Auther:
 * @Date: 2018/12/16 14:35
 * @Description:
 *//*
 * @program: springboot
 * @description:
 * @author:
 * @create: 2018-12-16-14-35
 */

public class Mail {
    private String from;
    private String to;
    private String subject;
    private String content;
    private String filepath;
    private String imgpath;
    private String imgId;
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }
}
