package com.example.outreach_portal.JSONEntity;

public class GroupJson {
	public int user_id;
	public String name;
	public String about;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public GroupJson(int user_id, String name, String about) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.about = about;
	}
	
	
}
