package com.company.section1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) throws Exception {
		//����Jerry��ֻ��������������
		Animal Jerry = new Rat();
		//ΪJerry���ӷ�������
		Jerry = new DecorateAnimal(Jerry, FlyFeature.class);
		//Jerry�����ھ�����
		Jerry = new DecorateAnimal(Jerry, DigFeature.class);
		//Jerry��ʼˣè��
		Jerry.doStuff();
	}
}

// ���嶯��
interface Animal {
	public void doStuff();
}

// ������һ�ֶ���
class Rat implements Animal {
	public void doStuff() {
		System.out.println("Jerry will play with Tom.");
	}
}

// ����ĳ������
interface Feature {
	// ��������
	public void load();
}

// ��������
class FlyFeature implements Feature {
	public void load() {
		System.out.println("����һֻ��򡭡�");
	}
}

// �ھ�����
class DigFeature implements Feature {
	public void load() {
		System.out.println("�����ھ���������");
	}
}

// ����İ�װ�࣬���԰�װ���еĶ���
class DecorateAnimal implements Animal {
	// ����װ�Ķ���
	private Animal animal;
	// ʹ����һ����װ��
	private Class<? extends Feature> clz;

	public DecorateAnimal(Animal _animal, Class<? extends Feature> _clz) {
		animal = _animal;
		clz = _clz;
	}
	@Override
	public void doStuff() {
		InvocationHandler handler = new InvocationHandler(){
			// �����װ��Ϊ
			public Object invoke(Object p, Method m, Object[] args) throws Throwable {
				Object obj = null;
				//���ð�װ�������������ReturnType��Modifier��
				if(Modifier.isPublic(m.getModifiers())){
					obj = m.invoke(clz.newInstance(), args);
				}		
				animal.doStuff();
				return obj;
			}
		};
		// ��ǰ������
		ClassLoader cl = getClass().getClassLoader();
		// ��̬������Handler������ΰ�װ
		Feature proxy = (Feature) Proxy.newProxyInstance(cl, clz
				.getInterfaces(), handler);
		proxy.load();
	}
}

