package com.revature.superhumanregistry;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class SuperHumanRegistry {

	private String heroName;
	private String trueIdentity;
	private String heroType;

	public SuperHumanRegistry(String name, String identity, String type){
		this.setHeroName(name);
		this.setTrueIdentity(identity);
		this.setHeroType(type);
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getTrueIdentity() {
		return trueIdentity;
	}

	public void setTrueIdentity(String trueIdentity) {
		this.trueIdentity = trueIdentity;
	}

	public String getHeroType() {
		return heroType;
	}

	public void setHeroType(String heroType) {
		this.heroType = heroType;
	}
	
	public String toString() {
		return "SuperHuman: " + getHeroName() + "'s true identity is " + getTrueIdentity() + " and is a " + getHeroType();
	}
	
	public static void printSuperHumans() throws SQLException {
		String sql = "select s.hero_name, s.true_identity, a.super_type \r\n" + 
				"	from project1.superhuman s left join superhuman_alignment a\r\n" + 
				"	on s.alignmentid = a.alignmentid ;";
		ResultSet rs = ConnectionFactory.sendCommand(sql);

		while (rs.next()) {
			SuperHumanRegistry temp = new SuperHumanRegistry(rs.getString(1), rs.getString(2), rs.getString(3));
			System.out.println(temp.toString());
		}
	}
	
}
