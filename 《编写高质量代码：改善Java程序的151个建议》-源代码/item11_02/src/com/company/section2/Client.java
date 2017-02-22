package com.company.section2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Client {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("ddd");
		p.setAge(18);
		System.out.println(p);
	}
}

class Person {
	private String name;
	private int age;

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

	// �Զ��������ʾ
	public String toString() {
		return new ToStringBuilder(this)
				.append("����", name)
				.append("����", age)
				.toString();
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Person p = (Person) obj;
		// ֻҪ������ͬ������Ϊ�����������
		return new EqualsBuilder()
					.appendSuper(super.equals(obj))
					.append(name,
				p.name).isEquals();
	}

	// �Զ���hashCode
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
