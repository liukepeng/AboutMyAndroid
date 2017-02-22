package com.company.section2;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.MutableDateTime;

public class Client {
	public static void main(String[] args) {
		// ��ǰʱ���
		DateTime dt = new DateTime();
		// ��100Сʱ�����ڼ���
		System.out.println(dt.plusHours(100).dayOfWeek().getAsText());
		// 100��������
		System.out.println(dt.plusHours(100).toLocalDate());
		// 10��ǰ�Ľ��������ڼ�
		System.out.println(dt.minusYears(10).dayOfWeek().getAsText());

		// ���������ж���Сʱ
		System.out.println(Hours.hoursBetween(dt, new DateTime("2012-12-21"))
				.getHours());

		// ��ǰ�ɱ�ʱ��
		MutableDateTime mdt = new MutableDateTime();
		// 10��������
		DateTime destDateTime = dt.plusYears(10);
		while (mdt.isBefore(destDateTime)) {
			// ѭ��һ�μ�1��
			mdt.addDays(1);
			// ��13�ţ�������������
			if (mdt.getDayOfMonth() == 13 && mdt.getDayOfWeek() == 5) {
				// ��ӡ��10�������к�ɫ������
				System.out.println("��ɫ�����壺" + mdt);
			}
		}
		
		System.out.println(Long.MAX_VALUE);
	}
}
