package com.company.section5;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.beanutils.PropertyUtils;


public class Client {
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setAge(10);
		user.setName("����");
		Person person = new Person();
		// ����Bean���Կ���
		PropertyUtils.copyProperties(person, user);
		System.out.println(person.getName());

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "aa1");
		// ��Map�еļ�ֵ�Կ�����Bean��
		PropertyUtils.copyProperties(person, map);
		System.out.println(person.getName());

		// ��̬Bean�����ȶ���Bean��
		DynaProperty[] props = new DynaProperty[] {
				new DynaProperty("name", String.class),
				new DynaProperty("age", int.class) };
		BasicDynaClass dynaClass = new BasicDynaClass("people", null, props);
		//��̬Bean����
		DynaBean people = dynaClass.newInstance();
		people.set("name", "����");
		System.out.println(people.get("name"));
		
		
		//����ʽBean
		 DynaBean dynaBean = new LazyDynaBean();
		 dynaBean.set("foo", 0,"dd"); 
		 System.out.println(dynaBean.get("foo"));
	}
}
