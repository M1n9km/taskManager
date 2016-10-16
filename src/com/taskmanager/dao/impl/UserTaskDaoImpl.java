package com.taskmanager.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.taskmanager.dao.IUserTaskDao;
import com.taskmanager.entity.Task;
import com.taskmanager.entity.UserTask;
import com.taskmanager.util.DBConnect;

public class UserTaskDaoImpl implements IUserTaskDao {

	@Override
	public int delete(String userId, String taskId) {
		Connection conn = DBConnect.getConn();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
			String sql;
			int exeNum;
			if (userDaoImpl.findById(userId) == null
					|| taskDaoImpl.find(taskId) == null)
				return -2;
			sql = "DELETE FROM usertask WHERE id=" + userId + " AND tskid="
					+ taskId + ";";
			exeNum = conn.createStatement().executeUpdate(sql);
			return exeNum;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			DBConnect.close(conn);
		}
	}

	@Override
	public int deleteByTaskId(String taskId) {
		Connection conn = DBConnect.getConn();
		try {
			TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
			String sql;
			int exeNum;
			if (taskDaoImpl.find(taskId) == null)
				return -2;
			sql = "DELETE FROM usertask WHERE tskid=" + taskId + ";";
			exeNum = conn.createStatement().executeUpdate(sql);
			return exeNum;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			DBConnect.close(conn);
		}
	}

	@Override
	public int add(String userId, String taskId) throws Exception {
		Connection conn = DBConnect.getConn();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
			String sql;
			int exeNum;
			if (userDaoImpl.findById(userId) == null
					|| taskDaoImpl.find(taskId) == null)
				return -2;
			sql = "INSERT INTO usertask VALUES(" + userId + "," + taskId + ")";
			exeNum = conn.createStatement().executeUpdate(sql);
			return exeNum;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			DBConnect.close(conn);
		}
	}

	@Override
	public UserTask find(String userId) {
		Connection conn=DBConnect.getConn();
		UserTask userTask = new UserTask();
		TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		ResultSet rs = null;
		try {
			String sql = "SELECT distinct tskid FROM usertask WHERE id="
					+ userId + ";";
			rs = conn.createStatement().executeQuery(sql);
			userTask.setUserid(userId);
			while (rs.next()) {
				userTask.getTaskList().add(taskDaoImpl.find(rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return userTask;
	}

	@Override
	public ArrayList<String> findId(String userId) {
		try {
			UserTask userTask = find(userId);
			ArrayList<String> tskId = new ArrayList<String>();
			if (userTask == null)
				return null;
			for (int i = 0; i < userTask.getTaskList().size(); i++) {
				tskId.add(userTask.getTaskList().get(i).getTskId());
			}
			return tskId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Task> findNotIn(String userId) {
		Connection conn=DBConnect.getConn();
		ArrayList<Task> tasks = new ArrayList<Task>();
		ArrayList<String> ids = findId(userId);
		TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		ResultSet rs = null;
		if (ids.size() == 0)
			return taskDaoImpl.findAll();
		Task task = new Task();
		String id = "";
		for (int i = 0; i < ids.size() - 1; i++) {
			id = id + ids.get(i) + ",";
		}
		if (ids.size() > 0)
			id = id + ids.get(ids.size() - 1);
		try {
			String sql = "SELECT distinct * FROM task WHERE tskid not in(" + id
					+ ");";
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
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return tasks;
	}

}
