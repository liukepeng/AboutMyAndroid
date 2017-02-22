package com.company;

public class Client {
	public static void main(String[] args) {
		System.out.println(new Person("уехЩ"));
	}
}

class Person{
	private String name;
	
	public Person(String _name){
		name = _name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return String.format("%s.name=%s",this.getClass(),name);
	}
}