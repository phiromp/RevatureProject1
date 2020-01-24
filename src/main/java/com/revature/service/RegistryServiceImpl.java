package com.revature.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class RegistryServiceImpl implements RegistryService {

	@Override
	public boolean insertHero(String name, String id, String type) {
		
		boolean exist = findHero(name);
		
		if(!exist) {
		System.out.println("inserting: " + name + " " + id + " " + type);
		String sql = "insert into project1.superhuman (hero_name, true_identity, alignmentid)"
				+ " values ('" + name + "', '" + id + "', " + Integer.parseInt(type) + " )";
	
		ConnectionFactory.executeSQL(sql);
		}
		
		return !exist;
	}
	
	public boolean deleteHero(String name) {
		boolean success = findHero(name);
		if(success) {
		System.out.println("deleting: " + name);
		String sql = "delete from project1.superhuman where hero_name = '" + name + "'";
		
		ConnectionFactory.executeSQL(sql);
		}
		
		return success;
	}
	
	@Override
	public boolean UpdateHero(String name, String newName, String newid, String newType) {
		boolean success = findHero(name);

		if(success) {
			String sql = "update project1.superhuman set hero_name = '" + newName + "', true_identity = '" + newid + 
					"', alignmentid = " + Integer.parseInt(newType) + " where hero_name = '" + name + "'";
			ConnectionFactory.executeSQL(sql);
		}
		
		return success;
	}
	
	public boolean findHero(String name) {
		String sql = "select hero_name from project1.superhuman ;";
		ResultSet rs = ConnectionFactory.getResultSet(sql);
		boolean success = false;
		// check to see if super human is already in registry
		try {
			while(rs.next()) {
				if(rs.getString(1).equals(name)) {
					success = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	
}
