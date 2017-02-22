package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;



public class Client {
	public static void main(String[] args) {
		NumberFormat f = new DecimalFormat("#.##");
		System.out.println(f.format(10.00-9.60));
	}
}
