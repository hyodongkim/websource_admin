package com.teachingcash.saadmin.vo;

public class QuoteVO {
    private int pk_quote;
    private String name;
    private String lastname;
    private String email;
    private String country;
    private String phone;
    private String platform;
    private String initial_cost;
    private String use_area;
    private String active_user_num;
    private String max_concurrent_users;
    private String service_num;
    private String app_num;
    private String is_agree;
    private String ip;
    private String reg_timestamp;
    private String process_yn;

    private int start;
    private int limit;

    private String field;
    private String keyword;

    public int getPk_quote() {
        return pk_quote;
    }

    public void setPk_quote(int pk_quote) {
        this.pk_quote = pk_quote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getInitial_cost() {
        return initial_cost;
    }

    public void setInitial_cost(String initial_cost) {
        this.initial_cost = initial_cost;
    }

    public String getActive_user_num() {
        return active_user_num;
    }

    public void setActive_user_num(String active_user_num) {
        this.active_user_num = active_user_num;
    }

    public String getMax_concurrent_users() {
        return max_concurrent_users;
    }

    public void setMax_concurrent_users(String max_concurrent_users) {
        this.max_concurrent_users = max_concurrent_users;
    }

    public String getService_num() {
        return service_num;
    }

    public void setService_num(String service_num) {
        this.service_num = service_num;
    }

    public String getApp_num() {
        return app_num;
    }

    public void setApp_num(String app_num) {
        this.app_num = app_num;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getReg_timestamp() {
        return reg_timestamp;
    }

    public void setReg_timestamp(String reg_timestamp) {
        this.reg_timestamp = reg_timestamp;
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

    public String getUse_area() {
        return use_area;
    }

    public void setUse_area(String use_area) {
        this.use_area = use_area;
    }

    public String getProcess_yn() {
        return process_yn;
    }

    public void setProcess_yn(String process_yn) {
        this.process_yn = process_yn;
    }

    public String getIs_agree() {
        return is_agree;
    }

    public void setIs_agree(String is_agree) {
        this.is_agree = is_agree;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
