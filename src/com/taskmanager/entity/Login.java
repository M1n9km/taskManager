package com.taskmanager.entity;

/**
 * 用户登录实体类
 * @author enity
 *
 */

public class Login {
	String id="";
	String psw="";
	String role="";
	
	public Login(){
		
	}
	public Login(String psw,String role){
		this.psw=psw;
		this.role=role;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
