package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Reduce Stream Examples
 * 
 * @author wangpeng
 * @date 16 Mar 2016 15:52:09
 */
public class StreamDemo8 {

	@Test
	public void testReduce() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("php");
		list.add("python");
		list.add("perl");
		list.add("c");
		list.add("lisp");
		list.add("c#");
		Stream<String> wordStream = list.stream();

		// get the sum of the length of strings in the list
		int num = wordStream.map(s -> s.length()).mapToInt(Integer::new).sum();
		System.out.println(num);

		wordStream = list.stream();
		Stream<Integer> lengthStream = wordStream.map(s -> s.length());
		Optional<Integer> sum = lengthStream.reduce((x, y) -> x + y);
		sum.ifPresent(System.out::println);
	}
}
