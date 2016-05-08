package org.springframework.methodinjection;

public class Command {

	private String command;

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
	public void execute(){
		System.out.println("Execute command: " + this.command);
	}

}
