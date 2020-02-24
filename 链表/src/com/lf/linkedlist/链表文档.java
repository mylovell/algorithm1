import com.lf.linkedlist.SinleCircleLinkedList.Node;

单向链表 SingleLinkedList
双向链表 DoubleLinkedList
单向循环链表 SingleCircleLinkedList
双向循环链表 DoubleCircleLinkedList


数组：通过 下标序号 寻找元素
单向：通过 next 寻找元素
双向：通过 next、pre 寻找元素

方法：
比数组少了 ensureCapacity() 方法；

一、SingleLinkedList 内部设计：

public class SingleLinkedList<E> {

	private Node<E> first;
	private int size;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		// construct method
		// toString method
	}
	
	
	//10个public
	public void clear() {}
	public int size() {}
	public boolean isEmpty() {}

	public void add(E element) {}
	public void add(int index, E element) {}//考虑2个边界：最前面和最后面，因为设计到变量 first、last 的值的变化
	public E remove(int index) {}// 如上，考虑最前面和最后面的情况
	public E set(int index, E element) {}
	public E get(int index) {}
	public int indexOf(E element) {}
	public boolean contains(E element) {}

	// 5个private辅助
	private void rangeCheckForAdd(int index) {}
	private void rangeCheck(int index) {}
	private void outOfBounds(int index) {}
	private Node<E> node(int index) {}
	public String toString() {}
	
}



二、DoubleLinkedList 内部设计：

可以往前后两个方向遍历。

和单向链表比较：
属性：多 last 属性；内部类 Node 多 prev 属性；
方法：add、remove、node这三个方法，相比于单向链表要处理 last 和 prev 属性的问题。


public class DoubleLinkedList<E> {
	
	private Node<E> first;
	private Node<E> last; // 比单向链表多出来的
	
	private int size;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	private static class Node<E> {
		E element;
		Node<E> prev; // 比单向链表多出来的
		Node<E> next;
		// construct method
		// toString method
	}
	
	// 方法接口同上
	
}

三、SinleCircleLinkedList 内部设计：

和单向链表比较：
相同点：属性、接口；
不同点：只是 add 和 remove 方法，会涉及到最后那个 node 的 next 属性。


疑问：
1、单向循环链表，add方法这里：Node<E> node = new Node<>(element, first);，first为null，并不能表示指向自己啊，即使后面又赋值了。
———— 解答：创建node对象后，后面还可以再赋值 next 属性。

public class SinleCircleLinkedList<E> {
	
	// 属性、接口同单向链表
	
	
	
}






