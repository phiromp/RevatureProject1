package com.revature.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class RegistryServiceImpl implements RegistryService {

	@Override
	public void insertHero(String name, String id, String type) {
		
		String sql = "select hero_name from project1.superhuman ;";
		ResultSet rs = ConnectionFactory.getResultSet(sql);
		boolean exist = false;
		// check to see if super human is already in registry
		try {
			while(rs.next()) {
				if(rs.getString(1).equals(name))
					exist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(!exist) {
		System.out.println("inserting: " + name + " " + id + " " + type);
		sql = "insert into project1.superhuman (hero_name, true_identity, alignmentid)"
				+ " values ('" + name + "', '" + id + "', " + Integer.parseInt(type) + " )";
	
		ConnectionFactory.executeSQL(sql);
		}
	}
	
	public void deleteHero(String name) {
		System.out.println("deleting: " + name);
		String sql = "delete from project1.superhuman where hero_name = '" + name + "'";
		
		ConnectionFactory.executeSQL(sql);
	}
	
	@Override
	public void UpdateHero(String name, String newName, String newid, String newType) {
		
		String sql = "update project1.superhuman set hero_name = '" + newName + "', true_identity = '" + newid + 
				"', alignmentid = " + Integer.parseInt(newType) + " where hero_name = '" + name + "'";
		ConnectionFactory.executeSQL(sql);
		
	}
	
	
}
