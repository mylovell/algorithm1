package com.lf.arraylist;

动态数组ArrayList 的设计：接口设计。


* 接口
	* 10个public（主要功能：外界可以使用的服务）
	* 2个contruct
	* 5个private辅助(容量确保、越界处理、打印)

* 属性（内存占用）
	* 4个private
	


// 属性4个
private E[] elements;
private int size;
private static final int DEFAULT_CAPACITY = 10;
private static final int ELEMENT_NOT_FOUND = -1;

// 2个contruct
public ArrayList();
public ArrayList(int capacity);
	
// 10个public（外界可以使用的服务）
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

// 5个private辅助
private void rangeCheckForAdd(int index);
private void rangeCheck(int index);
private void outOfBounds(int index);
private void ensureCapacity(int capacity);
public String toString();

