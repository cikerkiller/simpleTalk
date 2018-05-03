package com.simpleTalk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.simpleTalk.pojo.Message;
import com.simpleTalk.pojo.SpecialResult;


public interface MessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> listMessage(@Param("senderId") String senderId,@Param("receiverId") String receiverId);
    
    List<SpecialResult> unreadListMessage(@Param("receiverId") String receiverId);
    
    int updateMessageStatus(@Param("status") Integer status,@Param("senderId") String senderId,@Param("receiverId") String receiverId);
    
    int deleteMessage(@Param("status") Integer status,@Param("messageId") String messageId,@Param("senderId") String senderId);
}