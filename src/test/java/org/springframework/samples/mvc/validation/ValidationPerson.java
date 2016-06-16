package org.springframework.samples.mvc.validation;


import org.junit.Before;
import org.springframework.common.Container;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ValidationPerson extends Container {

	@Before
	public void init0(){
		ClassPathXmlApplicationContext beanFactory = (ClassPathXmlApplicationContext) this.context;
		
	}
}
