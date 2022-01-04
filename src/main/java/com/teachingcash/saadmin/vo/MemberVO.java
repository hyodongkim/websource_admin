package com.teachingcash.saadmin.vo;

import org.stringtemplate.v4.ST;

public class MemberVO {
    private int id;
    private String type;
    private String name;
    private String email;
    private String pin;
    private String sns_naver_yn;
    private String sns_naver_id;
    private String sns_naver_datetime;
    private String sns_kakao_yn;
    private String sns_kakao_id;
    private String sns_kakao_datetime;
    private String sns_facebook_yn;
    private String sns_facebook_id;
    private String sns_facebook_datetime;
    private String sns_apple_yn;
    private String sns_apple_id;
    private String sns_apple_datetime;
    private int num_of_business;
    private String app_os;
    private String app_token;
    private String signup_date;
    private String phone;
    private String agree_sms;
    private String agree_email;
    private String agree_push_notification;
    private String agree_push_marketing;
    private String recent_access;
    private String enabled;
    private String leave_datetime;
    private String reg_datetime;

    private int start;
    private int limit;

    private String search_signup_date;
    private String search_signup_date_start;
    private String search_signup_date_end;

    private String search_leave_date_start;
    private String search_leave_date_end;

    private String search_type;
    private String search_name;
    private String search_email;
    private String search_enabled;

    private int deleteFileSeq;

    private String files_id;
    private String original_name;
    private String upload_path;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getSns_naver_yn() {
        return sns_naver_yn;
    }

    public void setSns_naver_yn(String sns_naver_yn) {
        this.sns_naver_yn = sns_naver_yn;
    }

    public String getSns_naver_id() {
        return sns_naver_id;
    }

    public void setSns_naver_id(String sns_naver_id) {
        this.sns_naver_id = sns_naver_id;
    }

    public String getSns_naver_datetime() {
        return sns_naver_datetime;
    }

    public void setSns_naver_datetime(String sns_naver_datetime) {
        this.sns_naver_datetime = sns_naver_datetime;
    }

    public String getSns_kakao_yn() {
        return sns_kakao_yn;
    }

    public void setSns_kakao_yn(String sns_kakao_yn) {
        this.sns_kakao_yn = sns_kakao_yn;
    }

    public String getSns_kakao_id() {
        return sns_kakao_id;
    }

    public void setSns_kakao_id(String sns_kakao_id) {
        this.sns_kakao_id = sns_kakao_id;
    }

    public String getSns_kakao_datetime() {
        return sns_kakao_datetime;
    }

    public void setSns_kakao_datetime(String sns_kakao_datetime) {
        this.sns_kakao_datetime = sns_kakao_datetime;
    }

    public String getSns_facebook_yn() {
        return sns_facebook_yn;
    }

    public void setSns_facebook_yn(String sns_facebook_yn) {
        this.sns_facebook_yn = sns_facebook_yn;
    }

    public String getSns_facebook_id() {
        return sns_facebook_id;
    }

    public void setSns_facebook_id(String sns_facebook_id) {
        this.sns_facebook_id = sns_facebook_id;
    }

    public String getSns_facebook_datetime() {
        return sns_facebook_datetime;
    }

    public void setSns_facebook_datetime(String sns_facebook_datetime) {
        this.sns_facebook_datetime = sns_facebook_datetime;
    }

    public String getSns_apple_yn() {
        return sns_apple_yn;
    }

    public void setSns_apple_yn(String sns_apple_yn) {
        this.sns_apple_yn = sns_apple_yn;
    }

    public String getSns_apple_id() {
        return sns_apple_id;
    }

    public void setSns_apple_id(String sns_apple_id) {
        this.sns_apple_id = sns_apple_id;
    }

    public String getSns_apple_datetime() {
        return sns_apple_datetime;
    }

    public void setSns_apple_datetime(String sns_apple_datetime) {
        this.sns_apple_datetime = sns_apple_datetime;
    }

    public int getNum_of_business() {
        return num_of_business;
    }

    public void setNum_of_business(int num_of_business) {
        this.num_of_business = num_of_business;
    }

    public String getSignup_date() {
        return signup_date;
    }

    public void setSignup_date(String signup_date) {
        this.signup_date = signup_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAgree_sms() {
        return agree_sms;
    }

    public void setAgree_sms(String agree_sms) {
        this.agree_sms = agree_sms;
    }

    public String getAgree_email() {
        return agree_email;
    }

    public void setAgree_email(String agree_email) {
        this.agree_email = agree_email;
    }

    public String getAgree_push_notification() {
        return agree_push_notification;
    }

    public void setAgree_push_notification(String agree_push_notification) {
        this.agree_push_notification = agree_push_notification;
    }

    public String getAgree_push_marketing() {
        return agree_push_marketing;
    }

    public void setAgree_push_marketing(String agree_push_marketing) {
        this.agree_push_marketing = agree_push_marketing;
    }

    public String getRecent_access() {
        return recent_access;
    }

    public void setRecent_access(String recent_access) {
        this.recent_access = recent_access;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getLeave_datetime() {
        return leave_datetime;
    }

    public void setLeave_datetime(String leave_datetime) {
        this.leave_datetime = leave_datetime;
    }

    public String getReg_datetime() {
        return reg_datetime;
    }

    public void setReg_datetime(String reg_datetime) {
        this.reg_datetime = reg_datetime;
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

    public String getSearch_signup_date() {
        return search_signup_date;
    }

    public void setSearch_signup_date(String search_signup_date) {
        this.search_signup_date = search_signup_date;
    }

    public String getSearch_signup_date_start() {
        return search_signup_date_start;
    }

    public void setSearch_signup_date_start(String search_signup_date_start) {
        this.search_signup_date_start = search_signup_date_start;
    }

    public String getSearch_signup_date_end() {
        return search_signup_date_end;
    }

    public void setSearch_signup_date_end(String search_signup_date_end) {
        this.search_signup_date_end = search_signup_date_end;
    }

    public String getSearch_type() {
        return search_type;
    }

    public void setSearch_type(String search_type) {
        this.search_type = search_type;
    }

    public String getSearch_name() {
        return search_name;
    }

    public void setSearch_name(String search_name) {
        this.search_name = search_name;
    }

    public String getSearch_email() {
        return search_email;
    }

    public void setSearch_email(String search_email) {
        this.search_email = search_email;
    }

    public String getSearch_enabled() {
        return search_enabled;
    }

    public void setSearch_enabled(String search_enabled) {
        this.search_enabled = search_enabled;
    }

    public int getDeleteFileSeq() {
        return deleteFileSeq;
    }

    public void setDeleteFileSeq(int deleteFileSeq) {
        this.deleteFileSeq = deleteFileSeq;
    }

    public String getFiles_id() {
        return files_id;
    }

    public void setFiles_id(String files_id) {
        this.files_id = files_id;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getUpload_path() {
        return upload_path;
    }

    public void setUpload_path(String upload_path) {
        this.upload_path = upload_path;
    }

    public String getSearch_leave_date_start() {
        return search_leave_date_start;
    }

    public void setSearch_leave_date_start(String search_leave_date_start) {
        this.search_leave_date_start = search_leave_date_start;
    }

    public String getSearch_leave_date_end() {
        return search_leave_date_end;
    }

    public void setSearch_leave_date_end(String search_leave_date_end) {
        this.search_leave_date_end = search_leave_date_end;
    }

    public String getApp_os() {
        return app_os;
    }

    public void setApp_os(String app_os) {
        this.app_os = app_os;
    }

    public String getApp_token() {
        return app_token;
    }

    public void setApp_token(String app_token) {
        this.app_token = app_token;
    }
}
