package com.search.sql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class editFields extends HttpServlet {
	String fName=null;
	String lName=null;
	String password=null;
	String pid=null;
	ConnectionStart obj=new ConnectionStart();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String title = "Update";
		pid=request.getParameter("id");
		System.out.println(pid);

		Object[] arr= obj.editRecords(pid);
		ResultSet rs=null;
		rs=(ResultSet)arr[0];

		System.out.println(arr[0]);

		try {
			while(rs.next()) {

				System.out.println(rs.getObject(1));
				password=(String) rs.getObject(2);
				fName=(String) rs.getObject(3);
				lName=(String) rs.getObject(4);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		pw.println(
				"<html>\n" +
						"<head><title>" + title + "</title></head>\n" +
						"<body bgcolor = \"#f0f0f0\">\n" +
				"<h1 align = \"center\">Please Edit Fields!!</h1>\n");
		pw.println("<div><form method='post' action=>Email <input type = text value="+pid+" name= email style='margin-left:12%;width:70%;font-size:larger' disabled/><br/>FirstName <input type = text name= fName value="+fName+" style='margin-left:8%;width:70%;font-size:larger'/><br/>Last Name <input type = text name= lName value="+lName+" style='margin-left:8%;width:70%;font-size:larger'/><br/>Password <input type = text name= password value="+password+" style='margin-left:9%;width:70%;font-size:larger'/>");
		pw.print("<br/><br/><div><button style='margin-left: 37%;' type='submit' >Update</button></div>");
		pw.println("</form></div>");



	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);

		String s1=request.getParameter("fName");
		String s2=request.getParameter("lName");
		String s3=request.getParameter("password");

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		obj.update(pid,s1,s2,s3);


	}

}
