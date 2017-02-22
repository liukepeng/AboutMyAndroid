package com.company.section1;

import java.util.EnumSet;

public class Client {
	public static void main(String[] args) {
		//�������ɰ�������ö�����EnumSet
		EnumSet<Const> cs = EnumSet.allOf(Const.class);
		EnumSet<LargeConst> lcs = EnumSet.allOf(LargeConst.class);
		//��ӡ��ö��������
		System.out.println("Constö����������" + cs.size());
		System.out.println("LargeConstö����������" + lcs.size());
		//�������EnumSet��class
		System.out.println(cs.getClass());
		System.out.println(lcs.getClass());
	}
}

//��ͨö�������С��64
enum Const {
	A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BA, CA, DA, EA, FA, GA, HA, NA, OA, PA, QA, RA, SA, TA, UA, VA, WA, XA, YA, ZA, BC, CC, DC, EC, FC, GC, HC, IC, JC, KC, LC, MC, NC, OC, PC, QC, RC;
}
//��ö�٣���������64
enum LargeConst {
	A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BA, CA, DA, EA, FA, GA, HA, IA, JA, KA, LA, MA, NA, OA, PA, QA, RA, SA, TA, UA, VA, WA, XA, YA, ZA, AB, BB, CB, DB, EB, FB, GB, HB, IB, JB, KB, LB, MB;
}