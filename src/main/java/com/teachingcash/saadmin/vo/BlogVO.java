package com.teachingcash.saadmin.vo;

public class BlogVO {

    private int pk_blog;
    private String subject;
    private String subject_en;
    private String thumbnail;
    private String content_en;
    private String content_ko;
    private String reg_timestamp;
    private int cnt;
    private String category;
    private String category_en;
    private String category_new;
    private String category_en_new;
    private String is_toppost;

    private String seq;
    private String upload_path;

    private String keyword;

    private int start;
    private int limit;

    private int deleteFileSeq;

    public int getPk_blog() {
        return pk_blog;
    }

    public void setPk_blog(int pk_blog) {
        this.pk_blog = pk_blog;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getContent_en() {
        return content_en;
    }

    public void setContent_en(String content_en) {
        this.content_en = content_en;
    }

    public String getContent_ko() {
        return content_ko;
    }

    public void setContent_ko(String content_ko) {
        this.content_ko = content_ko;
    }

    public String getReg_timestamp() {
        return reg_timestamp;
    }

    public void setReg_timestamp(String reg_timestamp) {
        this.reg_timestamp = reg_timestamp;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public int getDeleteFileSeq() {
        return deleteFileSeq;
    }

    public void setDeleteFileSeq(int deleteFileSeq) {
        this.deleteFileSeq = deleteFileSeq;
    }

    public String getCategory_new() {
        return category_new;
    }

    public void setCategory_new(String category_new) {
        this.category_new = category_new;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getUpload_path() {
        return upload_path;
    }

    public void setUpload_path(String upload_path) {
        this.upload_path = upload_path;
    }

    public String getIs_toppost() {
        return is_toppost;
    }

    public void setIs_toppost(String is_toppost) {
        this.is_toppost = is_toppost;
    }

    public String getSubject_en() {
        return subject_en;
    }

    public void setSubject_en(String subject_en) {
        this.subject_en = subject_en;
    }

    public String getCategory_en() {
        return category_en;
    }

    public void setCategory_en(String category_en) {
        this.category_en = category_en;
    }

    public String getCategory_en_new() {
        return category_en_new;
    }

    public void setCategory_en_new(String category_en_new) {
        this.category_en_new = category_en_new;
    }
}
