package com.lambda;

/**
 * 不带参数的lambda表达式
 * 
 * @author pengwang
 *
 */
public class LambdaDemo {
	public static void main(String[] args) {
		MyNumber myNumber;
		myNumber = () -> 123.45;
		System.out.println("A fixed value：" + myNumber.getValue());
		myNumber = () -> Math.random() * 100;
		System.out.println("A random value------" + myNumber.getValue());
		System.out.println("Another random value------" + myNumber.getValue());
	}
}

interface MyNumber {
	double getValue();
}