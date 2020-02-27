package com.lf.stack.练习;

import com.lf.stack.Stack;

public class 有效的括号 {
	
	public static void main(String[] args) {
	
		Asserts.test(isValid("()") == true);
		Asserts.test(isValid("([)]") == false);
		Asserts.test(isValid("()[]{}") == true);
		Asserts.test(isValid("{[]}") == true);
		Asserts.test(isValid("(]") == false);
		
		System.out.println("SUCCESS👌🏻👌🏻");
	}
	
	
	
	public static boolean isValid(String s) {
		
		String[] array = s.split("");
		Stack<String> stack = new Stack<>();
		
		for (String string : array) {
			if (string.matches("[(\\[{]")) {
				stack.push(string);
			} else if (string.matches("[)\\]}]")) {
				if (stack.isEmpty()) return false;
				if (!(left(string).equals(stack.pop()))) { return false; }
			}
		}
		return stack.isEmpty();
	}
	
	private static String left(String s) {
		if (s.equals(")")) {
			return "(";
		} else if (s.equals("]")) {
			return "[";
		} else if (s.equals("}")) {
			return "{";
		} else {
			return null;
		}
	}

}
