package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.SnowBean;

public class SnowDAO2 {

	private final String DBURL = "jdbc:mysql://localhost/jdbctestdb";
	private final String DBUSER = "testuser";
	private final String DBPASS = "testpass";

	public List<SnowBean> findAll() {
		List<SnowBean> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			String sql = "SELECT * FROM SNOWRESQUE AS A JOIN RESQUETYPE AS B ON A.TYPE = B.TYPE";
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("ID");
				int type = rs.getInt("TYPE");
				String discription = rs.getString("DISCRIPTION");
				String name = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Timestamp created = rs.getTimestamp("CREATED");
				SnowBean snowBean = new SnowBean(id, type, discription, name, text, created);
				list.add(snowBean);

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insert(int type, String name, String text) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			String sql = "INSERT INTO SNOWRESQUE (TYPE, NAME, TEXT) VALUES(" + type + ", '" + name + "', '" + text
					+ "')";
			Statement smt = con.createStatement();
			smt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int deleteId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			String sql = "DELETE FROM SNOWRESQUE WHERE ID = " + deleteId;
			Statement smt = con.createStatement();
			smt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(int type, String name, String text, int alterId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			String sql = "UPDATE SNOWRESQUE SET TYPE = ?,NAME = ?,TEXT = ? WHERE ID = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, type);
			pStmt.setString(2, name);
			pStmt.setString(3, text);
			pStmt.setInt(4, alterId);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
