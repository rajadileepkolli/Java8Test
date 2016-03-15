package com.lambda;

/**
 * Use an instance method reference with difference objects
 * 
 * @author pengwang
 *
 */
public class InstanceMethWithObjectDemo {

	static <T> int counter(T[] vals, MyFunc2<T> f, T v) {
		int count = 0;
		for (int i = 0; i < vals.length; i++) {
			if (f.func(vals[i], v)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int count;

		// Create an array of HighTemp Objects
		HighTemp[] weekDayHighs = { new HighTemp(89), new HighTemp(82), new HighTemp(90), new HighTemp(89),
				new HighTemp(89), new HighTemp(91), new HighTemp(84), new HighTemp(83) };
		// Use counter() with arrays of the class HighTemp.Notice that a
		// reference to the instance method sameTemp() is passed as the second
		// argument
		count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
		System.out.println(count + " days had a high of 89");

		// Now,create and use another array of HighTemp objects
		HighTemp[] weekDayHighs2 = { new HighTemp(32), new HighTemp(12), new HighTemp(24), new HighTemp(19),
				new HighTemp(18), new HighTemp(12), new HighTemp(-1), new HighTemp(13) };
		count = counter(weekDayHighs2, HighTemp::sameTemp, new HighTemp(19));
		System.out.println(count + " days had a high of 12");

		// Now,use lessThanTemp() to find days when temperature was less than a
		// specified value
		count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
		System.out.println(count + " days had a high less than 89");

		count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(19));
		System.out.println(count + " days had a high of less than 19");
	}
}

/**
 * A functional interface that takes two reference arguments and return a
 * boolean result
 * 
 * @author pengwang
 *
 * @param <T>
 */
interface MyFunc2<T> {
	boolean func(T t1, T t2);
}

class HighTemp {
	private int hTemp;

	HighTemp(int ht) {
		// TODO Auto-generated constructor stub
		this.hTemp = ht;
	}

	/**
	 * Return true if the invoking HighTemp object has the same temperature as
	 * ht2
	 * 
	 * @param ht2
	 * @return
	 */
	boolean sameTemp(HighTemp ht2) {
		return hTemp == ht2.hTemp;
	}

	/**
	 * Return true if the invoking HighTemp object has a temperture that is less
	 * than ht2
	 * 
	 * @param ht2
	 * @return
	 */
	boolean lessThanTemp(HighTemp ht2) {
		return this.hTemp < ht2.hTemp;
	}
}
