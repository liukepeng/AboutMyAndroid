package com.company.section4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Client {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		// 身高180CM
		list.add(new Person(180));
		// 身高175CM
		list.add(new Person(175));
		// 身高最矮的人大变身
		list.get(1).setHeight(185);
		
		//排序
		Collections.sort(list);
		for (Person p : list) {
			System.out.println("身高:" + p.getHeight());
		}
	}

	static class Person implements Comparable<Person> {
		// 身高
		private int height;

		public Person(int _age) {
			height = _age;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		// 按照身高排序
		public int compareTo(Person o) {
			return height - o.height;
		}

	}
}
