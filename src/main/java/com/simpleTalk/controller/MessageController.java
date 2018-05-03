package com.simpleTalk.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.simpleTalk.common.MessageStatusEnum;
import com.simpleTalk.common.ResponseCode;
import com.simpleTalk.common.ServerResponse;
import com.simpleTalk.common.TalkConstant;
import com.simpleTalk.pojo.Friends;
import com.simpleTalk.pojo.Message;
import com.simpleTalk.pojo.SpecialResult;
import com.simpleTalk.pojo.User;
import com.simpleTalk.service.IFileService;
import com.simpleTalk.service.IFriendsService;
import com.simpleTalk.service.IMessageService;
import com.simpleTalk.service.IUserService;
import com.simpleTalk.vo.MessageVo;
  
/**
 * 
 * @author ciker
 * @desc  消息控制器 
 *
 */
@Controller
@RequestMapping("/message/")
public class MessageController {  
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private IFileService iFileService;
	
	@Autowired
	private IFriendsService iFriendsService;
	
	@Autowired
	private IMessageService iMessageService;
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
    
	/**
	 * 单对单发送消息
	 * @param message
	 * @throws Exception
	 */
	@MessageMapping("/simple_send")  
    public void sendSimpleMessage(MessageVo message) throws Exception { 
		String receiverId=message.getReceiverId();
		String senderId=message.getSenderId();
		ServerResponse<String> response= iMessageService.insertMessage(message);
		if(response.isSuccess()){
			message.setMessageId(response.getData());
			simpMessagingTemplate.convertAndSendToUser(receiverId,"/simple_send", message);
			simpMessagingTemplate.convertAndSendToUser(senderId,"/simple_send", MessageStatusEnum.success.getCode());
		}else{
			simpMessagingTemplate.convertAndSendToUser(senderId,"/message/simple_send", MessageStatusEnum.error.getCode());
		}
    }
	
	@MessageMapping("/back_server")  
	public void server(MessageVo message) throws Exception { 
		String senderId=message.getSenderId();
		ServerResponse<List<Friends>> response=iFriendsService.list(senderId);
		if(response.isSuccess()){
			List<Friends> friends=response.getData();
			for(Friends friend:friends){
				simpMessagingTemplate.convertAndSendToUser(friend.getFriendId(),"/simple_send", "你的好友"+friend.getFriendId()+"上线");
				
			}
		}
	}
	
	/**
	 * 撤回消息
	 * @param messageId
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> deleteMessage(MessageVo message){
		return iMessageService.deleteMessage(message.getMessageId(),message.getSenderId());
	}
	
	@RequestMapping("/read_message")
	@ResponseBody
	public ServerResponse<String> readMessage(MessageVo message){
		//接收者是自己，即当自己去点击有未读消息用户图标时，会调用这个接口
		return iMessageService.readMessage(message.getReceiverId(),message.getSenderId());
	}
	
	/**
	 * 消息列表
	 * @param message
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ServerResponse<PageInfo<Message>> listMessage(MessageVo message,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
		return iMessageService.listMessage(message.getSenderId(),message.getReceiverId(),pageNum,pageSize);
	}
	
	
	@RequestMapping("/unread_list")
	@ResponseBody
	public ServerResponse<List<SpecialResult>> unreadListMessage(HttpSession session){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iMessageService.unreadListMessage(user.getId());
	}
	
	@RequestMapping("/upload_file")
	@ResponseBody
	public ServerResponse<Map<String, String>> uploadFile(HttpSession session,MultipartFile multipartFile){
		User user=(User)session.getAttribute(TalkConstant.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iFileService.uploadFile(user.getId(),multipartFile);
	}
	
	
	
}  