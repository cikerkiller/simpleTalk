package com.simpleTalk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ciker
 * @desc   用户类
 *
 */
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String username;

    private String password;

    private String nickName;

    private Integer gender;

    private String mobile;

    private String email;

    private Integer age;

    private String address;

    private Integer status;

    private Date createTime;

    private Date lastLoginTime;

    private Date updateTime;

    public User(String id, String username, String password, String nickName, Integer gender, String mobile, String email, Integer age, String address, Integer status, Date createTime, Date lastLoginTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.age = age;
        this.address = address;
        this.status = status;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.updateTime = updateTime;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nickName=" + nickName + ", gender=" + gender
				+ ", mobile=" + mobile + ", email=" + email + ", age=" + age
				+ ", address=" + address + ", status=" + status
				+ ", createTime=" + createTime + ", lastLoginTime="
				+ lastLoginTime + ", updateTime=" + updateTime + "]";
	}
    
    
}