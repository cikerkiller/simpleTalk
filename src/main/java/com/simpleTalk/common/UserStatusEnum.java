package com.simpleTalk.common;

public enum UserStatusEnum {
	offline(0,"离线"),
	
	online(1,"在线"),
	
	busy(2,"繁忙"),
	
	stealth(3,"隐身");
	
	private int code;
	
	private String desc;
	
	private UserStatusEnum(int code, String desc) {
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
