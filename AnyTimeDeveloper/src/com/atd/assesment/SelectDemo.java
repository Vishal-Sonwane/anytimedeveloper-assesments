package com.atd.assesment;

import java.sql.*;

public class SelectDemo {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql:///anytimedeveloper", "root", "root");
			st = con.createStatement();
			query = "SELECT * FROM STUDENT";
			System.out.println(query);
			rs = st.executeQuery(query);
			while (rs.next() != false) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getDate(4));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
