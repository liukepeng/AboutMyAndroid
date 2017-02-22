package com.company;

import java.util.Random;
/**
 * 莫让常量变成变量 
 *
 */
public class Client {	
	public static void main(String[] args) {
		System.out.println("常量会变哦：" + Const.RAND_CONST);
	}
}

/*接口常量*/
interface Const{
	//这还是常量吗？
	public static final int RAND_CONST = new Random().nextInt();
}