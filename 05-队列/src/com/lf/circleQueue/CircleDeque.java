package com.lf.circleQueue;

@SuppressWarnings("unchecked")
public class CircleDeque<E> {
	
	private int front;
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public CircleDeque() {
		elements = (E[])new Object[DEFAULT_CAPACITY];
	}
	

	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[index(i)] = null;
		}
		front = 0;
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	

	public void enQueueFront(E element) {
		ensureCapacity(size + 1);
		elements[index(elements.length - 1)] = element;
		size ++;
		front = index(elements.length - 1);
	}
	public void enQueueRear(E element) {
		ensureCapacity(size + 1);
		elements[index(size)] = element;
		size ++;
	}
	public E deQueueFront() {
		E element = elements[front];
		elements[front] = null;
		front = index(1);
		size --;
		return element;
	}
	public E deQueueRear() {
		
		int rearIndex = index(size - 1);
		E element = elements[rearIndex];
		elements[rearIndex] = null;
		size --;
		return element;
	}
	public E front() {
		return elements[front];
	}
	public E rear() {
		return elements[index(size - 1)];
	}
	


	/** 以当前front的位置，再往前走 index 个位置。
	 * 想要操作的位置，转化成element中真实的位置。
	 * @param index 想要操作的位置
	 * @return 返回 element 中真实的位置
	 */
	private int index(int index) {
		index += front;// 以front为起点，得到的位置
		return index - (index >= elements.length ? elements.length : 0);
	}
	
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) { return; }
		
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		
		// 重置 front
		front = 0;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capcacity=").append(elements.length)
		.append(" size=").append(size)
		.append(" front=").append(front)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
	
}
