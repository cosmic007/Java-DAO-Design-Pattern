package com.canddella.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	public static Connection getConnection()
	{
		Connection connection=null;
		try
		{
		String connectionString="jdbc:mysql://localhost:3306/bank";
		String userName="root";
		String password="password@123";
		connection = DriverManager.getConnection(connectionString,userName,password);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return connection;
	}

}
