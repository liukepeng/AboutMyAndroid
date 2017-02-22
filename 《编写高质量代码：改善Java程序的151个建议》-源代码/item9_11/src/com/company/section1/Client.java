package com.company.section1;


public class Client {

	public static void main(String[] args) {
		new Thread(new Foo()).start();
	}

}

class Foo implements Runnable{
	@Override
	public void run(){
		//Ö´ÐÐµÝ¹éº¯Êý
		fun(10);
	}
	//µÝ¹éº¯Êý
	public synchronized void fun(int i) {
		if (--i > 0) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println(i);
			fun(i);
		}
	}
}
