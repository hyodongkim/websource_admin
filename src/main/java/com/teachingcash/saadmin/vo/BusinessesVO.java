package com.teachingcash.saadmin.vo;

public class BusinessesVO {
    private int id;
    private int member_id;
    private String name;
    private String brn;
    private String has_online_business;
    private String has_offline_business;
    private String contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrn() {
        return brn;
    }

    public void setBrn(String brn) {
        this.brn = brn;
    }

    public String getHas_online_business() {
        return has_online_business;
    }

    public void setHas_online_business(String has_online_business) {
        this.has_online_business = has_online_business;
    }

    public String getHas_offline_business() {
        return has_offline_business;
    }

    public void setHas_offline_business(String has_offline_business) {
        this.has_offline_business = has_offline_business;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
