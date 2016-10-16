package com.taskmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.taskmanager.dao.ITaskDao;
import com.taskmanager.entity.Task;
import com.taskmanager.util.DBConnect;

public class TaskDaoImpl implements ITaskDao {

	@Override
	public Task find(String id) {
		Connection conn=DBConnect.getConn();
		Task task = new Task();
		ResultSet rs = null;
		try {
			String sql = "SELECT distinct  * FROM task WHERE tskid='" + id
					+ "';";
			rs = conn.createStatement().executeQuery(sql);
			if (!rs.next())
				return null;
			task.setTskId(rs.getString(1));
			task.setTskName(rs.getString(2));
			task.setTskStmt(rs.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return task;
	}

	@Override
	public Task findByName(String tskName) {
		Connection conn=DBConnect.getConn();
		
		Task Task = new Task();
		ResultSet rs = null;
		try {
			String sql = "SELECT distinct * FROM task WHERE tskname='"
					+ tskName + "';";
			rs = conn.createStatement().executeQuery(sql);
			if (!rs.next())
				return null;
			Task.setTskId(rs.getString(1));
			Task.setTskName(rs.getString(2));
			Task.setTskStmt(rs.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return Task;
	}

	@Override
	public int add(Task task) throws Exception {
		Connection conn = DBConnect.getConn();
		String sqlTask = "INSERT INTO task VALUES (null,?,?);";
		if (conn != null) {
			try {
				if (find(task.getTskId()) != null)
					return -1;
				PreparedStatement prep = conn.prepareStatement(sqlTask);
				// prep.setInt(1, Integer.valueOf(task.getTskId()));
				prep.setString(1, task.getTskName());
				prep.setString(2, task.getTskStmt());
				return prep.executeUpdate();
			} catch (Exception e) {
				return -1;
			} finally {
				DBConnect.close(conn);
			}
		}
		return -2;
	}

	@Override
	public int delete(String id) {
		int doneNum;
		try {
			String sql = "DELETE FROM task WHERE tskid='" + id + "';";
			doneNum = DBConnect.exeSql(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return doneNum;
	}

	@Override
	public int update(Task task) throws Exception {
		Connection conn = DBConnect.getConn();
		String sqlTask = "UPDATE task SET tskname=?,tskstmt=? where tskid=?;";
		if (conn != null) {
			try {
				if (find(task.getTskId()) == null)
					return -1;
				PreparedStatement prep = conn.prepareStatement(sqlTask);
				prep.setString(1, task.getTskName());
				prep.setString(2, task.getTskStmt());
				prep.setInt(3, Integer.valueOf(task.getTskId()));
				return prep.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			} finally {
				DBConnect.close(conn);
			}
		}
		return -2;
	}

	@Override
	public ArrayList<Task> findAll() {
		Connection conn=DBConnect.getConn();
		ArrayList<Task> tasks = new ArrayList<Task>();
		Task task = null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM task;";
			rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				task = new Task();
				task.setTskId(rs.getString(1));
				task.setTskName(rs.getString(2));
				task.setTskStmt(rs.getString(3));
				tasks.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return tasks;
	}

}
