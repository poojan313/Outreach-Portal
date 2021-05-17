package com.example.outreach_portal.JSONEntity;

public class GroupMessageJson {
	private int user_id;
	private int group_id;
	private String message;
	

	
	public GroupMessageJson(int user_id, int group_id, String message) {
		super();
		this.user_id = user_id;
		this.group_id = group_id;
		this.message = message;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int sender) {
		this.user_id = sender;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
