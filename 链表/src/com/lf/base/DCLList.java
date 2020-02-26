package com.lf.base;

/**
 * 双向循环链表
 * @author fengluo
 *
 * @param <E>
 */
public class DCLList<E> extends AbstractList<E> {
	

	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E> {
		E element;
		Node<E> prev;
		Node<E> next;
		private Node(E element, Node<E> prev, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		@Override
		public String toString() { // null_15_16 、 prev.element_element_next.element
			StringBuilder s = new StringBuilder();
			E prevElement = prev == null ? null : prev.element;
			E nextElement = next == null ? null : next.element;
			s.append(prevElement).append("_").append(element).append("_").append(nextElement);
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
		last = null;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		// 考虑2个边界：最前面、最后面，因为涉及到变量 first、last 的值的变化
		if (index == 0) {
			if (size == 0) {
				Node<E> prev = last; // null
				Node<E> next = first; // null
				Node<E> node = new Node<>(element, prev, next);
				node.prev = node;
				node.next = node;
				first = node;
				last = node;
				
//				Node<E> node = new Node<>(element, null, null);
//				first = last = node.prev = node.next = node;
				
			} else {
				Node<E> prev = last;
				Node<E> next = first;
				Node<E> node = new Node<>(element, prev, next);
				prev.next = node;
				next.prev = node;
				first = node;
				
			}
		} else if (index == size) {
			
			Node<E> prev = last;
			Node<E> next = first;
			Node<E> node = new Node<>(element, prev, next);
			prev.next = node;
			next.prev = node;
			last = node;
			
		} else {
			Node<E> prev = node(index - 1);
			Node<E> next = prev.next;
			Node<E> node = new Node<>(element, prev, next);
			prev.next = node;
			next.prev = node;
		}
		
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if (index == 0) {
			if (size == 1) {
				first = null;
				last = null;
			} else {
				prev.next = next;
				next.prev = prev;
				first = next;
			}
		} else if (index == (size - 1)) {
			prev.next = next;
			next.prev = prev;
			last = prev;
		} else {
			prev.next = next;
			next.prev = prev;
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
		rangeCheck(index);
		return node(index).element;
	}

	@Override
	public int indexOf(E element) {
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (null == node.element) { return i; }
				node = node.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) { return i; }
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private Node<E> node(int index) {
		if (index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = (size - 1); i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}

	/*
	 *  size = size, [node, node, ....]
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("size = ").append(size).append(", [");
		Node<E> node = first;
		
		for (int i = 0; i < size; i++) {
			if (i != 0) { s.append(", "); }
			s.append(node);
			node = node.next;
		}
		s.append("]");
		return s.toString();
	}
	
}
