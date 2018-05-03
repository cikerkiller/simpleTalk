package com.simpleTalk.pojo;

public class SpecialResult {
	private String senderId;
	private String count;
	
	public SpecialResult() {
		super();
	}
	public SpecialResult(String senderId, String count) {
		super();
		this.senderId = senderId;
		this.count = count;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}	
