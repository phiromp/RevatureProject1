package com.revature.service;

public interface RegistryService {

	public void insertHero(String name, String id, String type);
	
	public void deleteHero(String name);
	
	public void UpdateHero(String name, String newName, String newid, String newType);
	
}
