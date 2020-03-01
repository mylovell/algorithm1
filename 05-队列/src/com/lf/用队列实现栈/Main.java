package com.lf.用队列实现栈;


public class Main {

	public static void main(String[] args) {
		
		testStack();
	}
	
	private static void testStack() {
		
//		StackByDeque<Integer> stack = new StackByDeque<>();
		StackByCircleDeque<Integer> stack = new StackByCircleDeque<>();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.push(44);
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}


	}

}
