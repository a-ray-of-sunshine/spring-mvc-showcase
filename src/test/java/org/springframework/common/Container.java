package org.springframework.common;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 初始化 spring 容器
 */
public abstract class Container {

	private String configLocation = "classpath:beans.xml";
	protected ApplicationContext context;
	
	@Before
	public void init(){
		// 获取容器
		 context = new ClassPathXmlApplicationContext(configLocation);
	}
}
