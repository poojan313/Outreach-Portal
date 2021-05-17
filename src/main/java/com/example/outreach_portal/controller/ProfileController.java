package com.example.outreach_portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.example.outreach_portal.JSONEntity.LoginJson;
import com.example.outreach_portal.bean.Notification;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.ProfileService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@CrossOrigin(origins="*")
@RestController
public class ProfileController {

	Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	public ProfileService profileService;


	@PostMapping(path="/Profile")
	public ResponseEntity<?> getUser(@RequestBody String user_id)
	{
		try
		{
			logger.info("Get profile for user with user_id "+user_id);
			User user = this.profileService.getUser(Integer.parseInt(user_id));

			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@GetMapping(path="/Search/{key}")
	public ResponseEntity<?> search(@PathVariable String key)
	{
		try
		{
			logger.info("Search for "+key);
			List<User> user = this.profileService.search(key);

			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}






	@PostMapping(path="/createUser",consumes = "application/JSON")
	public ResponseEntity<HttpStatus> createUser(@RequestBody User user)
	{
		try
		{
			logger.info("Create new user");
			this.profileService.createProfile(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(path="/login",consumes = "application/JSON")
	public ResponseEntity<?> login(@RequestBody LoginJson loginDetail)
	{
		try
		{
			logger.info("Login for a user");
			int user_id = this.profileService.login(loginDetail);
			return new ResponseEntity<>(user_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			return new ResponseEntity<>(-1,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(path="/notification")
	public ResponseEntity<?> notification(@RequestBody String user_id)
	{
		try
		{
			logger.info("Get notifications for user with user_id "+user_id);
			List<Notification> notification = this.profileService.getNotifiaction(Integer.parseInt(user_id));

			return new ResponseEntity<>(notification,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(path="/uodateNotification")
	public ResponseEntity<?> updatenotification(@RequestBody String user_id)
	{
		try
		{
			logger.info("Update notifications for user with user_id "+user_id);
			this.profileService.updateNotification(Integer.parseInt(user_id));

			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PostMapping(path="/getNotificationStat")
	public ResponseEntity<?> getNotificationStat(@RequestBody String user_id)
	{
		try
		{
			logger.info("Get status of notificaitons for user with user_id "+user_id);
			int stat = this.profileService.getNotificationStat(Integer.parseInt(user_id));

			return new ResponseEntity<>(stat,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/updateProfilePic")
	public ResponseEntity<?> UpdateProfilePic(@RequestBody com.example.outreach_portal.JSONEntity.UpdateProfileJson user)
	{
		try
		{
			logger.info("Updated profile picture");
			this.profileService.updateProfilePic(user);

			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(@RequestBody com.example.outreach_portal.JSONEntity.UpdateProfileJson user)
	{
		try
		{
			logger.info("Updated password");
			this.profileService.updatePassword(user);

			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateAbout")
	public ResponseEntity<?> updateAbout(@RequestBody com.example.outreach_portal.JSONEntity.UpdateProfileJson user)
	{
		try
		{
			logger.info("Updated about");
			this.profileService.updateAbout(user);

			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateInterest")
	public ResponseEntity<?> updateInterest(@RequestBody com.example.outreach_portal.JSONEntity.UpdateProfileJson user)
	{
		try
		{
			logger.info("Updated interests");
			this.profileService.updateInterest(user);

			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
