package com.taskmanager.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * �û��������б����ϵʵ����
 * @author enity
 *
 */
public class UserTask {
	String userid;
	List<Task> taskList=new ArrayList<Task>(); 
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
}
