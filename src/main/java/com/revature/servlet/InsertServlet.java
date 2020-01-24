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
public class InsertServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the insert do get");
		RequestDispatcher rd = req.getRequestDispatcher("Register.html");
		rd.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		String id = req.getParameter("identity");
		String type = req.getParameter("type");
		
		RegistryServiceImpl service = new RegistryServiceImpl();
		boolean success = service.insertHero(name, id, type);
		PrintWriter out = resp.getWriter();  
		
		out.println("<script type=\"text/javascript\">");
		if(success)
			out.println("alert('Succesfully Added');");
		else 
			out.println("alert('Registration Failed: SuperHuman already exists');");

		out.println("location='/RevatureProject1/Register';");
		out.println("</script>");
		
		
	}
	
}

