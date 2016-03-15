package com.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Use a method reference to help find the maxinum value in a collection
 * 
 * @author pengwang
 *
 */
public class UseMethodRef {

	/**
	 * A compare() compatible with the one defined by Comparator<T>
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int compareMC(MyClass a, MyClass b) {
		return a.getVal() - b.getVal();
	}

	public static void main(String[] args) {
		List<MyClass> al = new ArrayList<>();
		al.add(new MyClass(1));
		al.add(new MyClass(2));
		al.add(new MyClass(4));
		al.add(new MyClass(9));
		al.add(new MyClass(3));
		al.add(new MyClass(7));

		// Find the maximum value in al using the compareMC() method
		MyClass maxValObj = Collections.max(al, UseMethodRef::compareMC);
		System.out.println("Maximum value is：" + maxValObj.getVal());
	}
}

class MyClass {
	private int val;

	public MyClass(int v) {
		// TODO Auto-generated constructor stub
		this.val = v;
	}

	int getVal() {
		return val;
	}
}
