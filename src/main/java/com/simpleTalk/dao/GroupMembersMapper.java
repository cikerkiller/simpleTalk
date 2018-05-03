package com.simpleTalk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.simpleTalk.pojo.GroupMembers;


public interface GroupMembersMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupMembers record);

    int insertSelective(GroupMembers record);

    GroupMembers selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupMembers record);

    int updateByPrimaryKey(GroupMembers record);
    
    int batchInsert(List<GroupMembers> memberlist);
    
    int deleteUserIdFromGroup(@Param("groupId") String groupId,@Param("userId") String userId);
    
    List<GroupMembers> selectGroupMembersByUserId(String userId);
}