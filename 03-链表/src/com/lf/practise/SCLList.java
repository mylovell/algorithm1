package com.lf.practise;

import com.lf.list.AbstractList;
import com.lf.practise.SLList.Node;

/**
 * 单向循环链表 -- 增加了是否成环功能
 * @author fengluo
 *
 * @param <E>
 */
public class SCLList<E> extends AbstractList<E> {
	
	public Node<E> first;
	
	public static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			E nextElement = next == null ? null : next.element;
			s.append(element).append("_").append(nextElement);
			return s.toString();
		}
		
		@Override
		public void finalize() {
			System.out.println("finalize = " + this.element);
		}
		

	}

	@Override
	public void clear() {
		first = null;
		size = 0;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		if (index == 0) {
			if (size == 0) {
				Node<E> next = first;
				Node<E> prev = null;
				Node<E> node = new Node<>(element, next);
				prev = node;
				first = node;
				prev.next = node;
			} else {
				Node<E> next = first;
				Node<E> prev = node(size - 1);
				Node<E> node = new Node<>(element, next);
				first = node;
				prev.next = node;
			}
		} else if (index == size) {
			Node<E> prev = node(size - 1);
			Node<E> next = first;
			Node<E> node = new Node<>(element, next);
			prev.next = node;
			
		} else {
			Node<E> prev = node(index - 1);
			Node<E> next = prev.next;
			Node<E> node = new Node<>(element, next);
			prev.next = node;
		}
		
		size++;
		
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		
		Node<E> old;
		if (index == 0) {
			if (size == 1) {
				old = first;
				first = null;
			} else {
				old = first;
				Node<E> prev = node(size - 1);
				Node<E> next = first.next;
				first = next;
				prev.next = next;
			}
		} else {
			Node<E> prev = node(index - 1);
			old = prev.next;
			Node<E> next = old.next;
			prev.next = next;
		}
		
		size--;
		return old.element;
		
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public int indexOf(E element) {
		
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private Node<E> node(int index) {
		rangeCheck(index); 
		
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	/*
	 * size = size, [node, node, ...]
	 */
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size = ").append(size).append(", first=").append(first).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) { string.append(", "); }
			string.append(node);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
	
	
	/**
	 * 是否成环
	 * @param list
	 * @return
	 */
	private static boolean isCircle(SCLList<Integer> list) {
		
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
