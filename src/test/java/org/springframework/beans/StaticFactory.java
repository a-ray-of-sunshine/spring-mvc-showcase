package org.springframework.beans;

public class StaticFactory {

	// 注意这里必须是 static的, 否则注入失败
	public static User createUser(){
		return new User("staticName", "staticPassword");
	}
}
