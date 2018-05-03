package com.simpleTalk.pojo;

import java.util.Date;
/**
 * 
 * @author ciker
 * @desc   附件实体类
 *
 */
public class Annex {
    private String id;

    private String fileName;

    private String fileUrl;

    private String owner;

    private Date createTime;

    private Date updateTime;

    public Annex(String id, String fileName, String fileUrl, String owner, Date createTime, Date updateTime) {
        this.id = id;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.owner = owner;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Annex() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
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