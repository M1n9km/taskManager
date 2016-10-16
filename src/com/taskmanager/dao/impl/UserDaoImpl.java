package com.taskmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.taskmanager.dao.IUserDao;
import com.taskmanager.entity.User;
import com.taskmanager.util.DBConnect;

/**
 * IUserDao的实现类
 * 
 * @author dao
 *
 */

public class UserDaoImpl implements IUserDao {

	@Override
	public User findById(String id) {
		User user = new User();
		Connection conn = DBConnect.getConn();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user_ WHERE id='" + id + "';";
			rs = conn.createStatement().executeQuery(sql);
			if (!rs.next())
				return null;
			user.setId(rs.getString(1));
			user.setName(rs.getString(2));
			user.setCollege(rs.getString(3));
			user.setClas(rs.getString(4));
			user.setMajor(rs.getString(5));
			user.setMail(rs.getString(6));
			user.setDirection(rs.getString(7));
		} catch (Exception e) {
			user = null;
			e.printStackTrace();
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return user;
	}

	@Override
	public User findByName(String Name) {
		Connection conn = DBConnect.getConn();
		User user = new User();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user_ WHERE username='" + Name + "';";
			rs = conn.createStatement().executeQuery(sql);
			if (!rs.next())
				return null;
			user.setId(rs.getString(1));
			user.setName(rs.getString(2));
			user.setCollege(rs.getString(3));
			user.setClas(rs.getString(4));
			user.setMajor(rs.getString(5));
			user.setMail(rs.getString(6));
			user.setDirection(rs.getString(7));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return user;
	}

	@Override
	public int add(User user) {
		Connection conn = DBConnect.getConn();
		String sqlUser = "INSERT INTO user_ VALUES (null,?,?,?,?,?,?);";
		if (conn != null) {
			try {
				PreparedStatement prep = conn.prepareStatement(sqlUser);
				prep.setString(1, user.getName());
				prep.setString(2, user.getCollege());
				prep.setString(3, user.getClas());
				prep.setString(4, user.getMajor());
				prep.setString(5, user.getMail());
				prep.setString(6, user.getDirection());
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
	public int updateUser(User user) {
		Connection conn = DBConnect.getConn();
		String sqlUser = "UPDATE user_ SET username=?,college=?,clas=?,major=?,mail=?,direction=? ;";
		if (conn != null) {
			try {
				if (findById(user.getId()) == null)
					return -1;
				PreparedStatement prep = conn.prepareStatement(sqlUser);
				prep.setString(1, user.getName());
				prep.setString(2, user.getCollege());
				prep.setString(3, user.getClas());
				prep.setString(4, user.getMajor());
				prep.setString(5, user.getMail());
				prep.setString(6, user.getName());
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
	public ArrayList<User> search(String inputString) {
		Pattern pattern = Pattern.compile("[0-9]*");
		ArrayList<User> users = new ArrayList<User>();
		if (pattern.matcher(inputString).matches()) {// 如果输入的是数字，根据id搜索
			users.add(findById(inputString));
			return users;
		} else
			// 如果输入的是其他字符，按name搜索
			return findByNameM(inputString);
	}

	@Override
	public ArrayList<User> findByNameM(String Name) {
		ArrayList<User> users = new ArrayList<User>();
		Connection conn = DBConnect.getConn();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user_ WHERE username like '%" + Name
					+ "%';";
			rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setCollege(rs.getString(3));
				user.setClas(rs.getString(4));
				user.setMajor(rs.getString(5));
				user.setMail(rs.getString(6));
				user.setDirection(rs.getString(7));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return users;
	}

	@Override
	public ArrayList<User> searchAll() {
		Connection conn = DBConnect.getConn();
		ArrayList<User> users = new ArrayList<User>();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user_;";
			rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setCollege(rs.getString(3));
				user.setClas(rs.getString(4));
				user.setMajor(rs.getString(5));
				user.setMail(rs.getString(6));
				user.setDirection(rs.getString(7));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return users;
	}

	@Override
	public int getSum(String inputString) {
		Connection conn = DBConnect.getConn();
		ResultSet rs = null;
		Pattern pattern = Pattern.compile("[0-9]*");
		try {
			if (pattern.matcher(inputString).matches()) {// 如果输入的是数字，根据id搜索
				return 1;
			} else if (inputString.equals("all")) {
				int sum = 0;
				String sql = "SELECT COUNT(id) FROM user_ ;";
				rs = conn.createStatement().executeQuery(sql);
				if (!rs.next())
					return -1;
				sum = (int)(Math.ceil(rs.getDouble(1) / Pagesize));
				return sum;
			} else {
				int sum = 0;
				// 如果输入的是其他字符，按name搜索
				String sql = "SELECT COUNT(id) FROM user_ WHERE username like '%"
						+ inputString + "%';";
				rs = conn.createStatement().executeQuery(sql);
				if (!rs.next())
					return -1;
				sum = (int)(Math.ceil(rs.getDouble(1) / Pagesize));
				return sum;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);

		}
	}

	@Override
	public ArrayList<User> searchAllLimit(int page) {
		Connection conn = DBConnect.getConn();
		ArrayList<User> users = new ArrayList<User>();
		ResultSet rs = null;
		int offset = (page - 1) * Pagesize;// 第一行偏移量
		try {
			String sql = "SELECT * FROM user_ limit " + offset + "," + Pagesize
					+ ";";
			rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setCollege(rs.getString(3));
				user.setClas(rs.getString(4));
				user.setMajor(rs.getString(5));
				user.setMail(rs.getString(6));
				user.setDirection(rs.getString(7));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return users;
	}

	@Override
	public ArrayList<User> searchLimit(int page, String inputString) {
		Pattern pattern = Pattern.compile("[0-9]*");
		ArrayList<User> users = new ArrayList<User>();
		if (pattern.matcher(inputString).matches()) {// 如果输入的是数字，根据id搜索
			users.add(findByIdLimit(page, inputString));
			return users;
		} else
			// 如果输入的是其他字符，按name搜索
			return findByNameMLimit(page, inputString);
	}

	@Override
	public ArrayList<User> findByNameMLimit(int page, String Name) {
		ArrayList<User> users = new ArrayList<User>();
		Connection conn = DBConnect.getConn();
		ResultSet rs = null;
		int offset = (page - 1) * Pagesize;// 第一行偏移量
		try {
			String sql = "SELECT * FROM user_ WHERE username like '%" + Name
					+ "%' limit " + offset + "," + Pagesize + ";";
			rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setCollege(rs.getString(3));
				user.setClas(rs.getString(4));
				user.setMajor(rs.getString(5));
				user.setMail(rs.getString(6));
				user.setDirection(rs.getString(7));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return users;
	}

	@Override
	public User findByIdLimit(int page, String id) {
		User user = new User();
		Connection conn = DBConnect.getConn();
		ResultSet rs = null;
		int offset = (page - 1) * Pagesize;// 第一行偏移量
		try {
			String sql = "SELECT * FROM user_ WHERE id='" + id + "' limit "
					+ offset + "," + Pagesize + ";";
			rs = conn.createStatement().executeQuery(sql);
			if (!rs.next())
				return null;
			user.setId(rs.getString(1));
			user.setName(rs.getString(2));
			user.setCollege(rs.getString(3));
			user.setClas(rs.getString(4));
			user.setMajor(rs.getString(5));
			user.setMail(rs.getString(6));
			user.setDirection(rs.getString(7));
		} catch (Exception e) {
			user = null;
			e.printStackTrace();
		} finally {
			DBConnect.close(rs);
			DBConnect.close(conn);
		}
		return user;
	}

}
