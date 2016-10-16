package com.taskmanager.dao;

import com.taskmanager.entity.Login;

/**
 * 
 * @author dao
 *
 */
public interface ILoginDao {

	/**
	 * 根据用户Id和密码来查找用户
	 * @param id
	 * @param psw
	 * @return 查找到的用户Login实体
	 */
	Login find(String id,String psw);
	
	/**
	 * 根据用户Id查找Login用户
	 * @param id
	 * @return 查找到的用户
	 */
	Login findById(String id);
	
	/**
	 * 更改用户的Login信息
	 * @param user
	 * @return 更改成功的行数，失败则返回-1,查无此信息则返回-2
	 */
	int updateLogin(Login login);
	
	/**
	 * 添加Login用户
	 * @param login
	 * @return 成功则返回插入语句的数量，失败则返回-1，查无此信息则返回-2
	 */
	int add(Login login);
}
