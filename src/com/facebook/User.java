package com.facebook;

public class User {
	String login;
	String password;
	
	public User createValidUser(){
		this.login = "insert_valid_email";
		this.password = "insert_valid_password";
		return this;
	}
	
	public User createInvalidUser(){
		this.login = "insert_invalid_email";
		this.password = "insert_password";
		return this;
	}
}
