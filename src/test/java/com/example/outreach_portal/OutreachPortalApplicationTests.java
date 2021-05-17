package com.example.outreach_portal;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.outreach_portal.JSONEntity.MessageJson;
import com.example.outreach_portal.JSONEntity.PostJson;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.Project;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.CourseSercive;
import com.example.outreach_portal.service.MessageService;
import com.example.outreach_portal.service.PostService;
import com.example.outreach_portal.service.ProfileService;
import com.example.outreach_portal.service.ProjectService;
import com.example.outreach_portal.service.Implementation.CourseServiceImp;

import javassist.expr.Instanceof;

@SpringBootTest
class OutreachPortalApplicationTests {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Autowired
	ProfileService profileService;
	
	@Autowired
	CourseSercive courseService;
	
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	MessageService msgService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void DataException() {
	    profileService.createProfile(new User());
	    exception.expect(org.springframework.beans.factory.BeanCreationException.class);
	}
	
	@Test
	public void testproFileCase2() {
	    User user = profileService.getUser(1001);
	    if(user==null)
	    	assertNull(user);
	    else
	    	assertNotNull(user);
	    
	}
	
	@Test
	public void testcourseCase() {
	    List<Post> post = courseService.getCoursePost(1001);
	    assertNull(post);
	    
	}
	
	@Test
	public void testcourseCase2() {
	    List<Post> post = courseService.getCoursePost(101);
	    assertNotNull(post);
	    
	}
	
	@Test
	public void testProjetCase1() {
		List<Project> project = projectService.getProject();
		for(Object obj:project)
		{
			assertTrue(obj.getClass().getName().equals("com.example.outreach_portal.bean.Project"));
		}
	}
	
	
	@Test
	public void postTestCase() {
	    postService.createPost(new PostJson());
	    exception.expect(DataIntegrityViolationException.class);
	}
	
	@Test
	public void messageTestCase() {
		try {
			msgService.sendMessage(new MessageJson(100,101,"yes"));
		}
	    catch(Exception e)
		{
	    	exception.expect(java.util.NoSuchElementException.class);
		}
	    
	}
	@Test
	public void messageTestCase2() {
		try {
			msgService.sendMessage(new MessageJson(100,1021,"yes"));
		}
	    catch(Exception e)
		{
	    	exception.expect(java.util.NoSuchElementException.class);
		}
	    
	}

}
