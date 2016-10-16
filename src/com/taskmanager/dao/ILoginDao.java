package com.taskmanager.dao;

import com.taskmanager.entity.Login;

/**
 * 
 * @author dao
 *
 */
public interface ILoginDao {

	/**
	 * �����û�Id�������������û�
	 * @param id
	 * @param psw
	 * @return ���ҵ����û�Loginʵ��
	 */
	Login find(String id,String psw);
	
	/**
	 * �����û�Id����Login�û�
	 * @param id
	 * @return ���ҵ����û�
	 */
	Login findById(String id);
	
	/**
	 * �����û���Login��Ϣ
	 * @param user
	 * @return ���ĳɹ���������ʧ���򷵻�-1,���޴���Ϣ�򷵻�-2
	 */
	int updateLogin(Login login);
	
	/**
	 * ���Login�û�
	 * @param login
	 * @return �ɹ��򷵻ز�������������ʧ���򷵻�-1�����޴���Ϣ�򷵻�-2
	 */
	int add(Login login);
}
