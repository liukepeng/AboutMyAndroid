package com.company.section3;

import java.util.Random;

/**
 *
 *�̳�Random�࣬��дα�������
 * 2011-3-8
 */

public class MyRandom extends Random {
	@Override
	protected int next(int bits){	
		//α������ǹ̶�ֵ
		return 11111111;		
	}

}
