package com.teachingcash.saadmin.vo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NotificationVO {
    private int id;
    private String type;
    private String subject;
    private String content_editor;
    private String url;
    private String author;
    private int hit_count;
    private String enabled;
    private String push;
    private String push_to;
    private String push_msg;
    private String post_datetime;
    private String reg_datetime;

    private List<NotificationMemberVO> notificationMemberList;

    private int start;
    private int limit;

    private String keyword;

    private String search_enabled;
    private String search_subject;

    private String app_os;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent_editor() {
        return content_editor;
    }

    public void setContent_editor(String content_editor) {
        this.content_editor = content_editor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getHit_count() {
        return hit_count;
    }

    public void setHit_count(int hit_count) {
        this.hit_count = hit_count;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getPush() {
        return push;
    }

    public void setPush(String push) {
        this.push = push;
    }

    public String getPush_to() {
        return push_to;
    }

    public void setPush_to(String push_to) {
        this.push_to = push_to;
    }

    public String getPush_msg() {
        return push_msg;
    }

    public void setPush_msg(String push_msg) {
        this.push_msg = push_msg;
    }

    public String getPost_datetime() {
        return post_datetime;
    }

    public void setPost_datetime(String post_datetime) {
        this.post_datetime = post_datetime;
    }

    public String getReg_datetime() {
        return reg_datetime;
    }

    public void setReg_datetime(String reg_datetime) {
        this.reg_datetime = reg_datetime;
    }

    public List<NotificationMemberVO> getNotificationMemberList() {
        return notificationMemberList;
    }

    public void setNotificationMemberList(List<NotificationMemberVO> notificationMemberList) {
        this.notificationMemberList = notificationMemberList;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSearch_enabled() {
        return search_enabled;
    }

    public void setSearch_enabled(String search_enabled) {
        this.search_enabled = search_enabled;
    }

    public String getSearch_subject() {
        return search_subject;
    }

    public void setSearch_subject(String search_subject) {
        this.search_subject = search_subject;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApp_os() {
        return app_os;
    }

    public void setApp_os(String app_os) {
        this.app_os = app_os;
    }
}
