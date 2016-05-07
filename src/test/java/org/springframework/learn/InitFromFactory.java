package org.springframework.learn;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

}
