package com.company.section1;


public class Deserialize {
	public static void main(String[] args) {
		//����ϵͳ�����л�������ӡ��Ϣ
		Person p = (Person)SerializationUtils.readObject();
		StringBuffer sb = new StringBuffer();
		sb.append("����:" + p.getName());
		sb.append(" \t�������ʣ�" + p.getSalary().getBasePay());
		sb.append(" \t��Ч���ʣ�" + p.getSalary().getBonus());
		System.out.println(sb);
	}
}
