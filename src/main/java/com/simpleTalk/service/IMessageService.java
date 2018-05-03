package com.simpleTalk.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.simpleTalk.common.ServerResponse;
import com.simpleTalk.pojo.Message;
import com.simpleTalk.pojo.SpecialResult;
import com.simpleTalk.vo.MessageVo;

public interface IMessageService {
	ServerResponse<String> insertMessage(MessageVo message);
	ServerResponse<String> deleteMessage(String messageId,String senderId);
	ServerResponse<String> readMessage(String receiverId,String senderId);
	ServerResponse<PageInfo<Message>> listMessage(String senderId,String receiverId,Integer pageNum,Integer pageSize);
	ServerResponse<List<SpecialResult>> unreadListMessage(String receiverId);
}
