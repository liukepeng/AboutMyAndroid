package com.company;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		Person p1 = new Person("����");
		Person p2 = new Person(null);
		
		List<Person> l =new ArrayList<Person>();		
		l.add(p1);
		l.add(p2);
		System.out.println("�б����Ƿ����������"+l.contains(p1));
		System.out.println("�б����Ƿ�������� ��"+l.contains(p2));
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
	public boolean equals(Object obj) {
		if(obj instanceof Person){
			Person p = (Person) obj;
			return name.equalsIgnoreCase(p.getName());
		}
		return false;
	}	
}
