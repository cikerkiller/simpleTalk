package com.simpleTalk.service;

import com.github.pagehelper.PageInfo;
import com.simpleTalk.common.ServerResponse;
import com.simpleTalk.pojo.User;

public interface IUserService {

    ServerResponse<User> login(String username,String password);

    ServerResponse<String> register(User user);
    
    ServerResponse<PageInfo<User>> search(Integer age,Integer gender,String address,Integer pageNum, Integer pageSize);
    
    ServerResponse<PageInfo<User>> search(String username,Integer pageNum, Integer pageSize);
    
    ServerResponse<String> updateNickName(String nickName);
    
    ServerResponse<String> update(User user);
    
    ServerResponse<Integer> totalOnlineCount();
    
    ServerResponse<String> updateLoginStatus(Integer status,String userId);
}
