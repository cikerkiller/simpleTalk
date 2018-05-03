package com.simpleTalk.pojo;

import java.util.Date;

public class Friends {
    private String id;

    private String userId;

    private String friendId;

    private Integer status;

    private String friendNote;

    private Date createTime;

    private Date updateTime;

    public Friends(String id, String userId, String friendId, Integer status, String friendNote, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.friendId = friendId;
        this.status = status;
        this.friendNote = friendNote;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Friends() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFriendNote() {
        return friendNote;
    }

    public void setFriendNote(String friendNote) {
        this.friendNote = friendNote == null ? null : friendNote.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}