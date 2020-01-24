package com.revature.driver;

import java.sql.SQLException;

import com.revature.superhumanregistry.SuperHumanRegistry;

public class RegistryDriver {
	public static void main(String[] args) throws SQLException {
		
		SuperHumanRegistry.printSuperHumans();
		
	}
}
/*
CODING CHALLENGE REQUIREMENTS
SUPER HUMAN REGISTRY

Build a mini fullstack maven project Due at 4:15 pm Friday
Build a web application that will allow you to register a superhuman.

----------TECHNOLOGIES----------
HTML, CSS, Servlets, JDBC, Postgres

----------Part 1 Implement your DB: 20 Points---------------
Make 2 tables in your db: 

one table for SUPERHUMANS information. Feel free to add whatever attributes 
	you like to the table (e.g. SuperHumanName, Alias, Hometown, etc); 
and the other table for superhuman ALIGNMENT 
(this table will have only a handful of hardcoded values: “hero”, “villain”, and “vigilante”).

Make a foreign key in SUPERHUMANS that points to the primary key of ALIGNMENT.
Of course that means SUPERHUMANS need a column for “alignment”.
Add some dummy data to the database to start. You will need to demonstrate your ability to 
display what is stored in your database.


----------Part 2 Implement your model server side:----------------
Create a SuperHuman and/or an Alignment class that are mapped to your db tables. 
(you don’t HAVE to create the Alignment table if you feel you don’t need to)


----------Part 3 Implement your API (your endpoints):-------------------
Make/implement
GET                /super-human        OR        /super-human.do
        To find all superhumans
POST                /create-super-human                OR        /create-super-human.do
        To create a new super-human
DELETE (or POST)         /delete-super-human                OR        /delete-super-human.do
        To remove a super-human
   
        
If you need to create additional endpoints you are welcome to.
----------Part 4 Implement your Presentation Layer (your UI): ---------------------
As a user, I can view a table containing all registered heroes.
As a user, I can create a new superhuman, using a form so that I may type in details about the superhuman.
As a user, I can remove/delete superhumans using html forms.
As a user, I can update a superhuman using html forms.


-----------Part 5 Style your UI:-----------------------
Use CSS or a Styling Library to make your html pages pretty


-----------Finally-------------------------
Fully review your project code, and be able to explain it.
*/



