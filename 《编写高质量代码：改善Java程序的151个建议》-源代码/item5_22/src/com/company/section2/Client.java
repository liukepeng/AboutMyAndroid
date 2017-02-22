package com.company.section2;

import java.util.SortedSet;
import java.util.TreeSet;

public class Client {
	public static void main(String[] args) {
		SortedSet<Person> set = new TreeSet<Person>();
		// ���180CM
		set.add(new Person(180));
		// ���175CM
		set.add(new Person(175));
		// �������˴����
		set.first().setHeight(185);
		for (Person p : set) {
			System.out.println("���:" + p.getHeight());
		}
	}

	static class Person implements Comparable<Person> {
		// ���
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

		// �����������
		public int compareTo(Person o) {
			return height - o.height;
		}

	}
}
