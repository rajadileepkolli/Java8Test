package com.lambda;

/**
 * Demonstrate a constructor reference
 * 
 * @author wangpeng
 * @date 3 Mar 2016 09:53:25
 */
public class ConstructorRefDemo {

	public static void main(String[] args) {
		MyFunc4 myClassCon = MyClass2::new;
		MyClass2 mc = myClassCon.func(100);
		System.out.println("val in mc is " + mc.getVal());
	}

}

interface MyFunc4 {
	MyClass2 func(int n);
}

class MyClass2 {
	private int val;

	/**
	 * This constructor taken an argument
	 */
	public MyClass2(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}

	/**
	 * This is the default constructor
	 */
	public MyClass2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the val
	 */
	public int getVal() {
		return val;
	}

	/**
	 * @param val
	 *            the val to set
	 */
	public void setVal(int val) {
		this.val = val;
	}

}
