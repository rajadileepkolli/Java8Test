package com.lambda;

import java.util.function.Function;

/**
 * use the function built-in functional interface
 * 
 * @author wangpeng
 * @date 3 Mar 2016 10:35:25
 */
public class UseFunctionInterfaceDemo {
	public static void main(String[] args) {
		Function<Integer, Integer> factorial = n -> {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result = i * result;
			}
			return result;
		};

		System.out.println("The factoral of 3 is " + factorial.apply(3));
		System.out.println("The factoral of 5 is " + factorial.apply(5));
	}
}
