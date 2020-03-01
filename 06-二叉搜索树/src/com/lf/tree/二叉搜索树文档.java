
Binary Search Tree 二叉搜索树接口设计：

public int size();
public boolean isEmpty();
public void clear();

public void add(E element);
public void remove(E element);
public boolean contains(E element);



内部设计

private int size;
private Node<E> root;
private Comparator<E> comparator;

// 内部类
private static class Node<E> {
	public boolean hasTwoChildren();
	E element;
	Node<E> parent;
	Node<E> left;
	Node<E> right;
	public boolean isLeaf() {}
	public Node(E element, Node<E> parent) {}
	public boolean hasTwoChildren() {}
}
public static abstract class Visitor<E> {
	boolean stop;
	public abstract boolean visit(E element);
}
private int compare(E e1, E e2);
private Node<E> node(E element);
private void remove(Node<E> node);

private Node<E> predecessor(Node<E> node) {}
private Node<E> successor(Node<E> node) {}

public void preorder(Visitor<E> visitor) {}
private void preorder(Node<E> node, Visitor<E> visitor) {}

public void inorder(Visitor<E> visitor) {}
private void inorder(Node<E> node, Visitor<E> visitor) {}

public void postorder(Visitor<E> visitor) {}
private void postorder(Node<E> node, Visitor<E> visitor) {}

public void levelOrder(Visitor<E> visitor) {}

public boolean isComplete() {}

public int height() {}
private int height(Node<E> node) {}

public String toString() {}
private void toString(Node<E> node, StringBuilder sb, String prefix) {}

private void elementNotNullCheck(E element) {}


1. 构造方法(比较器)；
2. node操作方法：删、查；
3. 遍历树的方法：前序、中序、后序、层序；
4. 树的描述：高方法、是否完全二叉树、打印树；
5. 节点描述：前节点、后节点；

6. 元素非空判断方法；




