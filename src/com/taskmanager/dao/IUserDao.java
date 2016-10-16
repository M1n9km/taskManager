package com.taskmanager.dao;

import java.util.ArrayList;

import com.taskmanager.entity.User;

public interface IUserDao {

	int Pagesize = 4;// 每页显示行数

	/**
	 * 根据用户Id查找用户
	 * 
	 * @param id
	 * @return 查找到的用户
	 */
	User findById(String id);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param name
	 * @return 查找到的用户
	 */
	User findByName(String Name);

	/**
	 * 根据用户名模糊搜索用户
	 * 
	 * @param name
	 * @return 查找到的用户
	 */
	ArrayList<User> findByNameM(String Name);

	/**
	 * 更改用户的个人信息
	 * 
	 * @param user
	 * @return 更改成功的行数，失败则返回-1,查无此信息则返回-2
	 */
	int updateUser(User user);

	/**
	 * 注册，创建用户
	 * 
	 * @param user
	 * @return 成功则返回插入语句的数量，失败则返回-1
	 */
	int add(User user);

	/**
	 * 通过输入的字符搜索匹配该id或名字的用户
	 * 
	 * @param 需要查询的id或名字
	 *            ，inputString
	 * @return ArrayList<User>
	 */
	ArrayList<User> search(String inputString);

	/**
	 * 查询所有用户
	 * 
	 * @param inputString
	 * @return ArrayList<User>
	 */
	ArrayList<User> searchAll();

	/**
	 * 根据总行数与每页显示的行数，获取用户表总页数
	 * 
	 * @return 根据名字进行搜索时，返回结果数/每页显示数 根据Id进行搜索是，返回1 页数 int,失败则返回-1
	 */
	int getSum(String inputString);

	/**
	 * 根据ID搜索用户时获取某页的用户信息
	 * 
	 * @param page
	 * @return ArrayList<User>
	 */
	ArrayList<User> searchAllLimit(int page);

	/**
	 * 通过输入的字符,分页搜索匹配该id或名字的用户
	 * 
	 * @param page
	 * @param inputString
	 * @return ArrayList<User>
	 */
	ArrayList<User> searchLimit(int page, String inputString);

	/**
	 * 根据用户名，分頁模糊搜索用户
	 * 
	 * @param page
	 * @param name
	 * @return 查找到的用户
	 */
	ArrayList<User> findByNameMLimit(int page, String Name);

	/**
	 * 根据用户Id，分頁查找用户
	 * 
	 * @param page
	 * @param id
	 * @return 查找到的用户
	 */
	User findByIdLimit(int page, String id);

}
