package com.company.section2;

import java.util.HashMap;
import java.util.Map;

public class Client {
	public static void main(String[] args) {
		Base b = new Base();
		b.doStuff(new HashMap());
	}
}

class Base {
	public void doStuff(HashMap map) {
		System.out.println("Base");
	}
}

class Sub extends Base {
	public void doStuff(Map map) {
		System.out.println("sub");
	}
}
