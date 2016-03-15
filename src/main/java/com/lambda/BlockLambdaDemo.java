package com.lambda;

/**
 * a block lambda that computes the factorial of an int value
 * 
 * @author pengwang
 *
 */
public class BlockLambdaDemo {
	public static void main(String[] args) {
		NumericFunc numericFunc = n -> {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result = i * result;
			}
			return result;
		};
		System.out.println("The factorial of 3 is " + numericFunc.func(3));
		System.out.println("The factorial of 5 is " + numericFunc.func(5));
	}
}

interface NumericFunc {
	int func(int n);
}