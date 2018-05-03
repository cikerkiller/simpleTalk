package com.simpleTalk.common;

public enum FriendStatusEnum {
	
	delete(-1,"删除"),
	
	back(0,"拉黑"),
	
	white(1,"好友");
	
	private int code;
	
	private String desc;
	
	private FriendStatusEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
