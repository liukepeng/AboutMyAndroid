package com.company.section1;

public class Client {
	enum Color {
		Red, Blue;
	}

	public static void main(String[] args) {
		Contain(Color.class, "�����ڵ�ö����");
	}

	// �ж�һ��ö���Ƿ����Stringö����
	public static <T extends Enum<T>> boolean Contain(Class<T> c, String name) {
		boolean result = false;
		try {
			Enum.valueOf(c, name);
			result = true;
		} catch (RuntimeException e) {
			// ֻҪ���׳��쳣������Ϊ�ǲ�����
		}
		return result;
	}
}
