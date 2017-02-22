package com.company.section4;

import java.util.Date;

import org.joda.time.DateTime;

public class Client {
	public static void main(String[] args) {
		DateTime dt = new DateTime();
		// Joda的DateTime转为jdk的Date
		Date jdkDate = dt.toDate();
		// JDK的Date转为Joda的DateTime
		dt = new DateTime(jdkDate);
	}
}
