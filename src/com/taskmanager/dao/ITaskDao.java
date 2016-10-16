package com.taskmanager.dao;

import java.util.ArrayList;

import com.taskmanager.entity.Task;

public interface ITaskDao {
	/**
	 * 根据任务id寻找任务
	 * 
	 * @param id
	 * @return 任务实体
	 */
	Task find(String id);

	/**
	 * 根据任务名寻找任务
	 * 
	 * @param tskName
	 * @return 任务实体
	 */
	Task findByName(String tskName);

	/**
	 * 新增任务
	 * 
	 * @param task
	 * @return 成功则返回插入语句的数量，失败则返回-1
	 * @throws Exception 
	 */
	int add(Task task) throws Exception;

	/**
	 * 删除任务
	 * 
	 * @param task
	 * @return 成功则返回删除语句的数量，失败则返回-1，查无此信息则返回-2
	 */
	int delete(String id);

	/**
	 * 修改任务信息
	 * 
	 * @param task
	 * @return 成功则返回插入语句的数量，失败则返回-1，查无此信息则返回-2
	 * @throws Exception 
	 */
	int update(Task task) throws Exception;
	/**
	 * 查询所有任务
	 * @return 任务列表 ArrayList<Task>
	 */
	ArrayList<Task> findAll();

}
