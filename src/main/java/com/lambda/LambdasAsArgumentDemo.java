package com.lambda;

/**
 * Use lambda expressions as an argument to a method
 * 
 * @author pengwang
 *
 */
public class LambdasAsArgumentDemo {
	
	public static void main(String[] args) {
		String inStr = "lambda add power to java";
		String outStr = "";
		System.out.println("here is input String" + inStr);

		// Here,a simple expression lambda that uppercases a string
		outStr = stringOp((str) -> str.toUpperCase(), inStr);
		System.out.println("The String in upperCase：" + outStr);

		// this passed a block lambda that removes spaces
		outStr = stringOp((str) -> {
			String result = "";
			int i;
			for (i = str.length() - 1; i >= 0; i--) {
				result += str.charAt(i);
			}
			return result;
		}, inStr);
		System.out.println("The string with spaces removed：" + outStr);

		// instance of StringFunc
		StringFunc reverse = str -> {
			String result = "";
			int i;
			for (i = str.length() - 1; i >= 0; i--) {
				result += str.charAt(i);
			}
			return result;
		};
		outStr = stringOp(reverse, inStr);
		System.out.println("The String reversed：" + outStr);
	}

	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}

}
