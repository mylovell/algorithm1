package com.lf.base;

/**
 * 动态数组 DAList：dynamic array list 。
 * @author fengluo
 *
 * @param <E>
 */
public class DAList<E> extends AbstractList<E> {
	
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public DAList() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public DAList(int capacity) {
		capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY :capacity;
		elements = (E[])new Object[capacity];
	}
	

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
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

	@Override
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

	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		
		E old = elements[index];
		elements[index] = element;
		return old;
	}

	@Override
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	@Override
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
	
	@SuppressWarnings("unchecked")
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
	
	@Override
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		
		for (int i = 0; i < size; i++) {
			if (i != 0) { string.append(", "); }
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
	
}
