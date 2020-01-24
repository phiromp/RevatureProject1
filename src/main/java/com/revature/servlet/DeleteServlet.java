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
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the remove servlet Get");
		RequestDispatcher rd = req.getRequestDispatcher("Remove.html");
		rd.include(req, resp);
	    
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		
		RegistryServiceImpl service = new RegistryServiceImpl();		
		boolean success = service.deleteHero(name);
		PrintWriter out = resp.getWriter();  
		
		out.println("<script type=\"text/javascript\">");
		if(success) 
			out.println("alert('Succesfully Deleted');");
		//else
			//out.println("alert('Registration Failed: SuperHuman doesn't exist');");
		
		out.println("location='/RevatureProject1/Remove';");
		out.println("</script>");
	

	}
	
	
	
}
