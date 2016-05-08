package org.springframework.learn.lifecycle;

import org.junit.Test;
import org.springframework.common.Container;
import org.springframework.lifecycle.AnnoationBean;
import org.springframework.lifecycle.ExampleBean;

public class ExampleBeanTest extends Container {

	@Test
	public void test(){

		Container.context.getBean("lifeBean", ExampleBean.class);
		
		Container.context.getBean("annBean", AnnoationBean.class);
	}
}
