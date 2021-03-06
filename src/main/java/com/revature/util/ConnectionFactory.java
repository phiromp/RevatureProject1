package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	private static String url;
	private static String user;
	private static String password;
	private static ConnectionFactory cf;
		
	public static Connection getConnection() {
		
		if (cf == null) {
			cf = new ConnectionFactory();
		}
		return cf.createConnection();
	}
	
	public ConnectionFactory() {
		
		url = System.getenv("POSTGRES_2001_URL");
		user = System.getenv("POSTGRES_2001_USERNAME");
		password = System.getenv("POSTGRES_2001_PASSWORD");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection createConnection() {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static ResultSet getResultSet(String sql) {
				
		Connection conn = getConnection();
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void executeSQL(String sql) {
		
		Connection conn = getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}