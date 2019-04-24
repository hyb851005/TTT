package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.TblCommy;

public class TblCommyDao extends BaseDao {
	public ArrayList<TblCommy> daoInit() {
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://39.98.183.155:3306/party";
//		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from tbl_commy";
		ArrayList<TblCommy> commyList = new ArrayList<TblCommy>();
		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, "root", "root");
//			stmt = conn.createStatement();
			stmt = this.getStmt();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TblCommy commy = new TblCommy();
				commy.setUserId(rs.getString("user_Id"));
				commy.setOrgId(rs.getString("org_Id"));
				commy.setName(rs.getString("name"));
				commy.setCardNo(rs.getString("card_no"));
				commy.setPhone(rs.getString("phone"));
				commy.setAddr(rs.getString("addr"));
				commy.setStatuss(rs.getString("statuss"));
				commy.setSexx(rs.getString("sexx"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = sdf.parse(rs.getString("birthday"));
				commy.setBirthday(birthday);
				int age = Integer.parseInt(rs.getString("age"));
				commy.setAge(age);
				commy.setBakk(rs.getString("bakk"));
				commyList.add(commy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// commyList = new ArrayList<TblCommy>();
		return commyList;
	}

	public ArrayList<TblCommy> daoQuest(String cardNo) {
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://39.98.183.155:3306/party";
//		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from tbl_commy where card_no like '%" + cardNo + "%'";
		ArrayList<TblCommy> commyList = new ArrayList<TblCommy>();
		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, "root", "root");
			stmt = this.getStmt();
			rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				TblCommy commy = new TblCommy();
				commy.setUserId(rs.getString("user_Id"));
				commy.setOrgId(rs.getString("org_Id"));
				commy.setName(rs.getString("name"));
				commy.setCardNo(rs.getString("card_no"));
				commy.setPhone(rs.getString("phone"));
				commy.setAddr(rs.getString("addr"));
				commy.setStatuss(rs.getString("statuss"));
				commy.setSexx(rs.getString("sexx"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = sdf.parse(rs.getString("birthday"));
				commy.setBirthday(birthday);
				int age = Integer.parseInt(rs.getString("age"));
				commy.setAge(age);
				commy.setBakk(rs.getString("bakk"));
				commyList.add(commy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commyList;
	}

	public int daoDelete(String cardNo) {
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://39.98.183.155:3306/party";
//		Connection conn = null;
		Statement stmt = null;
		String sql = "delete from tbl_commy where card_no = '" + cardNo + "'";
		int result = 0;
		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, "root", "root");
			stmt = this.getStmt();
			result = stmt.executeUpdate(sql);
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int daoAdd(String id, String createUser, String userId, String orgId, String name, String cardNo,
			String phone, String addr, String statuss, String sexx, String birthday, String age, String bakk) {
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://39.98.183.155:3306/party";
//		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String sql1 = "select * from tbl_commy where id = '" + id + "'";
		String sql2 = "insert into tbl_commy(id,create_time,update_time,create_user,user_id,org_id,name,card_no,phone,addr,statuss,sexx,birthday,age,bakk) values('"
				+ id + "','" + date + "','" + date + "','" + createUser + "','" + userId + "','" + orgId + "','" + name
				+ "','" + cardNo + "','" + phone + "','" + addr + "','" + statuss + "','" + sexx + "','" + birthday
				+ "','" + age + "','" + bakk + "')";
		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, "root", "root");
			stmt = this.getStmt();
			rs = stmt.executeQuery(sql1);
			System.out.println(sql1);
			while (rs.next()) {
				result = -1;
				return result;
			}
			result = stmt.executeUpdate(sql2);
			System.out.println(sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int daoUpdate(String cardNo, String userId, String orgId, String name, String newCardNo, String phone,
			String addr, String statuss, String sexx, String birthday, String age, String bakk) {
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://39.98.183.155:3306/party";
//		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = -1;
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String sql1 = "select * from tbl_commy where card_no = '" + cardNo + "'";
		String sql2 = "update tbl_commy set update_time = '" + date + "',user_id = '" + userId + "',org_id = '" + orgId
				+ "',name = '" + name + "',card_no = '" + newCardNo + "',phone = '" + phone + "',addr = '" + addr
				+ "',statuss = '" + statuss + "',sexx = '" + sexx + "',birthday = '" + birthday + "',age = '" + age
				+ "',bakk = '" + bakk + "' where card_no = '" + cardNo + "'";
		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, "root", "root");
			stmt = this.getStmt();
			rs = stmt.executeQuery(sql1);
			System.out.println(sql1);
			while (rs.next()) {
				result = 0;
			}
			if (result == -1)
				return result;
			System.out.println(sql2);
			result = stmt.executeUpdate(sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
