

package com.atd.assesment;

import java.sql.*;
import java.util.Scanner;

//Delete Demo
public class DeleteDemo {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		int i=0;
		Scanner sc=null;
		String query=null;
		int roll = 0;
		ResultSet rs=null;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				con=DriverManager.getConnection("jdbc:mysql:///anytimedeveloper","root","root");
				st = con.createStatement();
				query = "SELECT * FROM STUDENT";
				System.out.println(query);
				System.out.println();
				rs = st.executeQuery(query);
				while (rs.next() != false) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getDate(4));
				}
				System.out.print("\nEnter student number which you want to delete  : ");
				roll=sc.nextInt();
			}
			query="DELETE FROM STUDENT WHERE STUDENT_NO="+roll;
		    System.out.println(query);
			i=st.executeUpdate(query);
			if(i!=0) {
				System.out.println("Record deleted sucessfully");
				System.out.println();
			}
			else
				System.out.println("Record not deleted");
			
			query = "SELECT * FROM STUDENT";
			System.out.println(query);
			System.out.println();
			rs = st.executeQuery(query);
			while (rs.next() != false) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getDate(4));
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception se) {
				se.printStackTrace();
			}
		}
	}

}
