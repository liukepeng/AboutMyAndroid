package com.company;

/**
 * 
 * ���л�������ڹ��캯����Ϊ��������ֵ
 *
 */
public class Deserialize {
	public static void main(String[] args) {
		//�����л�
		Person p = (Person)SerializationUtils.readObject();
		
		System.out.println(p.name);
	}
}
