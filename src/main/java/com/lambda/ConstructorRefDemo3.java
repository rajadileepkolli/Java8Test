package com.lambda;

/**
 * Implement a simple class factory using a constructor reference
 * 
 * @author wangpeng
 * @date 3 Mar 2016 10:12:08
 */
public class ConstructorRefDemo3 {
	public static void main(String[] args) {
		MyFunc6<MyClass4<Double>, Double> myClassCons = MyClass4<Double>::new;
		MyClass4<Double> mc = myClassFactory(myClassCons, 100.1);
		System.out.println("val in mc is " + mc.getVal());

		MyFunc6<MyClass5, String> myClassCons2 = MyClass5::new;
		MyClass5 mc2 = myClassFactory(myClassCons2, "lambda");
		System.out.println("str in mc2 is " + mc2.getStr());
	}

	static <R, T> R myClassFactory(MyFunc6<R, T> cons, T v) {
		return cons.func(v);
	}
}

interface MyFunc6<R, T> {
	R func(T n);
}

class MyClass4<T> {

	private T val;

	public MyClass4(T v) {
		// TODO Auto-generated constructor stub
		this.val = v;
	}

	MyClass4() {
		val = null;
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

}

class MyClass5 {
	String str;

	public MyClass5(String s) {
		// TODO Auto-generated constructor stub
		this.str = s;
	}

	public MyClass5() {
		// TODO Auto-generated constructor stub
		this.str = "";
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}