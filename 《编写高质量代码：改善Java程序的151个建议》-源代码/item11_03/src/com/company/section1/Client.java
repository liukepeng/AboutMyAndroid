package com.company.section1;

import java.util.Locale;

import org.joda.time.DateTime;

public class Client {
	public static void main(String[] args) {
		//当前时间戳
		DateTime dt = new DateTime();
		//输出英文星期
		System.out.println(dt.dayOfWeek().getAsText(Locale.ENGLISH));
		//本地日期格式
		System.out.println(dt.toLocalDate());
	}
}
