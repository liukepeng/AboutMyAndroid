package com.company.section1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

	public static void main(String[] args) {
		// Person���ʵ����ΪMap��key
		Map<Person, Object> map = new HashMap<Person, Object>() {
			{
				put(new Person("����"), new Object());
			}
		};
		// Person���ʵ����ΪList��Ԫ��
		List<Person> list = new ArrayList<Person>() {
			{
				add(new Person("����"));
			}
		};

		// �б����Ƿ����
		boolean b1 = list.contains(new Person("����"));
		// Map���Ƿ����
		boolean b2 = map.containsKey(new Person("����"));
	}
}

class Person {
	private String name;

	public Person(String _name) {
		name = _name;
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		this.name = _name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Person p = (Person) obj;
			if (p.getName() == null && name == null) {
				return false;
			} else {
				return name.equalsIgnoreCase(p.getName());
			}
		}
		return false;
	}
}
