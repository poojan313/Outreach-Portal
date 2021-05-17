package com.example.outreach_portal.bean;

import javax.persistence.*;


@Entity
@Table(name="group1")
public class Group {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String about;

	public Group() {
		
	}
	public Group(String name, String about) {
		super();

		this.name = name;
		this.about = about;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	
	

}
