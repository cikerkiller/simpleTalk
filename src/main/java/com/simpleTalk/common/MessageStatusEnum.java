package com.simpleTalk.common;

public enum MessageStatusEnum {
	
	undo(-1,"撤销"),
	
	unread(0,"未读"),
	
	readed(1,"已读"),

	success(2,"发送成功"),
	
	error(3,"发送失败");
	
	private int code;
	
	private String desc;
	
	private MessageStatusEnum(int code, String desc) {
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
