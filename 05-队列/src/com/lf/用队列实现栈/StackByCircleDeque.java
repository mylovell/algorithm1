package com.lf.用队列实现栈;

import com.lf.circleQueue.CircleDeque;

public class StackByCircleDeque<E> {

	private CircleDeque<E> circleDeque = new CircleDeque<>();
	

	public void clear() {
		circleDeque.clear();
	}
	public int size() {
		return circleDeque.size();
	}
	public boolean isEmpty() {
		return circleDeque.isEmpty();
	}
	
	public void push(E element) {
		circleDeque.enQueueFront(element);
	}
	public E pop() {
		return circleDeque.deQueueFront();
	}
	public E top() {
		return circleDeque.front();
	}
}
