package com.company.section1;

public abstract class AbsPopulator {
	//ģ�巽��
	public final void dataInitialing() throws Exception {
		//���û�������
		doInit();
	}
	//��������
	protected abstract void doInit();
}

