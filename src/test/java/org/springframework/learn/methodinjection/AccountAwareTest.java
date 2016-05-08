package org.springframework.learn.methodinjection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.common.Container;
import org.springframework.methodinjection.AccountAware;

public class AccountAwareTest extends Container{

	private static final Logger logger = LoggerFactory.getLogger(AccountAwareTest.class);

	@Test
	public void test(){
		AccountAware accountAware = this.context.getBean("accountAware", AccountAware.class);

		accountAware.LookupContext();
		
		logger.debug(accountAware.toString());
		
	}
}
