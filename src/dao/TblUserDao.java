package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.TblUser;

public class TblUserDao {
	public ArrayList<TblUser> daoLogin() {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=WebWorkDB;" + "user=sa;"
				+ "password=123;";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from Tbl_user";
		ArrayList<TblUser> userList = new ArrayList<TblUser>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id").trim();
				String uname = rs.getString("user_name").trim();
				String pwd = rs.getString("password").trim();
				TblUser user = new TblUser();
				user.setId(id);
				user.setUsername(uname);
				user.setPassword(pwd);
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	public int daoAdd(String uid, String username, String password) {
		int result = 0;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=WebWorkDB;" + "user=sa;"
				+ "password=123;";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql1 = "select * from Tbl_user where user_name='" + username + "'";
		String sql2 = "insert into Tbl_user (id,user_name,password) values('" + uid + "','" + username + "','"
				+ password + "')";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				result = -1;
				return result;
			}
			result = stmt.executeUpdate(sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
