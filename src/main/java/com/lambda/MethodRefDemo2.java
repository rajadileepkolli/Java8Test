package com.lambda;

/**
 * Demonstrate a method reference to an instance method
 * 
 * @author pengwang
 *
 */
public class MethodRefDemo2 {
	public static void main(String[] args) {
		String inStr = "lambda add power to java";
		String outStr = "";
		
		//Create a MyStringOps2 object
		MyStringOps2 myStringOps2 = new MyStringOps2();
		//Now,a method reference to the instance method strReverse
		outStr = stringOp(myStringOps2::strReverse, inStr);
		System.out.println("Original string：" + inStr);
		System.out.println("String reversed：" + outStr);
	}
	
	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}
}

class MyStringOps2 {
	// This class defines a instance method called strReversed()
	String strReverse(String str) {
		String result = "";
		int i;

		for (i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}

		return result;
	}
}
