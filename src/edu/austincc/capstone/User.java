package edu.austincc.capstone;

public class User {
	private String username;
	private String password;
	private int id;
	
	public User(int id, String username, String password) {
		super();
		this.id       = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
