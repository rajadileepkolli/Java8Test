package com.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * 
 * Use an iterator with a stream
 * 
 * @author wangpeng
 * @date 15 Mar 2016 18:14:51
 */
public class StreamDemo7 {
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Alpha");
		myList.add("Beta");
		myList.add("Gamma");
		myList.add("Delta");
		myList.add("Phi");
		myList.add("Omega");

		// Obatin a Stream to the array list
		Stream<String> myStream = myList.stream();
		// Obatin an iterator to the stream
		Iterator<String> itr = myStream.iterator();
		while (itr.hasNext()) {
			String string = (String) itr.next();
			System.out.println(string);
		}
	}

}
