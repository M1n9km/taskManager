package com.taskmanager.entity;
/**
 * 任务实体类
 * @author enity
 */
public class Task {
	private String tskId;
	private String tskName;
	private String tskStmt;
	
	public Task(){
		
	}
	
	public Task(String tskId,String tskName,String tskStmt){
		this.tskId=tskId;
		this.tskName=tskName;
		this.tskStmt=tskStmt;
	}
	public Task(String tskName,String tskStmt){
		this.tskName=tskName;
		this.tskStmt=tskStmt;
	}
	
	public String getTskStmt() {
		return tskStmt;
	}
	public void setTskStmt(String tskStmt) {
		this.tskStmt = tskStmt;
	}
	
	public String getTskName() {
		return tskName;
	}
	public void setTskName(String tskName) {
		this.tskName = tskName;
	}
	public String getTskId() {
		return tskId;
	}
	public void setTskId(String tskId) {
		this.tskId = tskId;
	}
	
}
