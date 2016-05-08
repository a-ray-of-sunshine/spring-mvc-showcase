package org.springframework.methodinjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AccountAware implements ApplicationContextAware{

	private ApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountAware.class);
	
	public void LookupContext(){
		String[] names = this.context.getBeanDefinitionNames();
		for(String name : names){
			logger.debug(name);
		}
	}
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	};
}
