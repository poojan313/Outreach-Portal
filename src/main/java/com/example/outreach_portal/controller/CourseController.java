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
import com.example.outreach_portal.JSONEntity.CourseJson;
import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.Project;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.Implementation.CourseServiceImp;

@CrossOrigin(origins="*")
@RestController
public class CourseController {


	Logger logger = LoggerFactory.getLogger(CourseController.class);
	@Autowired
	private CourseServiceImp courseService;

	@GetMapping(path="/course/{course_id}")
	public ResponseEntity<?> friendReq(@PathVariable String course_id)
	{
		try
		{
			logger.info("Getting course with course id "+course_id);
			Course course = this.courseService.getCourse(Integer.parseInt(course_id));

			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path="/getCourseProject/{course_id}")
	public ResponseEntity<?> getCourseProject(@PathVariable String course_id)
	{
		try
		{
			logger.info("Get list of projects for course with course_id "+course_id);
			List<Project> project = this.courseService.getCourseProject(Integer.parseInt(course_id));

			return new ResponseEntity<>(project,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@GetMapping(path="/getCoursePost/{course_id}")
	public ResponseEntity<?> getCoursePost(@PathVariable String course_id)
	{
		try
		{
			logger.info("Get posts for course_id "+course_id);
			List<Post> post = this.courseService.getCoursePost(Integer.parseInt(course_id));

			return new ResponseEntity<>(post,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@GetMapping(path="/getCourseFollower/{course_id}")
	public ResponseEntity<?> getCourseFollower(@PathVariable String course_id)
	{
		try
		{
			logger.info("Get course follower for course_id "+course_id);
			List<User> user = this.courseService.getFollower(Integer.parseInt(course_id));

			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@GetMapping(path="/getCourseInstructor/{course_id}")
	public ResponseEntity<?> getCourseInstructor(@PathVariable String course_id)
	{
		try
		{
			logger.info("Get course instructor for course_id "+course_id);
			List<User> user = this.courseService.getInstructor(Integer.parseInt(course_id));

			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@GetMapping(path="/getUserCourse/{user_id}")
	public ResponseEntity<?> getUserCourse(@PathVariable String user_id)
	{
		try
		{
			logger.info("Get users for user_id "+user_id);
			List<Course> course = this.courseService.getUserCourse(Integer.parseInt(user_id));

			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@PostMapping(path="/followCourse")
	public ResponseEntity<?> followCourse(@RequestBody CourseJson courseJson)
	{
		try
		{
			logger.info("Started following a new course");
			this.courseService.followCourse(courseJson);

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
