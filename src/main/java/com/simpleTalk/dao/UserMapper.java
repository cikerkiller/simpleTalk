package com.simpleTalk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.simpleTalk.pojo.User;


public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int checkUsername(String username);
    
    User selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    
    List<User> selectByAnyCondition(@Param("age") Integer age,
    													@Param("gender") Integer gender,
    															@Param("address") String address);
    
    List<User>  selectUserByUsername(String username);
    
    int getTotalOnlineCount();
    
    int updateLoginStatus(@Param("userId") Integer status,@Param("userId") String userId);
    
    
}