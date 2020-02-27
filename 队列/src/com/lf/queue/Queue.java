package com.lf.queue;

import com.lf.list.DLList;

/**
 * 队列（单端队列：一端进，一端出；链表尾巴进，头部出）
 */
public class Queue<E> {
	
	private  DLList<E> list = new DLList<E>();
	
	public void clear() {
		list.clear();
	}
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enQueue(E element) {
		list.add(element);
	}
	public E deQueue() {
		return list.remove(0);
	}
	public E front() {
		return list.get(0);
	}
	


}
