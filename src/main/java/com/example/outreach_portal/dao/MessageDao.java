package com.example.outreach_portal.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.outreach_portal.bean.Message;

import com.example.outreach_portal.bean.User;


public interface MessageDao extends JpaRepository<Message,Integer>{

	@Query("SELECT m FROM Message m WHERE (m.user1 = :user1 and m.user2=:user2) or (m.user1 = :user2 and m.user2=:user1) order by m.timestamp")
	List<Message> getMsg(@Param("user1") User user1,@Param("user2") User user2);
	
	@Query("SELECT distinct m.user2 FROM Message m WHERE m.user1 = :user ")
	Set<User> getSenderUSer(@Param("user") User user);
	
	@Query("SELECT distinct m.user1 FROM Message m WHERE m.user2 = :user ")
	Set<User> getRecieverUser(@Param("user") User user);
	
	@Query("SELECT max(m.id) FROM Message m WHERE (m.user1 = :user1 and m.user2=:user2) or (m.user1 = :user2 and m.user2=:user1)")
	String getMaxMid(@Param("user1") User user1,@Param("user2") User user2);
	
	@Transactional
	@Modifying
	@Query("Update Message m set m.status=1 WHERE (m.user1 = :user2 and m.user2=:user1)")
	void recieveMsg(@Param("user1") User user1,@Param("user2") User user2);
	
	
	
}
