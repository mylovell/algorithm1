package com.lf.practise;

import com.lf.practise.SLList.Node;

public class ReverseLinkedList<E> {
	
	public static void main(String[] args) {
		
		SLList<Integer> list = new SLList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Node<Integer> node = reverseList(list.first);
		System.out.println(node);
		list.first = node;
		System.out.println(list);
	}
	
	public static Node<Integer> reverseList(Node<Integer> head) {
    	
    	if (head == null || head.next == null)  return head;
    	
    	Node<Integer> newHead = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	
    	return newHead;
    }
	
	
//	private static class Node<E> {
//		Integer element;
//		Node<E> next;
//		public Node(Integer element, Node<E> next) {
//			this.element = element;
//			this.next = next;
//		}
//		@Override
//		public String toString() {
//			StringBuilder s = new StringBuilder();
//			Integer nextElement = next == null ? null : next.element;
//			s.append(element).append("_").append(nextElement);
//			return s.toString();
//		}
//		@Override
//		public void finalize() {
//			System.out.println("finalize = " + this.element);
//		}
//	}
//	
//	public class ListNode {
//		int val;
//		ListNode next;
//		ListNode(int x) {
//			val = x;
//		}
//	}
	
	
//    public ListNode reverseList(ListNode head) {
//    	
//    	if (head == null || head.next == null)  return head;
//    	
//    	ListNode newHead = reverseList(head);
//    	head.next.next = head;
//    	head.next = null;
//    	
//    	return newHead;
//    }
	
    
    
	
}

