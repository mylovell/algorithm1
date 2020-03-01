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
	
	
	
}
