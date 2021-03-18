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
			String sql = "SELECT * FROM SNOWRESQUE";
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Timestamp created = rs.getTimestamp("CREATED");
				SnowBean snowBean = new SnowBean(id, name, text, created);
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

	public void insert(String name, String text) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			String sql = "INSERT INTO SNOWRESQUE (NAME, TEXT) VALUES('" + name + "', '" + text + "')";
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

	public void update(String name, String text, int alterId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			String sql = "UPDATE SNOWRESQUE SET NAME = ?,TEXT = ? WHERE ID = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, text);
			pStmt.setInt(3, alterId);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
