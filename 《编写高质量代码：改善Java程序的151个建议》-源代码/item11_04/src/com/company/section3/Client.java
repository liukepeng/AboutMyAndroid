package com.company.section3;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import ch.lambdaj.Lambda;

public class Client {
	public static void main(String[] args) {
		// ����ƽ��ֵ
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(10);
		ints.add(100);
		ints.add(100);
		System.out.println(Lambda.avg(ints));
		// ͳ��ÿ��Ԫ�س��ֵĴ���
		System.out.println(Lambda.count(ints));

		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("A", 30));
		persons.add(new Person("B", 20));

		// ������������
		System.out.println(Lambda.sort(persons, Lambda.on(Person.class)
				.getAge()));
		// �������е�Ԫ��ָ������
		System.out.println(Lambda.joinFrom(persons).getName());
		// ���˳��������20�������Ԫ��
		System.out.println(Lambda.select(persons, new BaseMatcher<Person>() {
			@Override
			public boolean matches(Object _person) {
				Person p = (Person) _person;
				return p.getAge() > 20;
			}

			@Override
			public void describeTo(Description desc) {
				desc.appendText("���˵�����200");
			}

		}));
		// �������
		System.out.println(Lambda.maxFrom(persons).getAge());

		// ��ȡ������������Ϊһ������
		System.out.println(Lambda.extract(persons, Lambda.on(Person.class)
				.getName()));

	}
}

class Person {
	private String name;
	private int age;

	public Person(String _name, int _age) {
		name = _name;
		age = _age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "name:" + name + ",age =" + age;
	}
}
