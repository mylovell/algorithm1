package com.lf.linkedlist;

public class SinleCircleLinkedList<E> {
	
	private int size;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	private Node<E> first;
	private static class Node<E> {
		E element;
		Node<E> next;
		private Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [element=" + element + ", next=" + next.element + "]";
		}
		
		@Override
		protected void finalize() throws Throwable {
			System.out.println("finalize = " + this.element);
			super.finalize();
		}
	}
	
	
	public void clear() {
//		first.next = null;
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
				Node<E> node = new Node<>(element, first);
				
				
			} else {
				
			}
		} else if (index == size) {
			
		} else {
			
		}
		
	} //考虑2个边界：最前面和最后面，因为设计到变量 first、last 的值的变化
	
	public E remove(int index) {}// 如上，考虑最前面和最后面的情况
	
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
		string.append("size = ").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) { string.append(", "); }
			string.append(node);
		}
		string.append("]");
		return string.toString();
	}
	
}
