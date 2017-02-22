package com.company.section2;

import gnu.trove.decorator.TIntListDecorator;
import gnu.trove.function.TIntFunction;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.procedure.TIntProcedure;

import java.util.List;

public class Client {
	public static void main(String[] args) {
		// �������͵ļ���,��ʹ�ð�װ����
		TIntList intList = new TIntArrayList();
		// ÿ��Ԫ��ֵ����2
		intList.transformValues(new TIntFunction() {
			public int execute(int element) {
				return element * 2;
			}
		});
		// ���ˣ��Ѵ���200��Ԫ�����һ���µ��б�
		TIntList t2 = intList.grep(new TIntProcedure() {
			public boolean execute(int _element) {
				return _element > 200;
			}
		});
		// ��װΪJDK��List
		List<Integer> list = new TIntListDecorator(intList);
		// ������ȷ��Map
		TIntObjectMap<String> map = new TIntObjectHashMap<String>();
	}
}
