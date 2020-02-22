package com.lf.base;

public interface List<E> {
	
	void clear();
	int size();
	boolean isEmpty();
	
	void add(E element);
	void add(int index, E element);
	E remove(int index);
	E set(int index, E element);
	E get(int index);
	int indexOf(E element);
	boolean contains(E element);
	
}
