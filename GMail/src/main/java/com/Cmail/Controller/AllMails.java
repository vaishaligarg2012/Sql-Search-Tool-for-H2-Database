package com.Cmail.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Cmail.DAO.ComposeDAO;
import com.Cmail.DAO.ComposeDaoImp;
import com.Cmail.Model.ComposeMail;

/**
 * Servlet implementation class AllMails
 */
@SuppressWarnings("serial")

@WebServlet("/AllMails")
public class AllMails extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			  ComposeDAO obj=new ComposeDaoImp();
		        List<ComposeMail> cm=obj.viewAllMails();
		        System.out.println("get all mail "+cm);
		       
		        RequestDispatcher rd=request.getRequestDispatcher("/GmailHome.jsp");
				request.setAttribute("SentMails",cm);
			    rd.forward(request, response);
		    
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
