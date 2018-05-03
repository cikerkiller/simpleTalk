package com.simpleTalk.common;

/**
 * 
 * @author ciker
 * @desc  消息类型枚举
 *
 */
public enum MessageTypeEnum {
	
	text(0,"文字"),
	
	image(1,"图片"),
	
	file(2,"文件");
	
	private int code;
	
	private String desc;
	
	private MessageTypeEnum(int code, String desc) {
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
