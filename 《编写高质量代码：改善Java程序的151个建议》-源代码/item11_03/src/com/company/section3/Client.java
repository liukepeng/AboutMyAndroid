package com.company.section3;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Client {
	public static void main(String[] args) {
		//��ǰʱ���
		DateTime dt = new DateTime();
		//��ʱ�׶��ǵ�ʱ��
		System.out.println(dt.withZone(DateTimeZone.forID("Europe/London")));
		//�������׼ʱ��
		System.out.println(dt.withZone(DateTimeZone.UTC));

	}
}
