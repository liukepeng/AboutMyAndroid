package com.company.section4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
	public static void main(String[] args) {

	}

	public static void write(List<? super Number> list) {
		list.add(123);
		list.add(3.14);
	}

}
