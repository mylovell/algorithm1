package com.lf.base;

/**
 * 单向链表
 * @author fengluo
 *
 * @param <E>
 */
public class SLList<E> extends AbstractList<E> {
	
	private Node<E> first;
	
	private static class Node<E> {
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
		size = 0;
		first = null;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		// 考虑1个边界：添加在最前面，涉及到变量 first 的值的变化
		if (index == 0) {
			Node<E> next = first;
			Node<E> current = new Node<>(element, next);
			first = current;
		} else {
			Node<E> pre = node(index - 1);
			Node<E> current = new Node<>(element, pre.next);
			pre.next = current;
		}
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		
		Node<E> node = first;
		if (index == 0) {
			first = first.next;
		} else {
			Node<E> pre = node(index - 1);
			node = pre.next;
			pre.next = node.next;
		}
		size--;
		return node.element;
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
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", first=").append(first).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) { string.append(", "); }
			string.append(node);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
	
}
