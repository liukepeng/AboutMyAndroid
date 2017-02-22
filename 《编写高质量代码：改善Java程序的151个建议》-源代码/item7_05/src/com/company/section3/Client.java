package com.company.section3;

import java.util.List;

public class Client {
	public static void main(String[] args) {
		Base base = new Sub();
	}
}

class Base{
	public void doStuff(Integer i){	
	}
}

class Sub extends Base{
	public void doStuff(Number n){	
	}
}