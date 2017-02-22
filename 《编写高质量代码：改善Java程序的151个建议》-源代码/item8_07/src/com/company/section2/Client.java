package com.company.section2;

public class Client {
	enum Color {
		Red, Blue;
	}

	public static void main(String[] args) {
		System.out.println(Contain(Color.class, "不存在的枚举项"));
		System.out.println(Contain(Color.class, "Blue"));
	}

	// 判断一个枚举是否包含String枚举项
	public static <T extends Enum<T>> boolean Contain(Class<T> c, String name) {
		//遍历枚举项
		for(T t:c.getEnumConstants()){
			//枚举项名称是否相等
			if(t.name().equals(name)){
				return true;
			}
		}
		return false;	
	}
}
