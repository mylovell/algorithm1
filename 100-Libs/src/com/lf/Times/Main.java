package com.lf.Times;

public class Main {

	public static void main(String[] args) {
		
		Times.test("1号", new Times.Task() {
			@Override
			public void execute() {
				String string = "1";
				for (int i = 0; i < 30_000; i++) {
					string = string + i;
				}
			}
		});
		
//		Times.test("1号", () -> {
//			String string = "1";
//			for (int i = 0; i < 30_000; i++) {
//				string = string + i;
//			}
//		});
		

	}

}
