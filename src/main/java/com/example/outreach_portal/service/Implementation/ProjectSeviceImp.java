package com.example.outreach_portal.service.Implementation;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.outreach_portal.JSONEntity.ProjectJson;
import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.Project;
import com.example.outreach_portal.dao.CourseDao;
import com.example.outreach_portal.dao.PostDao;
import com.example.outreach_portal.dao.ProjectDao;
import com.example.outreach_portal.service.ProjectService;

@Service
public class ProjectSeviceImp implements ProjectService{

	
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	PostDao postDao;
	
	
	@Override
	public List<Project> getProject() {
		
		List<Project> project= projectDao.getProject();

		return project;
	}

	@Override
	public void createProject(ProjectJson projectJson) {
		// TODO Auto-generated method stub
		Course course=null;
		if(projectJson.getCourse_id()!=0)
			course = courseDao.findById(projectJson.getCourse_id()).get();
		Post post = postDao.findById(projectJson.getPost_id()).get();
		
		Project project = new Project(projectJson.getTitle(),post,new Date(),course);
		
		projectDao.save(project);
		
		
		
		
	}

}
