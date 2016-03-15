package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Map one the stream to another
 * 
 * @author wangpeng
 * @date 15 Mar 2016 16:41:44
 */
public class StreamDemo5 {

	public static void main(String[] args) {
		// mapToAnother();
		collectTest();
	}

	public static void collectTest() {
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("大熊1", "1755610380", "1755610380@qq.com"));
		myList.add(new NamePhoneEmail("大熊2", "1755610380", "1755610380@qq.com"));
		myList.add(new NamePhoneEmail("大熊3", "1755610380", "1755610380@qq.com"));
		myList.add(new NamePhoneEmail("大熊4", "1755610380", "1755610380@qq.com"));
		System.out.println("Original values in myList：");
		myList.stream().forEach(a -> {
			System.out.println(a.name + " " + a.phoneNum + " " + a.email);
		});
		System.out.println();

		// Map just the names and phone numbers to new stream
		Stream<NamePhone> nameAndPhone = myList.stream().map(a -> new NamePhone(a.name, a.phoneNum));
		// Use collect to create a List of the names and phone numbers
		List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());
		System.out.println("Names and phone numbers in a List：");
		for (NamePhone namePhone : npList) {
			System.out.println(namePhone.name + " " + namePhone.phonenum);
		}

		// Obtain another mapping of the names and phone numbers
		nameAndPhone = myList.stream().map(a -> new NamePhone(a.name, a.phoneNum));
		// Now,create a Sety by use of collect()
		Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());
		System.out.println("\nNames and phone numbers in a Set：");
		for (NamePhone namePhone : npSet) {
			System.out.println(namePhone.name + " " + namePhone.phonenum);
		}
	}

	/**
	 * Map one the stream to another
	 */
	public static void mapToAnother() {
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("大熊1", "1755610380", "1755610380@qq.com"));
		myList.add(new NamePhoneEmail("大熊2", "1755610380", "1755610380@qq.com"));
		myList.add(new NamePhoneEmail("大熊3", "1755610380", "1755610380@qq.com"));
		myList.add(new NamePhoneEmail("大熊4", "1755610380", "1755610380@qq.com"));
		System.out.println("Original values in myList：");
		myList.stream().forEach(a -> {
			System.out.println(a.name + " " + a.phoneNum + " " + a.email);
		});
		System.out.println();

		// Map just the names and phone numbers to new stream
		Stream<NamePhone> nameAndPhone = myList.stream().map(a -> new NamePhone(a.name, a.phoneNum));
		System.out.println("List of names and phone numbers：");
		nameAndPhone.forEach(a -> {
			System.out.println(a.name + " " + a.phonenum);
		});

		nameAndPhone = myList.stream().filter(a -> a.name.equals("大熊1")).map(a -> new NamePhone(a.name, a.phoneNum));
		System.out.println("List of names and phone numbers：");
		nameAndPhone.forEach(a -> {
			System.out.println(a.name + " " + a.phonenum);
		});
	}
}

class NamePhoneEmail {
	String name;
	String phoneNum;
	String email;

	public NamePhoneEmail(String n, String p, String e) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.phoneNum = p;
		this.email = e;
	}
}

class NamePhone {
	String name;
	String phonenum;

	public NamePhone(String n, String p) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.phonenum = p;
	}
}
