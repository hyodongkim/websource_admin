package com.teachingcash.saadmin.vo;

public class Insurance_categoryVO {
    private int id;
    private String name;
    private String code;
    private String num_of_products;
    private String enabled;
    private String visible_order;
    private String reg_datetime;

    private int start;
    private int limit;

    private int products_cnt;

    private String search_name;
    private String search_code;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum_of_products() {
        return num_of_products;
    }

    public void setNum_of_products(String num_of_products) {
        this.num_of_products = num_of_products;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getVisible_order() {
        return visible_order;
    }

    public void setVisible_order(String visible_order) {
        this.visible_order = visible_order;
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

    public int getProducts_cnt() {
        return products_cnt;
    }

    public void setProducts_cnt(int products_cnt) {
        this.products_cnt = products_cnt;
    }
}
