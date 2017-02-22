package com.company;

/**
 * 
 * 避免为final变量复杂赋值
 *
 */

public class Deserialize {
	public static void main(String[] args) {
		//反序列化
		Person p = (Person)SerializationUtils.readObject();
		
		System.out.println(p.name);
	}
}
