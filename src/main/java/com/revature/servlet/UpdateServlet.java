package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.ConnectionFactory;

public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the update do get");
		RequestDispatcher rd = req.getRequestDispatcher("Update.html");
		rd.include(req, resp);
	    
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		String newName = req.getParameter("newname");
		String newid = req.getParameter("newid");
		String newType = req.getParameter("newtype");
		
		ConnectionFactory.UpdateHero(name, newName, newid, newType);
		
		resp.sendRedirect("http://localhost:8080/RevatureProject1/Update");

	}
	
}

//resp.setContentType("text/html");
//PrintWriter out = resp.getWriter();
//out.println("<html>");
//out.println("<head><title>All HEROS</title></head>");
//out.println("<body>");
//out.println("<center><h1>All HEROS</h1>");
//
//String sql = "select s.hero_name, s.true_identity, a.super_type \r\n" + 
//			"	from project1.superhuman s left join superhuman_alignment a\r\n" + 
//			"	on s.alignmentid = a.alignmentid ;";
//
//ResultSet rs = ConnectionFactory.sendCommand(sql);
//try {
//	while (rs.next()) {
//		String name = rs.getString(1);
//		String trueid = rs.getString(2);
//		String type = rs.getString(3);
//		
//		out.print(name + "::");
//		out.print(trueid + "::");
//		out.println(type + "----------\n");
//	}
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//
//out.println("</center>");
//out.println("</body>");
//out.println("</html>");
//out.close();
