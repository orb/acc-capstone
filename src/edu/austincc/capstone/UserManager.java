package edu.austincc.capstone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserManager {
	private DataSource ds;

	public UserManager(DataSource ds) {
		this.ds = ds;
	}
	
	public User userByNameAndPassword(String login, String password) {
		User user = null;
				
		try {
		    Connection connection = ds.getConnection();
		    PreparedStatement statement = connection.prepareStatement(
		    		"select * from user where login=? and password=?");
		    statement.setString(1, login);
		    statement.setString(2, password);

		    ResultSet results = statement.executeQuery();
		    
			if (results.next()) {
				user = new User(results.getInt("id"),results.getString("login"), results.getString("password"));
			}
		    
		    results.close();
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	
}
