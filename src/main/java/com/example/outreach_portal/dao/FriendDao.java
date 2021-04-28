package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.outreach_portal.bean.Friends;
import com.example.outreach_portal.bean.User;

public interface FriendDao extends JpaRepository<Friends,Integer> {

	
	@Transactional
	@Modifying
	@Query("Update Friends set status= :status where user1= :user1 and user2=:user2")
	int acceptFriendreq(@Param("status") int status,@Param("user1") User user, @Param("user2") User user2);
	
	
	@Query("SELECT f.status FROM Friends f WHERE  user1= :user1 and user2=:user2")
	String checkFriend(@Param("user1") User user, @Param("user2") User user2);
	
	@Query("SELECT user2 FROM Friends f WHERE f.user1= :user1 and f.status=1")
	List<User> getFriend(@Param("user1") User user);
	
	@Transactional
	@Modifying
	@Query("Delete from Friends where  user1= :user1 and user2=:user2")
	int unFriend(@Param("user1") User user, @Param("user2") User user2);
}
