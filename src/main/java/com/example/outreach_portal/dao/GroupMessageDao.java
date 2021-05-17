package com.example.outreach_portal.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.outreach_portal.bean.Group;
import com.example.outreach_portal.bean.GroupMembers;
import com.example.outreach_portal.bean.GroupMessage;
import com.example.outreach_portal.bean.User;

public interface GroupMessageDao extends JpaRepository<GroupMessage,Integer> {
	
	
	@Query("Select distinct g.group,g.timestamp from GroupMessage g where g.user1=:user1 or g.user2=:user1 order by g.timestamp desc")
	Map<Group,Date> getRecentGroup(@Param("user1") User user);
	
	
	
	@Query("Select g from GroupMessage g where g.user1=:user or g.group=:group order by g.timestamp desc")
	List<GroupMessage> getGroupMessage(@Param("group") Group group, @Param("user") User user);

	@Transactional
	@Modifying
	@Query("Update GroupMessage m set m.status=1 WHERE (m.group = :group and m.user2=:user1)")
	String recieveMsg(@Param("user1") User user1,@Param("group") Group group);
}
