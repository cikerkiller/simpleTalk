package com.simpleTalk.common;

public enum FileTypeEnum {
	img(1,"图片"),
	doc(2,"文档"),
	video(3,"视频");
	
	private int code;
	
	private String desc;
	
	private FileTypeEnum(int code, String desc) {
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
