package com.example.outreach_portal.service;

import java.util.List;
import java.util.Set;

import com.example.outreach_portal.JSONEntity.GroupJson;
import com.example.outreach_portal.JSONEntity.GroupMessageJson;
import com.example.outreach_portal.bean.Group;
import com.example.outreach_portal.bean.GroupMessage;
import com.example.outreach_portal.bean.User;

public interface GroupService {
	
	public Group getGroupInfo(int group_id);
	public List<Group> getUserGroup(int user_id);
	public List<User> getGroupMember(int group_id);
	
	public Set<Group> getRecentGroup(int user_id);
	public List<GroupMessage> getGroupMessage(GroupMessageJson groupJson);
	
	public void sendmessage(GroupMessageJson groupJson);
	public void recievemessage(GroupMessageJson groupJson);
	
	
	public void addGroupMemeber(GroupMessageJson groupJson);
	public void leaveGroup(GroupMessageJson groupJson);
	
	public int isMember(GroupMessageJson groupJson);
	
	public void createGroup(GroupJson groupJson);
	
	
	

}
