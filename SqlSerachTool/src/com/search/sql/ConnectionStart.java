package com.search.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionStart {
	Connection conn =null;
	public ConnectionStart() {
		try {

			Class.forName("org.h2.Driver");
			conn=  DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//CRUD
	public int deleteTable(String query) {
		System.out.println(query);
		int r=0;
		try {
			Statement stmt=conn.createStatement(); 
			r=stmt.executeUpdate(query); 
			System.out.println("resultset "+r);

			conn.close(); 

		}catch(Exception e){
			e.printStackTrace();
		}

		return r;
	}
	public Object[] selectTable(String query) {
		List<String> obj=new ArrayList<>();
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;

		System.out.println("Please get all data from table");
		try {
			Statement stmt=conn.createStatement();  
			rs=stmt.executeQuery("SELECT * FROM Users WHERE LOWER(FIRSTNAME) LIKE '%"+query+"%'"); 
			//System.out.println("resultset "+rs.getRow()+" ");
			rsmd=rs.getMetaData(); 
			System.out.println(rsmd);
			//System.out.println("Result Set meta "+rsmd.getColumnCount()+" "+rsmd.getColumnName(1));



		}catch(Exception e) {
			e.printStackTrace();
		}
		return new Object[]{rs,rsmd};
	}

	public Object[] editRecords(String email) {

		ResultSet rs=null;


		System.out.println("Edit Records");
		try {
			PreparedStatement statement = conn.prepareStatement("select * from users where email = ?");    
			statement.setString(1, email);    
			rs = statement.executeQuery();
			System.out.println(rs);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return new Object[]{rs};
	}



	public void update(String pid,String s1,String s2,String s3){
		int []a =new int[]{10,78};
		System.out.println(a[0]);
		String sql = "update users set firstname='"+s1+"' , lastname='"+s2+"' , password='"+s3+"' where email='"+pid+"'";
		try {
			Statement stmt=conn.createStatement(); 
			int s=stmt.executeUpdate(sql); 
			System.out.println("resultset "+s);
			conn.close();  
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public int insertIntoTable(String query) {
		int r=0;
		try {
			
			Statement stmt=conn.createStatement(); 
			r=stmt.executeUpdate(query); 
			System.out.println("resultset "+r);
			conn.close();  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	/*public int updateTable(String query){
		int s=0;
		try {
			Statement stmt=conn.createStatement(); 
			s=stmt.executeUpdate(query); 
			System.out.println("resultset "+s);
			conn.close();  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
*/

}


