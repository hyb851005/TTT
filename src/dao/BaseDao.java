package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BaseDao {
	public Statement getStmt() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://39.98.183.155:3306/party";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return stmt;
	}
}
