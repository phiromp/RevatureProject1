package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.service.RegistryServiceImpl;

@SuppressWarnings("serial")
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
		
		RegistryServiceImpl service = new RegistryServiceImpl();
		boolean success = service.UpdateHero(name, newName, newid, newType);
		PrintWriter out = resp.getWriter();  
		
		out.println("<script type=\"text/javascript\">");
		if(success) 
			out.println("alert('Succesfully Updated');");
		//else
		//	out.println("alert('Update Failed: SuperHuman doesn't exist');");
		out.println("location='/RevatureProject1/Update';");
		out.println("</script>");
		
		//resp.sendRedirect("http://localhost:8080/RevatureProject1/Update");
		
	}
	
}

