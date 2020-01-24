package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.service.RegistryServiceImpl;


@WebServlet("/DeleteServlet")
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
		service.deleteHero(name);
		
		resp.sendRedirect("http://localhost:8080/RevatureProject1/Remove.html");

	}
	
	
	
}
