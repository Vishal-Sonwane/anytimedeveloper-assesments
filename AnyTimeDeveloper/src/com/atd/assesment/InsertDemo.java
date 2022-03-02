package com.atd.assesment;

import java.sql.*;
import java.util.Scanner;

//Insert Demo
class InsertDemo {

	public static void main(String[] args) throws Exception {
		Connection con = null;
		Statement st = null;
		Scanner sc = null;
		int roll = 0, count = 0;
		String sname = null, dob = null, doj = null;
		String query;
		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter Student Number");
				roll = sc.nextInt();
				System.out.println("Enter Student Name");
				sname = sc.next();
				System.out.println("Enter Student Date of Birth");
				dob = sc.next();
				System.out.println("Enter Student Date of Joining");
				doj = sc.next();
			}
			sname = " ' " + sname + " ' ";
			dob = " ' " + dob + " ' ";
			doj = " ' " + doj + " ' ";
 
			con = DriverManager.getConnection("jdbc:mysql:///anytimedeveloper", "root", "root");
			if (con != null)
				st = con.createStatement();
			query = "INSERT INTO student VALUES(" + roll + "," + sname + "," + dob + "," + doj + ")";
			if (st != null)
				count = st.executeUpdate(query);
			if (count != 0)
				System.out.println("Record Inserted ");
			else
				System.out.println("Not Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			try {
				if (sc != null)
					sc.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
		}
	}
}
