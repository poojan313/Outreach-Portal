package com.example.outreach_portal.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.outreach_portal.JSONEntity.CourseJson;
import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Course_Followers;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.Project;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.dao.CourseDao;
import com.example.outreach_portal.dao.CourseFollowerDao;
import com.example.outreach_portal.dao.CourseInstructorDao;
import com.example.outreach_portal.dao.PostDao;
import com.example.outreach_portal.dao.ProfileDao;
import com.example.outreach_portal.dao.ProjectDao;
import com.example.outreach_portal.service.CourseSercive;

@Service
public class CourseServiceImp implements CourseSercive {
	
	@Autowired
	PostDao postDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	CourseFollowerDao courseFollowerDao;
	
	
	@Autowired
	CourseInstructorDao courseInstructorDao;
	
	@Autowired
	ProfileDao profileDao;
	
	@Autowired
	ProjectDao projectDao;

	@Override
	public List<Project> getCourseProject(int coursid) {
		// TODO Auto-generated method stub
		Course course = courseDao.findById(coursid).get();
		return projectDao.getAllCourseProject(course);
	}

	@Override
	public List<Post> getCoursePost(int courseid) {
		// TODO Auto-generated method stub
		try {
			Course course = courseDao.findById(courseid).get();
			return postDao.getAllCoursePost(course);
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	@Override
	public void followCourse(CourseJson coursJson) {
		// TODO Auto-generated method stub
		Course course = courseDao.findById(coursJson.getCourse_id()).get();
		User user = profileDao.findById(coursJson.getUser_id()).get();
		
		Course_Followers c = new Course_Followers(course,user);
		courseFollowerDao.save(c);
		
		
	}

	@Override
	public List<User> getFollower(int course_id) {
		Course course = courseDao.findById(course_id).get();
		return courseFollowerDao.getFollower(course);
	
	
	}

	@Override
	public List<User> getInstructor(int course_id) {
		Course course = courseDao.findById(course_id).get();
		return courseInstructorDao.getInstructor(course);
	}

	@Override
	public List<Course> getUserCourse(int user_id) {
		// TODO Auto-generated method stub
		User user = profileDao.findById(user_id).get();
		return courseFollowerDao.getUserCourse(user);
	}

	@Override
	public Course getCourse(int course_id) {
		// TODO Auto-generated method stub
		return courseDao.findById(course_id).get();
	}
	

}
