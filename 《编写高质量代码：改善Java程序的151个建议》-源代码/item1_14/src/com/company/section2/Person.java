package com.company.section2;

import java.io.IOException;
import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID =60407L;
	//����
	private String name;
	//нˮ
	private transient Salary salary;
	
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
	
	//���л�ʱ��handler
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeInt(salary.getBasePay());
	}
	//�����л�ʱ��hanlder
	private void readObject(java.io.ObjectInputStream in) throws IOException,ClassNotFoundException {
		in.defaultReadObject();
		salary = new Salary(in.readInt(),0);
	}
	
	
}
