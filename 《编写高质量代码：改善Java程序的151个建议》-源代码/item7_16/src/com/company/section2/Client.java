package com.company.section2;

public class Client {
	public static void main(String[] args) throws Exception {
		AbsPopulator pop = new UserPopulator();
		pop.dataInitialing();
	}
}
