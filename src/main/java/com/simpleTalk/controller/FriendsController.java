package com.simpleTalk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simpleTalk.common.ResponseCode;
import com.simpleTalk.common.ServerResponse;
import com.simpleTalk.common.TalkConstant;
import com.simpleTalk.pojo.Friends;
import com.simpleTalk.pojo.User;
import com.simpleTalk.service.IFriendsService;


@Controller
@RequestMapping("/friends/")
public class FriendsController {
	
	@Autowired
	private IFriendsService iFriendsService;
	
	/**
	 * 添加好友
	 * @param session
	 * @param friendId
	 * @return
	 */
	@RequestMapping("add_friends")
	@ResponseBody
	public ServerResponse<String> addFriends(HttpSession session,String friendId){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iFriendsService.addFriends(user.getId(),friendId);
	}
	
	/**
	 * 修改备注名称
	 * @param session
	 * @param note
	 * @return
	 */
	@RequestMapping("update_note")
	@ResponseBody
	public ServerResponse<String> updateNote(HttpSession session,String friendId,String note){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iFriendsService.updateNote(user.getId(),friendId,note);
	}
	
	/**
	 * 拉黑
	 * @param session
	 * @param friendId
	 * @return
	 */
	@RequestMapping("add_black")
	@ResponseBody
	public ServerResponse<String> addBlacklist(HttpSession session,String friendId){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iFriendsService.addBlacklist(user.getId(),friendId);
	}
	
	/**
	 * 删除
	 * @param session
	 * @param friendId
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public ServerResponse<String> delete(HttpSession session,String friendId){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iFriendsService.delete(user.getId(),friendId);
	}
	
	
	/**
	 * 查询好友详情
	 * @param session
	 * @param friendId
	 * @return
	 */
	@RequestMapping("friend_detail")
	@ResponseBody
	public ServerResponse<User> queryFriendDetail(HttpSession session,String friendId){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iFriendsService.queryFriendDetail(friendId);
	}
	
	/**
	 * 好友列表
	 * @param session
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public ServerResponse<List<Friends>> list(HttpSession session){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iFriendsService.list(user.getId());
	}
	
	
}
