package com.lf.stack;

public interface InterfaceStack<E> {
	
	void clear();
	int size();
	boolean isEmpty();
	
	void push(E element);
	E pop();
	E top();

}
