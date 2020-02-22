package com.lf.base;

public abstract class AbstractList<E> implements List<E> {
	
	protected int size;
	
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	
	
}
