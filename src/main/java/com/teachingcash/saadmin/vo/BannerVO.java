package com.teachingcash.saadmin.vo;

public class BannerVO {
    private int id;
    private String name;
    private String date_start;
    private String date_end;
    private String alt_text;
    private String link;
    private int click_count;
    private String enabled;
    private String position;
    private String reg_datetime;
    private int order_by;

    private int start;
    private int limit;

    private String search_type;
    private String search_position;
    private String search_enabled;
    private String search_name;

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

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getAlt_text() {
        return alt_text;
    }

    public void setAlt_text(String alt_text) {
        this.alt_text = alt_text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getClick_count() {
        return click_count;
    }

    public void setClick_count(int click_count) {
        this.click_count = click_count;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getReg_datetime() {
        return reg_datetime;
    }

    public void setReg_datetime(String reg_datetime) {
        this.reg_datetime = reg_datetime;
    }

    public int getOrder_by() {
        return order_by;
    }

    public void setOrder_by(int order_by) {
        this.order_by = order_by;
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

    public String getSearch_type() {
        return search_type;
    }

    public void setSearch_type(String search_type) {
        this.search_type = search_type;
    }

    public String getSearch_position() {
        return search_position;
    }

    public void setSearch_position(String search_position) {
        this.search_position = search_position;
    }

    public String getSearch_enabled() {
        return search_enabled;
    }

    public void setSearch_enabled(String search_enabled) {
        this.search_enabled = search_enabled;
    }

    public String getSearch_name() {
        return search_name;
    }

    public void setSearch_name(String search_name) {
        this.search_name = search_name;
    }
}
