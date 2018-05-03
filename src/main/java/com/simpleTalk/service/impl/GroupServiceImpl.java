package com.simpleTalk.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.simpleTalk.common.ResponseCode;
import com.simpleTalk.common.ServerResponse;
import com.simpleTalk.dao.GroupMapper;
import com.simpleTalk.dao.GroupMembersMapper;
import com.simpleTalk.pojo.Group;
import com.simpleTalk.pojo.GroupMembers;
import com.simpleTalk.service.IGroupService;

@Service("iGroupService")
public class GroupServiceImpl implements IGroupService {

	@Autowired
	private GroupMapper groupMapper;
	
	@Autowired
	private GroupMembersMapper groupMembersMapper;
	
	@Override
	public ServerResponse<String> createGroup(Group group) {
		if(group==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		String groupId=UUID.randomUUID().toString();
		group.setId(groupId);
		int resultCode=groupMapper.insert(group);
		if(resultCode>0){
			GroupMembers members=new GroupMembers();
			members.setGroupId(groupId);
			members.setId(UUID.randomUUID().toString());
			members.setUserId(group.getOwnerId());
			int code=groupMembersMapper.insert(members);
			if(code>0){
				return ServerResponse.createBySuccessMessage("建立群组成功");
			}
		}
		return ServerResponse.createByErrorMessage("建立群组失败");
	}

	@Override
	public ServerResponse<String> addGroupMembers(String groupId,String members) {
		List<String> list=Splitter.on(",").splitToList(members);
		if(CollectionUtils.isEmpty(list)||StringUtils.isBlank(groupId)){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		List<GroupMembers> groupMemberList=Lists.newArrayList();
		for(String memberId:list){
			GroupMembers groupMembers=new GroupMembers();
			groupMembers.setId(UUID.randomUUID().toString());
			groupMembers.setGroupId(groupId);
			groupMembers.setUserId(memberId);
			groupMemberList.add(groupMembers);
		}
		int resultCode=groupMembersMapper.batchInsert(groupMemberList);
		if(resultCode>0){
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByError();
	}

	@Override
	public ServerResponse<String> abortGroup(String groupId, String userId) {
		int resultCode=groupMembersMapper.deleteUserIdFromGroup(groupId, userId);
		if(resultCode>0){
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByError();
	}

	@Override
	public ServerResponse<PageInfo<GroupMembers>> groupList(String userId,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<GroupMembers> groupMembersList=groupMembersMapper.selectGroupMembersByUserId(userId);
		if(CollectionUtils.isEmpty(groupMembersList)){
			return ServerResponse.createByErrorMessage("没有加入任何群");
		}
		PageInfo<GroupMembers> pageInfo=new PageInfo<>(groupMembersList);
		return ServerResponse.createBySuccess(pageInfo);
	}

}
