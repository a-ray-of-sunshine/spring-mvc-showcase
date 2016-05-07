package org.springframework.learn;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.Account;
import org.springframework.beans.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用工厂来初始化bean
 */
public class InitFromFactory {

	private static String configLocation = "classpath:beans.xml";
	private static ApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(InitFromFactory.class);
	
	@BeforeClass
	public static void init(){
		// 获取容器
		 context = new ClassPathXmlApplicationContext(configLocation);
		 logger.info("容器初始化成功");
	}
	
	@Test
	public void testStaticFactory(){
		
		User user = context.getBean("staticUser", User.class);

		logger.debug(user.toString());
	}
	
	@Test
	public void testInstanceFactory(){
		User user = context.getBean("instanceUser", User.class);

		logger.debug(user.toString());
	}
	
	@Test
	public void testAccount(){
		Account account = context.getBean("account", Account.class);
		
		logger.debug(account.getUser().toString());
		logger.debug(account.getEmail());

		// 自动装配， bean account1的 user 是通过自动装配初始化的
		account = context.getBean("account1", Account.class);
		logger.debug(account.getUser().toString());
		logger.debug(account.getEmail());

	}

}
