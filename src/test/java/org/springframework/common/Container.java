package org.springframework.common;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 初始化 spring 容器
 */
public abstract class Container {

	private static String configLocation = "classpath:beans.xml";
	protected static ApplicationContext context;
	
	@BeforeClass
	public static void init(){
		// 获取容器
		 context = new ClassPathXmlApplicationContext(configLocation);
	}
	
	@AfterClass
	public static void destory(){
		((AbstractApplicationContext) context).close();
	}
}
