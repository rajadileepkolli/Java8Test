package com.lambda;

/**
 * Demonstrate a method reference for a static method
 * 
 * @author pengwang
 *
 */

public class MethodRefDemo {

	public static void main(String[] args) {
		String inStr = "lambda add power to java";
		String outStr = "";
		// Here, a method reference to strReverse is passed to stringOp()
		outStr = stringOp(MyStringOps::strReverse, inStr);
		System.out.println("Original string：" + inStr);
		System.out.println("String reversed：" + outStr);
	}

	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}
}

class MyStringOps {

	// This class defines a static method called strReversed()
	static String strReverse(String str) {
		String result = "";
		int i;

		for (i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}

		return result;
	}
}
