package com.company.section3;

public class Client {
	/*
	 * ���㷨����ĳĳ�㷨���㣬�����Ż���ʱ��̫�����Ժ���˵
	 */
	public void doSomethong(){
		
	}
}

/**
 * 2010-09-16  ����   ���������⣬ʵ��XX�㷨
 * 2010-10-28  ����   �����㷨�е�XXXXȱ��
 * 2010-11-30  ����   �ع���XXX����
 * 2011-02-06  ����   ɾ����XXXX���÷���
 * 2011-04-08  ����   �Ż���XXX������
 
 */
class Foo{

	/**
	* Attempt to acquire the lock for the given mutex. If the mutex has already
	* been acquired, the call returns immediately with APR_EBUSY. Note: it
	* is important that the APR_STATUS_IS_EBUSY(s) macro be used to determine
	* if the return value was APR_EBUSY, for portability reasons.
	* @param mutex the mutex on which to attempt the lock acquiring.
	*/
	public static native int trylock(long mutex);

		
}