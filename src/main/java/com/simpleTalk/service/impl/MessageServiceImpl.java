package com.simpleTalk.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simpleTalk.common.MessageStatusEnum;
import com.simpleTalk.common.ServerResponse;
import com.simpleTalk.dao.MessageMapper;
import com.simpleTalk.pojo.Message;
import com.simpleTalk.pojo.SpecialResult;
import com.simpleTalk.service.IMessageService;
import com.simpleTalk.vo.MessageVo;

@Service("iMessageService")
public class MessageServiceImpl implements IMessageService {
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Override
	public ServerResponse<String> insertMessage(MessageVo messageVo) {
		Message message=convertMessage(messageVo);
		int resultCode=messageMapper.insert(message);
		if(resultCode>0){
			return ServerResponse.createBySuccess(message.getId());
		}
		return ServerResponse.createByError();
	}
	
	/**
	 * 将vo转成pojo
	 * @param messageVo
	 * @return
	 */
	private Message convertMessage(MessageVo messageVo){
		Message message=new Message();
		message.setId(UUID.randomUUID().toString());
		message.setReceiverId(messageVo.getReceiverId());
		message.setSenderId(messageVo.getSenderId());
		message.setContent(messageVo.getContent().toString());
		message.setType(messageVo.getType());
		message.setStatus(MessageStatusEnum.unread.getCode());
		return message;
	}

	@Override
	public ServerResponse<String> deleteMessage(String messageId,String senderId) {
		int resultCode=messageMapper.deleteMessage(MessageStatusEnum.undo.getCode(), messageId,senderId);
		if(resultCode>0){
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByError();
	}

	@Override
	public ServerResponse<PageInfo<Message>> listMessage(String senderId, String receiverId,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Message> messages=messageMapper.listMessage(senderId, receiverId);
		PageInfo<Message> pageInfo=new PageInfo<>(messages);
		return ServerResponse.createBySuccess(pageInfo);
	}

	@Override
	public ServerResponse<String> readMessage(String receiverId,String senderId) {
		int resultCode=messageMapper.updateMessageStatus(MessageStatusEnum.readed.getCode(), senderId,receiverId);
		if(resultCode>0){
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByError();
	}

	@Override
	public ServerResponse<List<SpecialResult>> unreadListMessage(String receiverId) {
		List<SpecialResult> messages=messageMapper.unreadListMessage(receiverId);
		return ServerResponse.createBySuccess(messages);
	}
}
