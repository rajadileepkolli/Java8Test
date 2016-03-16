package com.util;

import java.util.Optional;

/**
 * 
 * Demonstrate several Optional<T> methods
 * 
 * @author wangpeng
 * @date 16 Mar 2016 10:18:33
 */
public class OptionalDemo {

	public static void main(String[] args) {
		Optional<String> noVal = Optional.empty();
		Optional<String> hasVal = Optional.of("ABCDEF");
		if (noVal.isPresent()) {
			System.out.println("This won't be displayed");
		} else {
			System.out.println("noVal has no value");
		}

		if (hasVal.isPresent()) {
			System.out.println("This string in hasVal is：" + hasVal.get());
		}
		String defStr = noVal.orElse("Default String");
		System.out.println(defStr);
	}
}
