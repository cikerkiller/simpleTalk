package com.simpleTalk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.simpleTalk.common.ResponseCode;
import com.simpleTalk.common.ServerResponse;
import com.simpleTalk.common.TalkCache;
import com.simpleTalk.common.TalkConstant;
import com.simpleTalk.pojo.User;
import com.simpleTalk.service.IUserService;

/**
 * 
 * @author ciker
 * @desc  用户控制器
 *
 */
@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private IUserService iUserService;

	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> register(User user) {
		return iUserService.register(user);
	}
	
	/**
	 * 登录
	 * @param session
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login.do")
	@ResponseBody
	public ServerResponse<User> login(HttpSession session, String username,
			String password) {
		ServerResponse<User> response = iUserService.login(username, password);
		if (response.isSuccess()) {
			User user = response.getData();
			TalkCache.userSession.put(user.getUsername(), user);
			// 将用户名作为key存入httpSession，以便webSocketSession同步
			 session.setAttribute(TalkConstant.CURRENT_USER, user);
		}
		return response;
	}
	
	@RequestMapping(value = "login_status.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> checkLoginStatus(HttpSession session) {
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByError();
		}
		return ServerResponse.createBySuccess();
	}
	
	/**
	 * 获取用户信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "get_userinfo", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse<User> getUserInfo(HttpSession session) {
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return ServerResponse.createBySuccess(user);
	}
	
	/**
	 * 退出
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> logout(HttpSession session) {
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user!=null){
			session.removeAttribute(TalkConstant.CURRENT_USER);
			TalkCache.userSession.remove(user.getUsername());
		}
	    return ServerResponse.createBySuccess();
	}
	
	/**
	 * 按条件查找
	 * @param session
	 * @param username
	 * @param age
	 * @param gender
	 * @param address
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "search_condition", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<PageInfo<User>> search(HttpSession session,
			@RequestParam(value="age",defaultValue="0") Integer age,
			@RequestParam(value="gender",defaultValue="") Integer gender,
			@RequestParam(value="address",defaultValue="") String address,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iUserService.search( age, gender, address,pageNum,pageSize);
	}
	
	/**
	 * 根据输入的用户名模糊查询
	 * @param session
	 * @param username
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<PageInfo<User>> search(HttpSession session,
			@RequestParam(value="username",defaultValue="") String username,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iUserService.search(username,pageNum,pageSize);
	}
	
	/**
	 * 修改信息
	 * @param session
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> updateNickName(HttpSession session,User userinfo){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iUserService.update(userinfo);
	}
	
	
	
}
