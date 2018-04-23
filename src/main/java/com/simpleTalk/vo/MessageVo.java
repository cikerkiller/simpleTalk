package com.simpleTalk.vo;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author ciker
 * @desc  消息vo
 *
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class MessageVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -458605369790888112L;

	private String content;
	
	private String type;
	
	private List<String> usernameList;
	
	
	
	public MessageVo() {
		super();
	}
	public MessageVo(String content, String type, List<String> usernameList) {
		super();
		this.content = content;
		this.type = type;
		this.usernameList = usernameList;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getUsernameList() {
		return usernameList;
	}
	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}
	@Override
	public String toString() {
		JSONObject json=new JSONObject();
		json.put("message", content);
		json.put("list", usernameList);
		json.put("type", type);
		return json.toJSONString();
	}
	
	
}
