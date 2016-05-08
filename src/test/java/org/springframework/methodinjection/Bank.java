package org.springframework.methodinjection;

import org.springframework.beans.Account;

/**
 * 在系统内是单例的，但是它要管理，prototype类型的 Account
 */
public class Bank {

	private Account account;
	
	public void setAccount(Account account) {
		this.account = account;
	}

	public void showAcccountInfo(){
		System.out.println(account);
		this.account.doSomething();
	}
}
