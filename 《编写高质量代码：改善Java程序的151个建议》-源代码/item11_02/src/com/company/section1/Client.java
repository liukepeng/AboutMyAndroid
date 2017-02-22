package com.company.section1;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class Client {
	public static void main(String[] args) {
		String str = "ABCDA";
		// �ж�һ���ַ����Ƿ�Ϊ�գ�null��""������true
		StringUtils.isEmpty(str);
		// �Ƿ�������
		StringUtils.isNumeric(str);
		// ����������ַ�
		System.out.println(StringUtils.left(str, 2));
		// ͳ�����ַ������ֵĴ���
		System.out.println(StringUtils.countMatches(str, "A"));
		// ת��XML��ʾ
		System.out.println(StringEscapeUtils.escapeXml(str));

		// ������ɣ�����Ϊ10�Ľ���ĸ���ַ���
		System.out.println(RandomStringUtils.randomAlphabetic(10));
		//������ɣ�����Ϊ10��ASCII�ַ���
		System.out.println(RandomStringUtils.randomAscii(10));
		//��һ������Ϊ������������ĸ��д��������Ϊ:Abc Bcd
		System.out.println(WordUtils.capitalize("abc bcd"));

	}
}
