package com.taskmanager.dao;

import java.util.ArrayList;

import com.taskmanager.entity.Task;
import com.taskmanager.entity.UserTask;

/**
 * �����������û��Ĺ�ϵ
 * 
 * @author dao
 *
 */
public interface IUserTaskDao {

	/**
	 * ��������
	 * 
	 * @param user
	 * @param task
	 * @return �ɹ��򷵻ز�������������ʧ���򷵻�-1�����޴���Ϣ�򷵻�-2
	 * @throws Exception 
	 */
	int add(String userId, String taskId) throws Exception;

	/**
	 * ȡ������
	 * 
	 * @param user
	 * @param task
	 * @return �ɹ��򷵻�ɾ������������ʧ���򷵻�-1�����޴���Ϣ�򷵻�-2
	 */
	int delete(String userId, String taskId);

	/**
	 * ��ѯ��ȡ������
	 * 
	 * @param userId
	 * @return ���û����û������ϵʵ��
	 */
	UserTask find(String userId);

	/**
	 * ��ѯ�û���ȡ������id�б�
	 * 
	 * @param userId
	 * @return id�����б�
	 */
	ArrayList<String> findId(String userId);
	/**
	 * ɾ�����������������usertask��¼
	 * @param taskId
	 * @return �ɹ��򷵻�ɾ������������ʧ���򷵻�-1�����޴���Ϣ�򷵻�-2
	 */
	int deleteByTaskId(String taskId);
	
	/**
	 * ��ѯ����δ��ȡ������
	 * @param userId
	 * @return δ��ȡ��������б� ArrayList<Task>
	 */
	ArrayList<Task> findNotIn(String userId);
}
