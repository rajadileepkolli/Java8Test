package com.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
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
		iteratorStream();
		spliteratorStream();
		trySplitWithStream();
	}

	public static void trySplitWithStream() {
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Alpha");
		myList.add("Beta");
		myList.add("Gamma");
		myList.add("Delta");
		myList.add("Phi");
		myList.add("Omega");

		// Obatin a Stream to the array list
		Stream<String> myStream = myList.stream();
		// Obtain a Spliterator
		Spliterator<String> spliterator = myStream.spliterator();
		// Now,split the first iterator
		Spliterator<String> spliterator2 = spliterator.trySplit();
		// if spliterator could be split,use spliterator2 first
		if (spliterator2 != null) {
			System.out.println("Output from spliterator2：");
			spliterator2.forEachRemaining(n -> System.out.println(n));
		}
		// Now,we use spliterator
		System.out.println("\nOutput form spliterator：");
		spliterator.forEachRemaining(n -> System.out.println(n));

	}

	public static void spliteratorStream() {
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Alpha");
		myList.add("Beta");
		myList.add("Gamma");
		myList.add("Delta");
		myList.add("Phi");
		myList.add("Omega");

		// Obatin a Stream to the array list
		Stream<String> myStream = myList.stream();
		// Obtain a Spliterator
		Spliterator<String> spliterator = myStream.spliterator();
		// Iterator the elements of the stream
		while (spliterator.tryAdvance((n) -> System.out.println(n)))
			;
	}

	/**
	 * Use an iterator with a stream
	 */
	public static void iteratorStream() {
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
