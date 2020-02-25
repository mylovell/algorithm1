package com.lf.base;

/*
 * 抽象类，用于抽取公有方法实现、公有属性。
 */
public abstract class AbstractList<E> implements List<E> {
	
	/*
	 * 元素数量
	 * 公有属性，每种线性数据结构都会有，故放在抽象类中
	 */
	protected int size;
	
	
//	void clear();
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(E element) {
		add(size, element);
	}
//	void add(int index, E element);
//	E remove(int index);
//	E set(int index, E element);// 链表共用，动态数组不能
//	E get(int index);// 链表共用，动态数组不能
//	int indexOf(E element);// 链表共用，动态数组不能
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	
}
