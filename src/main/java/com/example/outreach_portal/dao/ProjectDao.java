package com.example.outreach_portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.outreach_portal.bean.Course;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.Project;
import com.example.outreach_portal.bean.User;

public interface ProjectDao extends JpaRepository<Project,Integer>{
	
	@Query("SELECT p FROM Project p WHERE Course= :course order by p.timestamp desc")
	List<Project> getAllCourseProject(@Param("course") Course course);
	
	@Query("SELECT p FROM Project p WHERE Course= null order by p.timestamp desc")
	List<Project> getProject();
}
