package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.ConnectionFactory;

public class TableServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the table do get");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>All HEROS</title></head>");
		out.println("<body>");
		out.println("<center><h1>All HEROS</h1>");

		String sql = "select s.hero_name, s.true_identity, a.super_type \r\n" + 
					"	from project1.superhuman s left join superhuman_alignment a\r\n" + 
					"	on s.alignmentid = a.alignmentid ;";

		ResultSet rs = ConnectionFactory.getResultSet(sql);
		try {
			while (rs.next()) {
				String name = rs.getString(1);
				String trueid = rs.getString(2);
				String type = rs.getString(3);
				
				out.print(name + "::");
				out.print(trueid + "::");
				out.println(type + "----------\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		out.println("</center>");
		out.println("<div class='container' style='background-color: #eee'>");
		out.println("<span><a href='Register'>Add Super Human?</a></span>");
        out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	    
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}


