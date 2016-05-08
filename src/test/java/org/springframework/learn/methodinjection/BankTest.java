package org.springframework.learn.methodinjection;

import org.junit.Test;
import org.springframework.common.Container;
import org.springframework.methodinjection.Bank;

public class BankTest extends Container {

	@Test
	public void test(){
		
		Bank bank = Container.context.getBean("bank", Bank.class);
		System.out.println(bank);
		
		// bank (singleton) 对象的scope 比 account (prototype)大
		// 所以如果，在 beans.xml 配置 account 对象时，没有加：<aop:scoped-proxy/>
		// 则下面的三个调用将使用同一个 account 对象
		// 而事实是，需要有三个不同的account 对象。所以使用 <aop:scoped-proxy/>
		bank.showAcccountInfo();
		bank.showAcccountInfo();
		bank.showAcccountInfo();
	}
}
