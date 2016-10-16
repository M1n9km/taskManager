package com.taskmanager.entity;

/*
 * 用户的实体类
 */

public class User {
	
	private String id="";
	private String name="";
	private String college="";
	private String clas="";
	private String major="";
	private String mail="";
	private String direction="";
	
	public User(){
		
	}
	public User(String name,String college,String clas,String major,String mail,String direction){
		this.name=name;
		this.college=college;
		this.clas=clas;
		this.major=major;
		this.mail=mail;
		this.direction=direction;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
