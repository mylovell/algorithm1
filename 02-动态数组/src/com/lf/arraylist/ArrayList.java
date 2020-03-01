package com.lf.arraylist;

/**
 * 动态数组（4个属性和10个接口）：
 * 1、可以自动扩容
 * 
 * 
 * @author fengluo
 *
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class ArrayList<E> {
	
	private int size;
	private E[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayList(int capacity) {
		capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY :capacity;
		elements = (E[])new Object[capacity];
	}
	

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(E element) {
		add(size, element);
	}
	public void add(int index, E element) {
		// 判断 index 是否越界
		rangeCheckForAdd(index);
		// 确保容量足够再容下一个
		ensureCapacity(size + 1);
		
		// 空个位置出来
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		
		elements[index] = element;
		size++;
	}
	public E remove(int index) {
		rangeCheck(index);
		E old = elements[index];
		
		// 挪元素，覆盖 index 位置
		for (int i = index; i < size; i++) {
			elements[i] = elements[i+1];
		}
		
		// 最后那个元素置为 null
		elements[--size] = null;
		
		return old;
	}
	
	// 这里有点问题：如果 index 位置没元素，会报错(所以使用者在调用该方法前要判断index位置有元素)
	public E set(int index, E element) {
		rangeCheck(index);
		
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	public int indexOf(E element) {
		
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (null == elements[i]) return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(element)) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < elements.length; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		};
	}
	
	/**
	 * 确保 index 的位置是存有元素的
	 * @param index
	 */
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		};
	}
	
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
	}
	
	@Override
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		
		for (int i = 0; i < size; i++) {
			if (i != 0) { string.append(", "); }
//			string.append("\n");
			string.append(elements[i]);
		}
		
//		string.append("\n");
		string.append("]");
		
		return string.toString();
	}

}
