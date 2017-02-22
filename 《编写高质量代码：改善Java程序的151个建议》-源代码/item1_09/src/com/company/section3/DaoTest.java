package com.company.section3;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * 具有明确表象意义的方法
 */
public class DaoTest {
	@Test
	public void testInsert(){
		//断言
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
