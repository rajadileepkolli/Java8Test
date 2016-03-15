package com.lambda;

/**
 * Demonstrate a constructor reference with a generic class
 * 
 * @author wangpeng
 * @date 3 Mar 2016 10:04:58
 */
public class ConstructorRefDemo2 {
	public static void main(String[] args) {
		MyFunc5<Integer> myClassCons = MyClass3<Integer>::new;
		MyClass3<Integer> mc = myClassCons.func(100);
		System.out.println("val in mc is " + mc.getVal());
	}
}

/**
 * MyFunc is now a generic functional interface
 * 
 * @author wangpeng
 * @date 3 Mar 2016 10:08:29
 */
interface MyFunc5<T> {
	MyClass3<T> func(T n);
}

class MyClass3<T> {
	private T val;

	public MyClass3(T t) {
		// TODO Auto-generated constructor stub
		this.val = t;
	}

	public MyClass3() {
		// TODO Auto-generated constructor stub
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

}