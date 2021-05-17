package com.example.outreach_portal.service.Implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.JSONEntity.MessageJson;
import com.example.outreach_portal.JSONEntity.RecentMessageJson;
import com.example.outreach_portal.bean.Message;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.dao.MessageDao;
import com.example.outreach_portal.dao.ProfileDao;
import com.example.outreach_portal.service.MessageService;

@Service
public class MessageServiceImp implements MessageService {

	@Autowired
	private ProfileDao profileDao;
	
	@Autowired 
	private MessageDao messageDao;
	
	
	
	@Override
	public List<Message> getMsg(FriendJson friend) {
		User user1 = profileDao.findById(friend.getUser_id1()).get();
		User user2 = profileDao.findById(friend.getUser_id2()).get();
		
		
		return messageDao.getMsg(user1, user2);
	}

	@Override
	public List<RecentMessageJson> getRecentMsg(int user_id) {
		User usr = profileDao.findById(user_id).get();
		Set<User> users = messageDao.getRecieverUser(usr);
		users.addAll(messageDao.getSenderUSer(usr));
		
		TreeMap<Integer,User> map = new TreeMap<>(Collections.reverseOrder());
		
		for(User u:users)
		{
			int mid = Integer.parseInt(messageDao.getMaxMid(usr, u));
			map.put(mid, u);
		}
		List<RecentMessageJson> msg = new ArrayList<>();
		 for(Map.Entry m:map.entrySet())  
	      {  
	          msg.add(new RecentMessageJson((User)m.getValue(),messageDao.findById((Integer) m.getKey()).get()));      
	      } 
		
		return msg;
	}

	@Override
	public void sendMessage(MessageJson msg) {
		// TODO Auto-generated method stub
		try {
			User user1 = profileDao.findById(msg.getSender()).get();
			User user2 = profileDao.findById(msg.getReciever()).get();
			Message message = new Message(user1,user2,msg.getMessage(),0,new Date());
			messageDao.save(message);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()+" "+e.getClass().getName());
		}

		
		
		
	}

	@Override
	public void recieveMessgae(FriendJson friend) {
		// TODO Auto-generated method stub
		User user1 = profileDao.findById(friend.getUser_id1()).get();
		User user2 = profileDao.findById(friend.getUser_id2()).get();
		messageDao.recieveMsg(user1, user2);
		
	}
	
	


	
	
}
