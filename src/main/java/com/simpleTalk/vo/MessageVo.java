package com.simpleTalk.vo;

import java.io.Serializable;


public class MessageVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -458605369790888112L;
	//消息id
	private String messageId;
	//发送者
	private String senderId;
	//接收者
	private String receiverId;
	//内容
	private Object content;
	//内容类型
	private Integer type;
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
