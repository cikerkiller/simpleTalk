package com.simpleTalk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.simpleTalk.pojo.Friends;


public interface FriendsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(String id);  

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);
    
    Friends selectFriendsByUserIdAndFriendsId(@Param("userId") String userId,@Param("friendId") String friendId); 
    
    List<Friends> selectFriendsByUserId(String userId);
    
    
    
}