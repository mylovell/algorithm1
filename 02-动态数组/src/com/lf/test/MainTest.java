package com.lf.test;

import com.lf.arraylist.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		
//		ArrayList<Object> list  = new ArrayList<>();
//		list.add(10);
//		list.add(new Person(10, "Jack"));
//		list.add(22);
//		
//		int index = list.indexOf(new Person(10, "Jack"));
//		System.out.println(index);
//		System.out.println(list);
//		System.out.println("OK");
		
		
		
//		ArrayList<Object> persons  = new ArrayList<>();
//		persons.add(new Person(10, "Jack"));
//		persons.add(null);
//		persons.add(new Person(15, "Rose"));
//		persons.add(null);
//		persons.add(new Person(12, "James"));
//		persons.add(null);
//
//		System.out.println(persons.indexOf(null));
//		System.out.println(persons);
		
		
		
//		test();
		
	}
	
	static void test() {
		// int -> Integer
	
		// 所有的类，最终都继承java.lang.Object

		// new是向堆空间申请内存
		ArrayList<Person> persons  = new ArrayList<>();
		persons.add(new Person(10, "Jack"));
		persons.add(new Person(12, "James"));
		persons.add(new Person(15, "Rose"));
		persons.clear();
		persons.add(new Person(22, "abc"));
		
		System.out.println(persons);
		ArrayList<Integer> ints  = new ArrayList<>();
		ints.add(10);
		ints.add(10);
		ints.add(22);
		ints.add(33);
		System.out.println(ints);
	}
	
	

}
