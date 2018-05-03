package com.simpleTalk.pojo;

import java.util.Date;

/**
 * 
 * @author ciker
 * @desc   日志类
 *
 */
public class Log {
    private String id;

    private String username;

    private Integer type;

    private String detail;

    private Date createTime;

    private Date updateTime;

    public Log(String id, String username, Integer type, String detail, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.detail = detail;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Log() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
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