package com.taskmanager.dao;

import java.util.ArrayList;

import com.taskmanager.entity.User;

public interface IUserDao {

	int Pagesize = 4;// ÿҳ��ʾ����

	/**
	 * �����û�Id�����û�
	 * 
	 * @param id
	 * @return ���ҵ����û�
	 */
	User findById(String id);

	/**
	 * �����û��������û�
	 * 
	 * @param name
	 * @return ���ҵ����û�
	 */
	User findByName(String Name);

	/**
	 * �����û���ģ�������û�
	 * 
	 * @param name
	 * @return ���ҵ����û�
	 */
	ArrayList<User> findByNameM(String Name);

	/**
	 * �����û��ĸ�����Ϣ
	 * 
	 * @param user
	 * @return ���ĳɹ���������ʧ���򷵻�-1,���޴���Ϣ�򷵻�-2
	 */
	int updateUser(User user);

	/**
	 * ע�ᣬ�����û�
	 * 
	 * @param user
	 * @return �ɹ��򷵻ز�������������ʧ���򷵻�-1
	 */
	int add(User user);

	/**
	 * ͨ��������ַ�����ƥ���id�����ֵ��û�
	 * 
	 * @param ��Ҫ��ѯ��id������
	 *            ��inputString
	 * @return ArrayList<User>
	 */
	ArrayList<User> search(String inputString);

	/**
	 * ��ѯ�����û�
	 * 
	 * @param inputString
	 * @return ArrayList<User>
	 */
	ArrayList<User> searchAll();

	/**
	 * ������������ÿҳ��ʾ����������ȡ�û�����ҳ��
	 * 
	 * @return �������ֽ�������ʱ�����ؽ����/ÿҳ��ʾ�� ����Id���������ǣ�����1 ҳ�� int,ʧ���򷵻�-1
	 */
	int getSum(String inputString);

	/**
	 * ����ID�����û�ʱ��ȡĳҳ���û���Ϣ
	 * 
	 * @param page
	 * @return ArrayList<User>
	 */
	ArrayList<User> searchAllLimit(int page);

	/**
	 * ͨ��������ַ�,��ҳ����ƥ���id�����ֵ��û�
	 * 
	 * @param page
	 * @param inputString
	 * @return ArrayList<User>
	 */
	ArrayList<User> searchLimit(int page, String inputString);

	/**
	 * �����û��������ģ�������û�
	 * 
	 * @param page
	 * @param name
	 * @return ���ҵ����û�
	 */
	ArrayList<User> findByNameMLimit(int page, String Name);

	/**
	 * �����û�Id����퓲����û�
	 * 
	 * @param page
	 * @param id
	 * @return ���ҵ����û�
	 */
	User findByIdLimit(int page, String id);

}
