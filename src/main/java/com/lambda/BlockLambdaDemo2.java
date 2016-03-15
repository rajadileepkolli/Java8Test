package com.lambda;

/**
 * A block lambda that reservers the characters in a string
 * 
 * @author pengwang
 *
 */
public class BlockLambdaDemo2 {
	public static void main(String[] args) {
		StringFunc reverse = str -> {
			String result = "";
			int i;

			for (i = str.length() - 1; i >= 0; i--) {
				result += str.charAt(i);
			}

			return result;
		};

		System.out.println("lambda reversed is " + reverse.func("lambda"));
		System.out.println("Expression reversed is " + reverse.func("Expression"));
	}
}

interface StringFunc {
	String func(String n);
}