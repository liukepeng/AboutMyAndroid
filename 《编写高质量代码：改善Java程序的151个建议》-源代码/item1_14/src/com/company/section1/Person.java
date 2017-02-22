package com.company.section1;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID =60407L;
	//ÐÕÃû
	private String name;
	//Ð½Ë®
	private Salary salary;
	
	public Person(String _name,Salary _salary){
		name=_name;
		salary=_salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	
	
}
