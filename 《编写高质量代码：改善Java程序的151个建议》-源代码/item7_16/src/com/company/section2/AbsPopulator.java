package com.company.section2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class AbsPopulator {
	// ģ�巽��
	public final void dataInitialing() throws Exception {
		// ������е�public����
		Method[] methods = getClass().getMethods();
		for (Method m : methods) {
			// �ж��Ƿ������ݳ�ʼ������
			if (isInitDataMethod(m)) {
				m.invoke(this);
			}
		}
	}

	// �ж��Ƿ������ݳ�ʼ����������������������
	private boolean isInitDataMethod(Method m) {
		return m.getName().startsWith("init") // init��ʼ
		&& Modifier.isPublic(m.getModifiers()) // ��������
		&& m.getReturnType().equals(Void.TYPE) // ����ֵ��void
		&& !m.isVarArgs() // �������Ϊ��
		&& !Modifier.isAbstract(m.getModifiers()); // �����ǳ��󷽷�
	}
}
