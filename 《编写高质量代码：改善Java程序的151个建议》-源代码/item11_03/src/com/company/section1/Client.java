package com.company.section1;

import java.util.Locale;

import org.joda.time.DateTime;

public class Client {
	public static void main(String[] args) {
		//��ǰʱ���
		DateTime dt = new DateTime();
		//���Ӣ������
		System.out.println(dt.dayOfWeek().getAsText(Locale.ENGLISH));
		//�������ڸ�ʽ
		System.out.println(dt.toLocalDate());
	}
}
