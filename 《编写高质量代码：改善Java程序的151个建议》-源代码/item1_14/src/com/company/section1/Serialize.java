package com.company.section1;

public class Serialize {
	public static void main(String[] args) {
		//��������1000Ԫ,��Ч����2500Ԫ
		Salary salary = new Salary(1000,2500);
		//��¼��Ա��Ϣ
		Person person = new Person("����",salary);
		//HRϵͳ�־û��������ݵ���˰ϵͳ
		SerializationUtils.writeObject(person);
	}
}
