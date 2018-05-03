package com.simpleTalk.common;

/**
 * 
 * @author ciker
 * @desc 操作类型枚举  
 *
 */
public enum OperationEnum {
	
	login(1,"登录"),
	
	update(2,"更新"),
	
	logout(3,"退出"),
	
	exception(4,"异常");
	
	private int code;
	
	private String desc;
	
	private OperationEnum(int code, String desc) {
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
