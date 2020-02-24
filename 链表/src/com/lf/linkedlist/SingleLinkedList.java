package com.lf.linkedlist;

public class SingleLinkedList<E> {
	
	private Node<E> first;
	
	private int size;
	public static final int ELEMENT_NOT_FOUND = -1;

	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [element=" + element + ", next=" + next.element + "]";
		}
	}
	
	
	
	public void clear() {
		size = 0;
		first = null;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(E element) {
		add(size, element);
	}
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
	
	public E set(int index, E element) {
//		rangeCheck(index);
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}
	
	public E get(int index) {
		return node(index).element;
	}
	
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
	
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	private Node<E> node(int index) {
		rangeCheck(index);
		
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		};
	}
	

	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		};
	}
	
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
	}
	
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(node.element);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
	
}
