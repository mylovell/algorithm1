package com.lf;

public class Main {
	
	* 接口
		* 10个public
		* 2个contruct
		* 4个private辅助
	
	* 属性
		* 4个private
		
		
	
	
	// 属性4个
	private E[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	// 2个contruct
	public ArrayList();
	public ArrayList(int capacity);
		
	// 10个public
	public void clear();
	public int size();
	public boolean isEmpty();
	
	public void add(E element);
	public void add(int index, E element);
	public E remove(int index);
	public E set(int index, E element);
	public E get(int index);
	public int indexOf(E element);
	public boolean contains(E element);
	
	// 4个private辅助
	private void rangeCheckForAdd(int index);
	private void ensureCapacity(int capacity);
	private void rangeCheck(int index);
	private void outOfBounds(int index);
	
	
	
}
