package com.lf.Asserts;

public class Asserts {

	public static void test(boolean value) {
		try {
			if (!value) throw new Exception();
		} catch (Exception e) {
			System.err.println("测试未通过: " + new RuntimeException().getStackTrace()[1]);
		}
	}
}
