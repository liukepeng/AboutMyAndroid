package com.company.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Client {
	public static void main(String[] args) {
	
		List<City> cities = new ArrayList<City>();
		cities.add(new City("021","�Ϻ�"));
		cities.add(new City("021","��"));
		
		City city = new City("021","��");
		//����
		Collections.sort(cities);
		// indexOf����ȡ������ֵ
		int index1 = cities.indexOf(city);
		// binarySearch���ҵ�����ֵ
		int index2 = Collections.binarySearch(cities, city);
		System.out.println("����ֵ(indexOf)��" + index1);
		System.out.println("����ֵ��binarySearch)��" + index2);
	}
}

class City implements Comparable<City> {
	//���б���
	private String code;
	//��������
	private String name;
	
	public City(String _code,String _name){
		code = _code;
		name = _name;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(City o) {
		// ���ճ�����������
		return new CompareToBuilder().append(name, o.name).toComparison();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		City city = (City) obj;
		//����code�ж��Ƿ����
		return new EqualsBuilder()
				.append(code, city.code)
				.isEquals();
	}
}
