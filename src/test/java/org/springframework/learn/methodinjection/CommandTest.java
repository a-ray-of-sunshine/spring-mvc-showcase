package org.springframework.learn.methodinjection;

import org.junit.Test;
import org.springframework.common.Container;
import org.springframework.methodinjection.CommandManager;

public class CommandTest extends Container {

	@Test
	public void test(){
		
		CommandManager cm = Container.context.getBean("commandManager", CommandManager.class);
		
		System.out.println(cm);
		
		cm.process("open");
		
		cm.process("edit");
		
		cm.process("save");
	}
}
