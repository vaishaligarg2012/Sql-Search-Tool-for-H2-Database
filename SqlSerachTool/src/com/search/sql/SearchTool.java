package com.search.sql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SearchTool extends HttpServlet {
	PrintWriter pw;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		pw=response.getWriter();
		String title="SQL Search Tool";

		pw.println(
				"<html>\n" +
						"<head><title>" + title + "</title></head>\n" +
						"<body bgcolor = \"#f0f0f0\">\n" +
				"<h1 align = \"center\">SQL Serach Tool</h1>\n<div style='text-align: center;'>Enter the firstName,lastName or part of any!! </div>");
		pw.println("<div><form method='post'><input type = text name= alphabet style='margin-left:8%;width:70%;font-size:larger'/><button style='width:14%;height:7%;margin-left:2%;' type=submit>Search</button>");
		pw.println("<br/><br/>");
		pw.println("<div style='width:100%; height:35%; color:blue;background:white'>Output Table:");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
		String s1=request.getParameter("alphabet");
		System.out.println(s1+" ");
		String wordBySerach=s1.toLowerCase();

		System.out.println("Here we have "+wordBySerach);
		ConnectionStart obj=new ConnectionStart();
		Object[] arr=obj.selectTable(wordBySerach);
		ResultSetMetaData d =null;
		ResultSet rs=null;
		try {
			d =   (ResultSetMetaData)arr[1];
			rs=(ResultSet)arr[0];
			System.out.println("Result Set meta "+d.getColumnCount()+" "+d.getColumnName(1));
			//conn.close();
			pw.println("<table border=1 cellpadding=1 cellspacing=1 width=100%>");

			for(int y=1;y<=d.getColumnCount();y++) {
				pw.print("<th>" + d.getColumnName(y) + "</th>");
			}
			pw.print("<th>Action</th>");
			while(rs.next()) {

				pw.print("<tr>");
				pw.print("</tr>");
				for (int j = 1; j <= d.getColumnCount();j++) {
					pw.print("<td>" +rs.getObject(j)  + "</td>");

				}
				pw.print("<td><button style='width: 50%;'>Delete</button><a style='width: 50%;' href=\"home?id="+rs.getString(1)+"\">Edit</a></td>");

			}
			pw.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();

			pw.println("</div></form></div>");
			pw.println("</body>");
			pw.println("</head>");
			pw.println("</html>");
		}
	}
}