package com.company.section4;

import java.util.Date;

import org.joda.time.DateTime;

public class Client {
	public static void main(String[] args) {
		DateTime dt = new DateTime();
		// Joda��DateTimeתΪjdk��Date
		Date jdkDate = dt.toDate();
		// JDK��DateתΪJoda��DateTime
		dt = new DateTime(jdkDate);
	}
}
