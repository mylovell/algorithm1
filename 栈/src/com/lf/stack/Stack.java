package com.lf.stack;

import com.lf.list.DAList;

/**
 * 用动态数组实现
 * @author FengLuo
 *
 * @param <E>
 */
public class Stack<E> implements InterfaceStack<E> {
	
	private DAList<E> array = new DAList<>();

	
	@Override
	public void clear() {
		array.clear();
	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public void push(E element) {
		array.add(element);
	}

	@Override
	public E pop() {
		return array.remove(array.size() - 1);
	}

	@Override
	public E top() {
		return array.get(array.size() - 1);
	}
	
	
	
}
