package com.taskmanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

	static final String userName = "root";
	static final String userPassword = "root";
	static final String url = "jdbc:mysql://localhost:3306/taskmanager?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	static final String driver = "com.mysql.jdbc.Driver";
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;

	/**
	 * ��ȡ���ݿ�����
	 * 
	 * */
	public static Connection getConn() {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, userPassword);
		} catch (Exception e) {
			conn = null;
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * ִ��sql��䣬��ҪΪ���뼰ɾ�����
	 * 
	 * @param sql
	 * @return ������������-1��ʾ����
	 */
	public static int exeSql(String sql) {
		int exeNum;
		try {
			conn=getConn();
			stmt = conn.createStatement();
			exeNum = stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exeNum = -1;
		}
		return exeNum;
	}

	/**
	 * ִ�в�ѯ���
	 * 
	 * @param sql
	 * @return ��ѯ���rs
	 */
	public static ResultSet exeQuery(String sql) {
		try {
			conn=getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			rs = null;
		}
		return rs;
	}

	/**
	 * �ر�conn��stmt��rs����
	 * 
	 * @param conn
	 * @param stm
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * �ر�conn����
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ر�stmt����
	 * 
	 * @param stmt
	 */
	public static void close(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ر�rs����
	 * 
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
