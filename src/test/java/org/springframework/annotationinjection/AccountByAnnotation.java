package org.springframework.annotationinjection;

import org.springframework.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class AccountByAnnotation {

	private User user;

	@Autowired
	@Required
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}
