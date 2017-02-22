package com.company.section1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Client {

	public static void main(String[] args) {
		BaseDao<String> userDao = new UserDao();
		userDao.get(12);
	}

}

abstract class BaseDao<T> {
	// ���T������������
	private Class<T> clz = Utils.getGenricClassType(getClass());

	// �����������һ����¼
	public void get(long id) {
		//session.get(clz,id);
	}
}

// ����user��
class UserDao extends BaseDao<String> {

}

class Utils {
	// ���һ���������ʵ�ʷ�������
	public static <T> Class<T> getGenricClassType(Class clz) {
		Type type = clz.getGenericSuperclass();
		if (type instanceof ParameterizedType) {	
			ParameterizedType pt = (ParameterizedType) type;
			Type[] types = pt.getActualTypeArguments();
			if (types.length > 0 && types[0] instanceof Class) {
				//���ж�����Ͳ���������λ����������
				return (Class) types[0];
			}
		}
		return (Class)Object.class;

	}
}