package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {
	
	private static String url;
	
	private static String user;
	
	private static String password;
	
	private static ConnectionFactory cf;
	
	private static final String PROPERTIES_FILE = "src/main/resources/database.properties";
	
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
	
	public static ResultSet sendCommand(String sql) {
				
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
	
	public static void insertHero(String name, String id, String type) {
		System.out.println("inserting: " + name + " " + id + " " + type);
		String sql = "insert into project1.superhuman (hero_name, true_identity, alignmentid)"
				+ " values ('" + name + "', '" + id + "', " + Integer.parseInt(type) + " )";
	
		executeSQL(sql);
	}
	
	public static void deleteHero(String name) {
		System.out.println("deleting: " + name);
		String sql = "delete from project1.superhuman where hero_name = '" + name + "'";
		
		executeSQL(sql);
	}
	
	public static void UpdateHero(String name, String newName, String newid, String newType) {

		String sql = "update project1.superhuman set hero_name = '" + newName + "', true_identity = '" + newid + 
				"', alignmentid = " + Integer.parseInt(newType) + " where hero_name = '" + name + "'";
		executeSQL(sql);
		
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