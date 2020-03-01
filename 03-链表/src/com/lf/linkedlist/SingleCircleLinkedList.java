package com.lf.linkedlist;

/*
 * 单向循环链表
 */
public class SingleCircleLinkedList<E> {
	
	private int size;
	private Node<E> first;
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
	
	
	public void clear() {
		//first.next = null;
		first = null;
		size = 0;
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
		
	} //考虑2个边界：最前面和最后面，因为设计到变量 first 的值的变化
	
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
		
	}// 如上，考虑最前面和最后面的情况
	
	public E set(int index, E element) {
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

	// 5个private辅助
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
		throw new IndexOutOfBoundsException("Index = " + index + "size = " + size);
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
	
}
