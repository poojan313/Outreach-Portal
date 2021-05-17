package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.outreach_portal.bean.Comment;
import com.example.outreach_portal.bean.Group;
import com.example.outreach_portal.bean.GroupMembers;
import com.example.outreach_portal.bean.User;

public interface GroupMemberDao extends JpaRepository<GroupMembers,Integer>{
	
	@Query("Select g.group from GroupMembers g where g.user=:user")
	List<Group> getUserGroup(@Param("user") User user);
	
	@Query("Select g.user from GroupMembers g where g.group=:group")
	List<User> getGroupMember(@Param("group") Group group);
	
	@Transactional
	@Modifying
	@Query("Delete from GroupMembers g where g.user =:user and g.group=:group")
	int leaveGroup(@Param("user") User user1,@Param("group") Group group);
	
	
	@Query("Select g.user from GroupMembers g where g.group=:group and g.user = :user")
	String isMember(@Param("group") Group group,@Param("user") User user);
}
