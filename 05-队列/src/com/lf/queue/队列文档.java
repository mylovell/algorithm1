

描述：一头进另一头出，链表尾进头出；先进先出，FIFO。
本质上是操作头和尾，所以用双向链表。


一、队列（单端队列）【一头进，另一头出】，接口设计：

public void clear();
public int size();
public boolean isEmpty();

public void enQueue(E element);//队头入队
public E deQueue();			//队尾出队
public E front();				//获取队头元素



二、双端队列【两端都能进出】，接口设计：

public void clear();
public int size();
public boolean isEmpty();

public void enQueueFront(E element);	//队头入队
public void enQueueRear(E element);	//队尾入队
public E deQueueFront();	//队头出队
public E deQueueRear();		//队尾出队
public E front();			//获取队头元素
public E rear();			//获取尾头元素






