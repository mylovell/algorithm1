package com.lf.用队列实现栈;

import com.lf.queue.Deque;

/**
 * 要用双端队列，单端不行，因为栈只操作一端。
 */
public class StackByDeque<E> {
	
	private Deque<E> deque = new Deque<>();
	

	public void clear() {
		deque.clear();
	}
	public int size() {
		return deque.size();
	}
	public boolean isEmpty() {
		return deque.isEmpty();
	}
	
	public void push(E element) {
		deque.enQueueFront(element);
	}
	public E pop() {
		return deque.deQueueFront();
	}
	public E top() {
		return deque.front();
	}
	

}
