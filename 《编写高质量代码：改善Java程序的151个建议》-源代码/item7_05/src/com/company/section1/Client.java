package com.company.section1;

import java.util.List;

public class Client {
	public static void main(String[] args) {
		
	}
}

class Base{
	public Number doStuff(){
		return 0;
	}
}

class Sub extends Base{
	@Override
	public Integer doStuff(){
		return 0;
	}
}