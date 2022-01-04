package com.teachingcash.saadmin.vo;

public class SellerVO {
    private int id;
    private String type;
    private String name;
    private String num_of_uses;
    private String code;
    private String color;
    private String reg_datetime;

    private int start;
    private int limit;

    private String search_type;
    private String search_name;
    private String search_code;

    private int deleteFileSeq;

    private String files_id;
    private String original_name;
    private String upload_path;

    private String used_cnt;

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

    public String getNum_of_uses() {
        return num_of_uses;
    }

    public void setNum_of_uses(String num_of_uses) {
        this.num_of_uses = num_of_uses;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getSearch_code() {
        return search_code;
    }

    public void setSearch_code(String search_code) {
        this.search_code = search_code;
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

    public String getUsed_cnt() {
        return used_cnt;
    }

    public void setUsed_cnt(String used_cnt) {
        this.used_cnt = used_cnt;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
