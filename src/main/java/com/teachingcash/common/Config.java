package com.teachingcash.common;

public class Config {
    private String uploadPath;
    private String fcm_push_key;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getFcm_push_key() {
        return fcm_push_key;
    }

    public void setFcm_push_key(String fcm_push_key) {
        this.fcm_push_key = fcm_push_key;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //public static String uploadPath = "/home/gritdev01/tc_user/upload/";
}
