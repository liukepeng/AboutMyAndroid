package com.company.section3;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * ������ȷ��������ķ���
 */
public class DaoTest {
	@Test
	public void testInsert(){
		//����
		assertEquals("foo", "foo");
		assertFalse(Boolean.FALSE);
	}
}

class Base{
	public Object doSomething(String str){
		return null;
	}
}

class Sub extends Base{
	@Override
	public String doSomething(String str){
		return null;
	}
}
