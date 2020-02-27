package com.lf.practise;

import com.lf.practise.SLList.Node;
//import com.lf.practise.SCLList.Node;

/**
 * 
 * @author FengLuo
 *
 */
public class Main<E> {
	
	public static void main(String[] args) {
		
//		SCLList<Integer> list = new SCLList<Integer>();
		SLList<Integer> list = new SLList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		System.out.println("是否成环：" + isCircle(list));
	}
	
	
	/**
	 * 是否成环
	 * @param list
	 * @return
	 */
	private static boolean isCircle(SLList<Integer> list) {
		
		if (list == null || list.size() <= 0) return false;
		
		Node<Integer> slow = list.first;
		Node<Integer> fast = list.first.next;
		
		for (int i = 0; i < list.size(); i++) {
			if (slow == fast) { return true;}
			if (fast == null) { return false; }
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
		
	}

	
	
}
