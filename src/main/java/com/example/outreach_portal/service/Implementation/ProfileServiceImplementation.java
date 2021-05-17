package com.example.outreach_portal.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.outreach_portal.JSONEntity.LoginJson;
import com.example.outreach_portal.JSONEntity.UpdateProfileJson;
import com.example.outreach_portal.bean.Notification;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.dao.NotificationDao;
import com.example.outreach_portal.dao.ProfileDao;
import com.example.outreach_portal.service.ProfileService;

@Service
public class ProfileServiceImplementation implements ProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	NotificationDao notificationDao;
	
	@Override
	public boolean createProfile(User user) {
		try {
			profileDao.save(user);
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;
	}
	@Override
	public User getUser(int user_id)
	{
		try {
			return (User)profileDao.findById(user_id).get();
		}
		catch (Exception e)
		{
			return null;
		}
		
		
	}
	
	
	@Override
	public List<User> search(String key)
	{
		List<User> users = new ArrayList<>();
		User user = null;
		if(profileDao.retrieveByRoll(key)!=null)
		{
			user = profileDao.retrieveByRoll(key);
			users.add(user);
		}
		else if(profileDao.retrieveByEmail(key)!=null)
		{
			user = profileDao.retrieveByEmail(key);
			users.add(user);
		}
		else
			return profileDao.retrieveByName(key+'%');
		
		return users;
		
	}

	
	@Override
	public int login(LoginJson loginDetail)
	{
		return profileDao.login(loginDetail.getEmail(), loginDetail.getPassword());
	}
	@Override
	public List<Notification> getNotifiaction(int user_id) {
		User user = profileDao.findById(user_id).get();
		return notificationDao.getNotification(user);
	}
	@Override
	public void updateNotification(int user_id) {
		User user = profileDao.findById(user_id).get();
		notificationDao.updateNotification(user);
		
	}
	@Override
	public int getNotificationStat(int user_id) {
		User user = profileDao.findById(user_id).get();
		List<Notification> not = notificationDao.getNotificationStat(user);
		if(not.size()==0)
			return 0;
		else
			return 1;
	}
	@Override
	public void updateProfilePic(UpdateProfileJson data) {
		profileDao.updateProfile_pic(data.getValue(), data.getUser_id());
		
	}
	@Override
	public void updateAbout(UpdateProfileJson data) {
		// TODO Auto-generated method stub
		profileDao.updateAbout(data.getValue(), data.getUser_id());
		
	}
	@Override
	public void updateInterest(UpdateProfileJson data) {
		// TODO Auto-generated method stub
		profileDao.updateInterest(data.getValue(), data.getUser_id());
		
	}
	@Override
	public void updatePassword(UpdateProfileJson data) {
		// TODO Auto-generated method stub
		profileDao.updatePassword(data.getValue(), data.getUser_id());
		
	}
	
	
	
	
	

}
