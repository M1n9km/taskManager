package com.taskmanager.dao;

import java.util.ArrayList;

import com.taskmanager.entity.Task;
import com.taskmanager.entity.UserTask;

/**
 * 控制任务与用户的关系
 * 
 * @author dao
 *
 */
public interface IUserTaskDao {

	/**
	 * 接受任务
	 * 
	 * @param user
	 * @param task
	 * @return 成功则返回插入语句的数量，失败则返回-1，查无此信息则返回-2
	 * @throws Exception 
	 */
	int add(String userId, String taskId) throws Exception;

	/**
	 * 取消任务
	 * 
	 * @param user
	 * @param task
	 * @return 成功则返回删除语句的数量，失败则返回-1，查无此信息则返回-2
	 */
	int delete(String userId, String taskId);

	/**
	 * 查询领取的任务
	 * 
	 * @param userId
	 * @return 该用户的用户任务关系实体
	 */
	UserTask find(String userId);

	/**
	 * 查询用户领取的任务id列表
	 * 
	 * @param userId
	 * @return id整型列表
	 */
	ArrayList<String> findId(String userId);
	/**
	 * 删除包含改任务的所有usertask记录
	 * @param taskId
	 * @return 成功则返回删除语句的数量，失败则返回-1，查无此信息则返回-2
	 */
	int deleteByTaskId(String taskId);
	
	/**
	 * 查询所有未领取的任务
	 * @param userId
	 * @return 未领取的任务的列表 ArrayList<Task>
	 */
	ArrayList<Task> findNotIn(String userId);
}
