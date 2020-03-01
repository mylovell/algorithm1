
用数组实现队列，并且是优化过的数组

三、循环队列（Circle Queue），用动态数组实现，但不用现成的封装，优化到O(1)复杂度。
private int front; // 用于优化，指向数组队头，避免数组index=0位置删除元素时，所有元素需要往前移动。
private int size;
private E[] elements;
private static final int DEFAULT_CAPACITY = 10;

public CircleQueue() {
	elements = (E[]) new Object[DEFAULT_CAPACITY];
}


四、循环双端队列

