package org.springframework.beans;

public class InstanceFactory {

	public User createUser(){
		return new User("instanceName", "instancePassword");
	}
}
