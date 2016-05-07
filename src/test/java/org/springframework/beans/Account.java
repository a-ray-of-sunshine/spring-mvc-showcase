package org.springframework.beans;

public class Account {

	private User user;
	
	private String email;

	public Account(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}
}
