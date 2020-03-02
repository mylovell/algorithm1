package com.lf.tree;

import java.util.Comparator;

public class BinarySearchTree<E> {
	
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;
	
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		public boolean isLeaf() {
			return left == null && right == null;
		}
		public boolean hasTwoChildren() {
			return left != null && right != null;
		}
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		
		// 树中无节点
		if (root == null) {
			Node<E> node = new Node<>(element, null);
			root = node;
			size++;
		}
		
		// 有节点，找到父节点（通过大小比较）
		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		do {
			parent = node;
			cmp = compare(element, node.element);
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else {
				node.element = element;
				return;
			}
		} while (node != null) ;
		
		// 添加到父节点上
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0 ) {
			parent.right = newNode;
		} else if (cmp < 0 ) {
			parent.left = newNode;
		}
		
		size++;
		
	}
	
	public void remove(E element) {
		remove(node(element));
	}
	
	private void remove(Node<E> node) {
		
		// 度为2，后继节点上位
		if (node.hasTwoChildren()) {
			Node<E> s = successor(node);
			node.element = s.element;
		}
		
		// 度为1
		
		
		// 度为0
		
		
		
	}
	
	public boolean contains(E element) {
		
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null !");
		};
	}
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	// 循环比较，大走右，小走左
	private Node<E> node(E element) { 
		
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp == 0) {
				return node;
			} else if (cmp > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		
		return null;
	}
	
	/* 找比node小一点的那个节点：左边的子节点，或放node往右边走的父节点：
	 * 1、node的有左子节点：在左树中找到最大的那个；
	 * 2、node的父节点 && 在父节点的右
	 * 3、node的父节点 && 在父节点的左，继续往上，直到在父节点的右
	 */
	private Node<E> predecessor(Node<E> node) {
		if (node == null) return null;
		
		// 有左子节点，左树中找到最大的那个
		Node<E> p = node.left;
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		
		// 只有父节点。如果是左节点，就往上找，直到没有左节点（消掉左节点，剩下右节点）
		while (node.parent != null && node.parent.left == node) {
			node = node.parent;
		}
		
		// 到了这一步，1、node是右节点；2、到最后一个还是左节点，此时 node.parent = null 。
		return node.parent;
	}
	
	/* 找比node大一点的那个节点：右边的子节点，或放node往左边走的父节点：
	 * 1、node的右子节点；
	 * 2、node的父节点 && 在父节点的左
	 * 3、node的父节点 && 在父节点的右，继续往上，直到在父节点的左
	 */
	private Node<E> successor(Node<E> node) {
		if (node == null) return null;
		
		// 有右子节点
		Node<E> s = node.right;
		if (s != null) {
			while (s.left != null) {
				s = s.left;
			}
			return s;
		}
		
		// 只有父节点，如果是右子节点，就一直往上找，直到没有右节点（消掉右节点，剩下左节点）
		while (node.parent != null && node.parent.right == node) {
			node = node.parent;
		}
		
		// 到了这一步，1、node是左节点；2、到最后一个还是右节点，此时 node.parent = null 。
		return node.parent;
	}
	
}
