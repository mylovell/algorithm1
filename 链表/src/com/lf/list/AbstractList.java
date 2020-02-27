package com.lf.list;


/*
 * 抽象类，用于抽取公有方法实现、公有属性。
 */
public abstract class AbstractList<E> implements List<E> {
	
	/*
	 * 元素数量
	 * 公有属性，每种线性数据结构都会有，故放在抽象类中
	 */
	protected int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(E element) {
		add(size, element);
	}
	
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index= " + index + ", Size = " + size);
	}
	
	
	
	
	/*
	 * 每种链式结构都有点不一样，单链和单循环链一样处理size和first就行了，双链和双循环链处理size、first、last，数组处理 size、每个element。
	 * 链表：要处理 size、first、last；
	 * 数组：要处理 size、每个element。
	 */
//	void clear();
	
//	void add(int index, E element);	// 每种链式结构都不一样，链表：要维护结构的属性及node的属性，数组：需要移动元素
//	E remove(int index);			// 每种链式结构都不一样，链表：要维护结构的属性及node的属性，数组：需要移动元素
//	E set(int index, E element);// 链表共用，动态数组不能
//	E get(int index);			// 链表共用，动态数组不能
//	int indexOf(E element);		// 链表共用，动态数组不能
	
	
}
