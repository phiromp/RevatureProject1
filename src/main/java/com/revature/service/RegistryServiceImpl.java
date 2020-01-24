package com.revature.service;

import com.revature.util.ConnectionFactory;

public class RegistryServiceImpl implements RegistryService {

	@Override
	public void insertHero(String name, String id, String type) {
		System.out.println("inserting: " + name + " " + id + " " + type);
		String sql = "insert into project1.superhuman (hero_name, true_identity, alignmentid)"
				+ " values ('" + name + "', '" + id + "', " + Integer.parseInt(type) + " )";
	
		ConnectionFactory.executeSQL(sql);
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
