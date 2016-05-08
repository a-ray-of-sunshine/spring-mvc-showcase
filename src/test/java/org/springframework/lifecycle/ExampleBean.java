package org.springframework.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ExampleBean implements BeanPostProcessor, InitializingBean, DisposableBean{

	@SuppressWarnings("unused")
	private String field;
	
	public void setField(String field) {
		System.out.println("setField");
		this.field = field;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(this + " destroy");
	}

	/**
	 * InitializingBean 这个方法将当前实现 bean
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this + " afterPropertiesSet");
	}

	/**
	 * BeanPostProcessor 接口中的 这两个方法，将在beanfactory 创建每一个对象时所调用
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + ": postProcessBeforeInitialization");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + ": postProcessAfterInitialization");
		return bean;
	}

}
