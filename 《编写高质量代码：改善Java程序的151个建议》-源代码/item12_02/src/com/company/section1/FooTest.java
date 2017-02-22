package com.company.section1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FooTest {
	//�������Զ���
	private Foo foo = new Foo();
	
	//�������Գ���
	@Test
	public void testDividNormal() {
		//����100����10�Ľ��Ϊ10
		assertEquals(10, foo.divid(100, 10));
	}
	
	//�߽���Գ���
	@Test
	public void testDividBroader() {
		//�������ֵ������Сֵ���Ϊ0
		assertEquals(0, foo.divid(Integer.MAX_VALUE, Integer.MIN_VALUE));
		//������Сֵ�������ֵ���Ϊ-1
		assertEquals(-1, foo.divid(Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	//�쳣���Գ���
	@Test(expected = ArithmeticException.class)
	public void testDividException() {
		//���Գ���Ϊ0ʱ�׳�ArithmeticException
		foo.divid(100, 0);
		//���Բ���ִ�е�����
		fail();
	}
}
