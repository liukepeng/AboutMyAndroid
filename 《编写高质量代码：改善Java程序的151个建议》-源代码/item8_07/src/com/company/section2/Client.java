package com.company.section2;

public class Client {
	enum Color {
		Red, Blue;
	}

	public static void main(String[] args) {
		System.out.println(Contain(Color.class, "�����ڵ�ö����"));
		System.out.println(Contain(Color.class, "Blue"));
	}

	// �ж�һ��ö���Ƿ����Stringö����
	public static <T extends Enum<T>> boolean Contain(Class<T> c, String name) {
		//����ö����
		for(T t:c.getEnumConstants()){
			//ö���������Ƿ����
			if(t.name().equals(name)){
				return true;
			}
		}
		return false;	
	}
}
