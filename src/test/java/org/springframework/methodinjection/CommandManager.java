package org.springframework.methodinjection;

public abstract class CommandManager {

	public void process(String cmd){
		
		Command command = createCommand();
		System.out.println("Command: " + command);
		
		command.setCommand(cmd);
		
		command.execute();
	}
	
	// 字段注入，只能够初始化一次，如果一个单例的bean依赖于一个 有状态的bean,
	// 则通过字段注入就不行了, 字段注入只发生在 这个单例 bean(CommandManger) 初始化的时候
	// 一旦，单例 bean 初始化，它所依赖的有状态bean也就被，注入成当时状态的那个了，无法动态获取了
	// 所以， spring 提供了方法，注入，spring在实现的时候，通过动态代理实现，单例bean在需要
	// 有状态 bean 是，通过 这个注入的方法来获取 ，而这个方法则会获取新的bean
	protected abstract Command createCommand();

}
