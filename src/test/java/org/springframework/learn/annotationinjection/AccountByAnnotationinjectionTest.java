package org.springframework.learn.annotationinjection;

import org.junit.Test;
import org.springframework.annotationinjection.AccountByAnnotation;
import org.springframework.common.Container;

public class AccountByAnnotationinjectionTest extends Container{

	@Test
	public void test(){
		AccountByAnnotation bean = Container.context.getBean("accAnnot", AccountByAnnotation.class);	
		System.out.println(bean.getUser());
	}
}
