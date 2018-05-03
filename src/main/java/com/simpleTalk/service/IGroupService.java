package com.simpleTalk.service;

import com.github.pagehelper.PageInfo;
import com.simpleTalk.common.ServerResponse;
import com.simpleTalk.pojo.Group;
import com.simpleTalk.pojo.GroupMembers;

public interface IGroupService {
	
	ServerResponse<String> createGroup(Group group);
	
	ServerResponse<String> addGroupMembers(String groupId,String members);
	
	ServerResponse<String> abortGroup(String groupId,String userId);
	
	ServerResponse<PageInfo<GroupMembers>> groupList(String userId,Integer pageNum,Integer paggSize);
}
