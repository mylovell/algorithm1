package com.lf.list;

public interface List<E> {
	
	// 常量
	static final int ELEMENT_NOT_FOUND = -1;
	
	// 抽象方法（外界常用的功能）
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
