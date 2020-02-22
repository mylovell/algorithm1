package com.lf.test;

import com.lf.list.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		

		ArrayList<Object> list  = new ArrayList<>();
		list.add(10);
		list.add(new Person(10, "Jack"));
		list.add(22);
		list.indexOf(new Person(10, "Jack"));
		
		list.toString();
		

		System.out.println("OK");
	}

}
