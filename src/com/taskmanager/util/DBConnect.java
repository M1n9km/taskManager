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
	 * 获取数据库连接
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
	 * 执行sql语句，主要为插入及删除语句
	 * 
	 * @param sql
	 * @return 插入的语句数，-1表示出错
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
	 * 执行查询语句
	 * 
	 * @param sql
	 * @return 查询结果rs
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
	 * 关闭conn、stmt、rs连接
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
	 * 关闭conn连接
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
	 * 关闭stmt连接
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
	 * 关闭rs连接
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
