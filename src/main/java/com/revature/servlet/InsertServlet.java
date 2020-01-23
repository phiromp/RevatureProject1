package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.superhumanregistry.SuperHumanRegistry;
import com.revature.util.ConnectionFactory;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the Insert Post");
		
		String name = req.getParameter("uname");
		String id = req.getParameter("identity");
		String type = req.getParameter("type");
		
		
		ConnectionFactory.insertHero(name, id, type);
		
		resp.sendRedirect("http://localhost:8080/RevatureProject1/Register.html");

	}
	
	
	
}
