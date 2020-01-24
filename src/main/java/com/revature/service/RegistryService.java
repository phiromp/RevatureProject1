package com.revature.service;

public interface RegistryService {

	public boolean insertHero(String name, String id, String type);
	
	public boolean deleteHero(String name);
	
	public boolean UpdateHero(String name, String newName, String newid, String newType);
	
}
