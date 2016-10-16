package com.taskmanager.dao;

import java.util.ArrayList;

import com.taskmanager.entity.Task;

public interface ITaskDao {
	/**
	 * ��������idѰ������
	 * 
	 * @param id
	 * @return ����ʵ��
	 */
	Task find(String id);

	/**
	 * ����������Ѱ������
	 * 
	 * @param tskName
	 * @return ����ʵ��
	 */
	Task findByName(String tskName);

	/**
	 * ��������
	 * 
	 * @param task
	 * @return �ɹ��򷵻ز�������������ʧ���򷵻�-1
	 * @throws Exception 
	 */
	int add(Task task) throws Exception;

	/**
	 * ɾ������
	 * 
	 * @param task
	 * @return �ɹ��򷵻�ɾ������������ʧ���򷵻�-1�����޴���Ϣ�򷵻�-2
	 */
	int delete(String id);

	/**
	 * �޸�������Ϣ
	 * 
	 * @param task
	 * @return �ɹ��򷵻ز�������������ʧ���򷵻�-1�����޴���Ϣ�򷵻�-2
	 * @throws Exception 
	 */
	int update(Task task) throws Exception;
	/**
	 * ��ѯ��������
	 * @return �����б� ArrayList<Task>
	 */
	ArrayList<Task> findAll();

}
