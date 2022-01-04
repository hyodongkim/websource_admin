package com.teachingcash.saadmin.vo;

public class NotificationMemberVO {
    private int id;
    private int members_id;
    private int notifications_id;
    private String read;
    private String deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMembers_id() {
        return members_id;
    }

    public void setMembers_id(int members_id) {
        this.members_id = members_id;
    }

    public int getNotifications_id() {
        return notifications_id;
    }

    public void setNotifications_id(int notifications_id) {
        this.notifications_id = notifications_id;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
