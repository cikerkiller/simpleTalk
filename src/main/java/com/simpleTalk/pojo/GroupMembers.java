package com.simpleTalk.pojo;

import java.util.Date;

public class GroupMembers {
    private String id;

    private String groupId;

    private String userId;

    private Date createTime;

    private Date updateTime;

    private String columns1;

    private String columns2;

    private String columns3;

    public GroupMembers(String id, String groupId, String userId, Date createTime, Date updateTime, String columns1, String columns2, String columns3) {
        this.id = id;
        this.groupId = groupId;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.columns1 = columns1;
        this.columns2 = columns2;
        this.columns3 = columns3;
    }

    public GroupMembers() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public String getColumns1() {
        return columns1;
    }

    public void setColumns1(String columns1) {
        this.columns1 = columns1 == null ? null : columns1.trim();
    }

    public String getColumns2() {
        return columns2;
    }

    public void setColumns2(String columns2) {
        this.columns2 = columns2 == null ? null : columns2.trim();
    }

    public String getColumns3() {
        return columns3;
    }

    public void setColumns3(String columns3) {
        this.columns3 = columns3 == null ? null : columns3.trim();
    }
}