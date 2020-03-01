package com.lf.stack;

import com.lf.list.SLList;

/**
 * 用双向链表实现(随意的链表都行)
 * @author FengLuo
 *
 * @param <E>
 */
public class Stack2<E> implements InterfaceStack<E> {

	private SLList<E> list = new SLList<>();
	
	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E element) {
		list.add(element);
	}

	@Override
	public E pop() {
		return list.remove(list.size() - 1);
	}

	@Override
	public E top() {
		return list.get(list.size() - 1);
	}

}
