package com.taskmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.taskmanager.dao.ILoginDao;
import com.taskmanager.entity.Login;
import com.taskmanager.util.DBConnect;

public class LoginDaoImpl implements ILoginDao {

	@Override
	public Login find(String id, String psw) {
		Login login = new Login();
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM login WHERE id='" + id + "' AND psw='"
					+ psw + "';";
			rs = DBConnect.exeQuery(sql);
			if (!rs.next())
				return null;
			login.setId(rs.getString(1));
			login.setPsw(rs.getString(2));
			login.setRole(rs.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBConnect.close(rs);
		}
		return login;
	}

	@Override
	public int add(Login login) {
		Connection conn = DBConnect.getConn();
		String sqlLogin = "INSERT INTO LOGIN VALUES (null,?,?);";
		if (conn != null) {
			try {
				PreparedStatement prep = conn.prepareStatement(sqlLogin);
				prep.setString(1, login.getPsw());
				prep.setString(2, login.getRole());
				return prep.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
			finally{
				DBConnect.close(conn);
			}
		}
		return -2;
	}

	@Override
	public Login findById(String id) {
		Login login = new Login();
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM login WHERE id='" + id + "';";
			rs = DBConnect.exeQuery(sql);
			if (!rs.next())
				return null;
			login.setId(rs.getString(1));
			login.setPsw(rs.getString(2));
			login.setRole(rs.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBConnect.close(rs);
		}
		return login;
	}

	@Override
	public int updateLogin(Login login) {
		Connection conn = DBConnect.getConn();
		String sqllogin = "UPDATE login SET psw=?,role=?;";
		if (conn != null) {
			try {
				if (findById(login.getId()) == null)
					return -2;
				PreparedStatement prep = conn.prepareStatement(sqllogin);
				prep.setString(1, login.getPsw());
				prep.setString(2, login.getRole());
				return prep.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
			finally{
				DBConnect.close(conn);
			}
		}
		return -1;

	}
}
