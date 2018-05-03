package com.simpleTalk.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleTalk.common.FriendStatusEnum;
import com.simpleTalk.common.ServerResponse;
import com.simpleTalk.dao.FriendsMapper;
import com.simpleTalk.dao.UserMapper;
import com.simpleTalk.pojo.Friends;
import com.simpleTalk.pojo.User;
import com.simpleTalk.service.IFriendsService;


@Service("iFriendsService")
public class FriendsServiceImpl implements IFriendsService{
	@Autowired
	private FriendsMapper friendsMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public ServerResponse<String> addFriends(String userId ,String friendId) {
		User user=userMapper.selectByPrimaryKey(friendId);
		if(user==null){
			return ServerResponse.createByErrorMessage("该用户不存在");
		}
		Friends friends=new Friends();
		friends.setId(UUID.randomUUID().toString());
		friends.setUserId(userId);
		friends.setFriendId(friendId);
		friends.setFriendNote(user.getUsername());
		int resultCount=friendsMapper.insert(friends);
		if(resultCount==0){
			return ServerResponse.createByErrorMessage("添加好友失败");
		}
		return ServerResponse.createBySuccessMessage("添加好友成功");
	}
	
	@Override
	public ServerResponse<String> updateNote(String userId, String friendId,
			String note) {
		Friends friends=friendsMapper.selectFriendsByUserIdAndFriendsId(userId, friendId);
		if(friends==null){
			return ServerResponse.createByErrorMessage("该好友不存在");
		}
		
		friends.setFriendNote(note);
		int resultCount=friendsMapper.updateByPrimaryKeySelective(friends);
		
		if(resultCount==0){
			return ServerResponse.createByErrorMessage("修改好友备注失败");
		}
		return ServerResponse.createBySuccessMessage("修改好友备注成功");
	}
	
	@Override
	public ServerResponse<String> addBlacklist(String userId, String friendId) {
		Friends friends=friendsMapper.selectFriendsByUserIdAndFriendsId(userId, friendId);
		if(friends==null){
			return ServerResponse.createByErrorMessage("该好友不存在");
		}
		friends.setStatus(FriendStatusEnum.back.getCode());
		int resultCount=friendsMapper.updateByPrimaryKeySelective(friends);
		
		if(resultCount==0){
			return ServerResponse.createByErrorMessage("该好友拉黑失败");
		}
		return ServerResponse.createBySuccessMessage("该好友拉黑成功");
	}
	
	@Override
	public ServerResponse<String> delete(String userId, String friendId) {
		Friends friends=friendsMapper.selectFriendsByUserIdAndFriendsId(userId, friendId);
		if(friends==null){
			return ServerResponse.createByErrorMessage("该好友不存在");
		}
		friends.setStatus(FriendStatusEnum.delete.getCode());
		int resultCount=friendsMapper.updateByPrimaryKeySelective(friends);
		
		if(resultCount==0){
			return ServerResponse.createByErrorMessage("该好友删除失败");
		}
		return ServerResponse.createBySuccessMessage("该好友删除成功");
	}

	@Override
	public ServerResponse<List<Friends>> list(String userId) {
		List<Friends> friends=friendsMapper.selectFriendsByUserId(userId);
		return ServerResponse.createBySuccess(friends);
	}

	@Override
	public ServerResponse<User> queryFriendDetail(String friendId) {
		User user=userMapper.selectByPrimaryKey(friendId);
		if(user==null){
			return ServerResponse.createByErrorMessage("该用户不存在");
		}
		user.setPassword(StringUtils.EMPTY);
		return ServerResponse.createBySuccess(user);
	}
	
}
