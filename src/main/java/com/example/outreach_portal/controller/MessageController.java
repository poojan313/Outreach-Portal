package com.example.outreach_portal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.JSONEntity.MessageJson;
import com.example.outreach_portal.JSONEntity.RecentMessageJson;
import com.example.outreach_portal.bean.Message;
import com.example.outreach_portal.service.MessageService;

@CrossOrigin(origins="*")
@RestController
public class MessageController {

	Logger logger = LoggerFactory.getLogger(MessageController.class);
	@Autowired
	private MessageService msgService;
	
	@PostMapping(path="/getMsg")
	public ResponseEntity<?> getMsg(@RequestBody FriendJson friend)
	{
		try
		{
			logger.info("Get message");
			List<Message> msg = this.msgService.getMsg(friend);
			
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/getRecentMsg/{user_id}")
	public ResponseEntity<?> getRecentMsg(@PathVariable String user_id)
	{
		try
		{
			logger.info("Get recent message for "+user_id);
			List<RecentMessageJson> msg = this.msgService.getRecentMsg(Integer.parseInt(user_id));
			
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping(path="/sendMessage")
	public ResponseEntity<?> friendReq(@RequestBody MessageJson msg)
	{
		try
		{
			logger.info("Send message");
			this.msgService.sendMessage(msg);
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/recieveMessage")
	public ResponseEntity<?> recieveMessage(@RequestBody FriendJson friend)
	{
		try
		{
			logger.info("Receive message");
			this.msgService.recieveMessgae(friend);
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
}
