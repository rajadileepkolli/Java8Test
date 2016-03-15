package com.lambda;

/**
 * Use a generic functional interface with lambda expression
 * 
 * @author pengwang
 *
 */
public class GenericFunctionalInterfaceDemo {
	public static void main(String[] args) {
		// Use a String-based version of SomeFunc
		SomeFunc<String> reverse = str -> {
			String result = "";
			int i;
			for (i = str.length() - 1; i >= 0; i--) {
				result += str.charAt(i);
			}
			return result;
		};
		System.out.println("lambda reversed is " + reverse.func("lambda"));
		System.out.println("Expression reversed is " + reverse.func("Expression"));

		// Now,use an Integer-based version of SomeFunc
		SomeFunc<Integer> fatorial = n -> {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result = i * result;
			}
			return result;
		};

		System.out.println("The factorial of 3 is " + fatorial.func(3));
		System.out.println("The factorial of 5 is " + fatorial.func(5));
	}
}

interface SomeFunc<T> {
	T func(T t);
}
