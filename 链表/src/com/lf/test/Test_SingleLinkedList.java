package com.lf.test;

import com.lf.linkedlist.SingleLinkedList;
import com.lf.list.DAList;
import com.lf.list.DCLList;
import com.lf.list.DCLList2;
import com.lf.list.DLList;
import com.lf.list.List;
import com.lf.list.SCLList;
import com.lf.list.SLList;
import com.lf.practise.SLList.Node;
import com.lf.linkedlist.DoubleCircleLinkedList;
import com.lf.linkedlist.DoubleCircleLinkedList2;
import com.lf.linkedlist.DoubleLinkedList;
import com.lf.linkedlist.SingleCircleLinkedList;


public class Test_SingleLinkedList {

	public static void main(String[] args) {
		
		new com.lf.practise.SLList<Integer>().testReverse();
		
		
		// 动态数组
//		testList(new ArrayList<>());
//		testList(new DAList<Integer>());
		
		// 单向链表
//		testList(new SingleLinkedList<Integer>());
//		testList(new SLList<Integer>());
		
		// 双向链表
//		testList(new DoubleLinkedList<Integer>());
//		testList(new DLList<Integer>());
		
		// 单向循环链表
//		testList(new SingleCircleLinkedList<Integer>());
//		testList(new SCLList<Integer>());
		
		// 双向循环链表
//		testList(new DoubleCircleLinkedList<Integer>());
//		testList(new DCLList<Integer>());
		
		// 双向循环链表（加强版）
//		josephus(new DoubleCircleLinkedList2<Integer>());
//		josephus(new DCLList2<Integer>());
		
	}
	
	
	static void testList(DoubleCircleLinkedList<Integer> list) {
		
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		
		list.add(0, 55); // [55, 11, 22, 33, 44]
		list.add(2, 66); // [55, 11, 66, 22, 33, 44]
		list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]
		

		list.remove(0); // [11, 66, 22, 33, 44, 77]
		list.remove(2); // [11, 66, 33, 44, 77]
		list.remove(list.size() - 1); // [11, 66, 33, 44]

		Asserts.test(list.indexOf(44) == 3);
		Asserts.test(list.indexOf(22) == SingleLinkedList.ELEMENT_NOT_FOUND);
		Asserts.test(list.contains(33));
		Asserts.test(list.get(0) == 11);
		Asserts.test(list.get(1) == 66);
		Asserts.test(list.get(list.size() - 1) == 44);
		
		// size=4, [11, 66, 33, 44]
		System.out.println(list);
		
		System.out.println("------------");
//		list.clear();
//		System.gc();//手动请求gc
		
	}
	
	
	/*
	 	3
		6
		1
		5
		2
		8
		4
		7
	 */
	static void josephus(DCLList2<Integer> list) {
		for (int i = 1; i <= 8; i++) {
			list.add(i);
		}
		
		// 指向头结点（指向1）
		list.reset();
		
		while (!list.isEmpty()) {
			list.next();
			list.next();
			System.out.println(list.remove());
		}
	}

	
	

}
