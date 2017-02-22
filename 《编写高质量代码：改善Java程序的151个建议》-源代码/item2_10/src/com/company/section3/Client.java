package com.company.section3;

import java.util.Random;

/**
 *
 * @author Phenix
 * 2011-3-8
 */
public class Client {
	public static void main(String[] args) {
		Random r = new MyRandom();
		for(int i=1;i<4;i++){
			System.out.println("µÚ"+i+"´Î£º"+r.nextInt());
		}
	}
}
