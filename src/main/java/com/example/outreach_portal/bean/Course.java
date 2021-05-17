package com.example.outreach_portal.bean;

import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course {
	
	
	@Id
	private int id;
	
	@Column(nullable=false,length=64)
	private String cid;
	
	@Column(nullable=false)
	private String name;
	
	@Column(length=1000)
	private String about;
	
	@Column
	private String photo;

	public Course()
	{
		
	}
	public Course(int id,String course_id, String name, String about) {
		super();
		this.id = id;
		this.cid = course_id;
		this.name = name;
		this.about = about;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_id() {
		return cid;
	}

	public void setCourse_id(String course_id) {
		this.cid = course_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	
	
}
