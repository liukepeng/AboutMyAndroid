package com.company.section7;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;


public class Client {
	public static void main(String[] args) throws Exception {
		User user = new User("����", 18);
		//ת������
		ConvertUtilsBean cub = new ConvertUtilsBean();
		//ע��һ��ת����
		cub.register(new Converter() {
			public Object convert(Class type, Object value) {
				//Ϊÿ��String���͵����Լ���ǰ׺
				return "prefix-" + value;
			}
		}, String.class);
		//����һ�������ض�ת�����ߵ�Bean������
		BeanUtilsBean beanUtils = new BeanUtilsBean(cub);
		System.out.println(beanUtils.getProperty(user, "name"));
	}
}
