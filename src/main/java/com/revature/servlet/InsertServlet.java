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

import com.revature.service.RegistryServiceImpl;
import com.revature.util.ConnectionFactory;

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
		service.insertHero(name, id, type);
		
		resp.sendRedirect("http://localhost:8080/RevatureProject1/Register");

	}
	
}

