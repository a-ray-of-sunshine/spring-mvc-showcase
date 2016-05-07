package org.springframework.learn;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitContainer {

	private String configLocation = "classpath:beans.xml";
	private ApplicationContext context;
	
	@Before
	public void init(){
		// 获取容器
		 context = new ClassPathXmlApplicationContext(configLocation);
	}

	@Test
	public void initContainer(){
		
		// 获取 容器 中配置的 bean
		User user = context.getBean("user", User.class);
		
		System.out.println(user);
	}
	
	@Test
	public void registerOuterBean(){
		
		User user = new User("zhansan", "999");
		ConfigurableApplicationContext ca = (ConfigurableApplicationContext)this.context;
		
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ca.getBeanFactory();
		
		// 动态向容器中添加，bean
		beanFactory.registerSingleton("zhansan", user);
		
		user = this.context.getBean("zhansan", User.class);
		
		System.out.println(user);
	}
	
	@Test
	public void registerByBeandefinition(){
		ConfigurableApplicationContext ca = (ConfigurableApplicationContext)this.context;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ca.getBeanFactory();
		
		String beanName = "wangwu";
		BeanDefinition beanDefinition = new GenericBeanDefinition();
		// 如果没有下面的调用，将出错,因为beanfactory 不知道bean的类型，也就没法
		// 实例化 bean
		// beanDefinition.setBeanClassName(Object.class.getName());
		
		// 注入一个 User
		GenericBeanDefinition bd = (GenericBeanDefinition) beanDefinition;
		// beanDefinition.setBeanClassName(User.class.getName());
		bd.setBeanClass(User.class);
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.add("name", "wanwu");
		propertyValues.add("password", "678");
		bd.setPropertyValues(propertyValues);
		
		this.printContextStatus();
		beanFactory.registerBeanDefinition(beanName, beanDefinition);;
		this.printContextStatus();
		
		Object bean = this.context.getBean("wangwu");
		System.out.println(bean);
		System.out.println(bean.getClass());
		
		// 为 wangwu 对象注册别名
		beanFactory.registerAlias("wangwu", "ww");
		bean = this.context.getBean("ww");
		System.out.println(bean);
		System.out.println(bean.getClass());
	
	}
	
	@Test
	public void testAlias(){
		
		// 通过 bean 的别名一获取 bean
		Object bean = this.context.getBean("lisi");
		System.out.println("alias: " + bean);
		System.out.println("alias: " + bean.getClass());

	}
	
	private void printContextStatus(){
		String[] names = this.context.getBeanDefinitionNames();
		for(String name:names){
			System.out.println(name);
		}
		System.out.println(" ===================== ");
	}
}
