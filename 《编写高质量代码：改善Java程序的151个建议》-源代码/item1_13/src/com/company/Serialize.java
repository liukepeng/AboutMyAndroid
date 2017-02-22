package com.company;

public class Serialize {
	public static void main(String[] args) {
		//序列化以作持久保存
		SerializationUtils.writeObject(new Person());
	}
}
