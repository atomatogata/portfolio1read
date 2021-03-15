package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			String sql = "SELECT * FROM SNOWREQUEST";
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {

				String name = rs.getString("NAME");
				String text = rs.getString("TEXT");
				SnowBean snowBean = new SnowBean(name, text);
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
			String sql = "INSERT INTO SNOWREQUEST VALUES('" + name + "', '" + text + "')";
			Statement smt = con.createStatement();
			smt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
