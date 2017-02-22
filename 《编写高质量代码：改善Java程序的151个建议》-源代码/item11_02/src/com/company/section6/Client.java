package com.company.section6;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.LazyDynaBean;

public class Client {
	public static void main(String[] args) throws Exception {

		// ��̬Bean�����ȶ���Bean��
		DynaProperty[] props = new DynaProperty[] {
				new DynaProperty("name", String.class),
				new DynaProperty("age", int.class) };
		BasicDynaClass dynaClass = new BasicDynaClass("people", null, props);
		// ��̬Bean����
		DynaBean people = dynaClass.newInstance();
		people.set("name", "����");
		System.out.println(people.get("name"));

		// ����Bean
		DynaBean user = new LazyDynaBean();
		// ֱ�Ӷ������Ժ�ֵ
		user.set("name", "����");
		System.out.println(user.get("name"));
		// �������������޶���������ΪMap
		user.set("phoneNum", "tel", "021");
		user.set("phoneNum", "mobile", "138");

		// ��������ΪArrayList
		user.set("address", 0, "�Ϻ�");
		user.set("address", 1, "����");
		System.out.println(user.get("address").getClass());
	}
}
