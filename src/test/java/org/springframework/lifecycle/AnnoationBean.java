package org.springframework.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnoationBean {

	// 这两个注解没有起作用，应用是配置有问题
	@PostConstruct
	public void init(){
		System.out.println(this + " init");
	}

	@PreDestroy
	public void destory(){
		System.out.println(this + " destory");
	}
}
