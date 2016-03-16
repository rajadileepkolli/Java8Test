package com.rx;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 
 * 
 * @author wangpeng
 * @date 16 Mar 2016 11:59:35
 */
public class RxJavaHello2 {

	/**
	 * The Filter operator filters an Observable by only allowing items through
	 * that pass a test that you specify in the form of a predicate function.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFilter() throws Exception {
		Observable.just(1, 2, 3, 4, 5).filter(new Func1<Integer, Boolean>() {
			@Override
			public Boolean call(Integer item) {
				return (item < 4);
			}
		}).subscribe(new Subscriber<Integer>() {
			@Override
			public void onNext(Integer item) {
				System.out.println("Next: " + item);
			}

			@Override
			public void onError(Throwable error) {
				System.err.println("Error: " + error.getMessage());
			}

			@Override
			public void onCompleted() {
				System.out.println("Sequence complete.");
			}
		});
	}

	/**
	 * map transform one event to another. flatMap transform one event to zero
	 * or more event. (this is taken from IntroToRx)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFlatMapVsMap() throws Exception {
		String[] items = { "伊万诺夫", "索佐诺夫", "松友美佐纪", "高桥礼华", "因达农", "李雪芮" };
		// START DIFFERENCE BETWEEN MAP AND FLATMAP
		Observable.from(items).map((str1) -> {
			System.out.println("insde the map " + str1);
			return str1;
		}).subscribe(System.out::println);

		Observable.from(items).flatMap((str1) -> {
			System.out.println("inside the flatMap" + str1);
			str1 += "+";
			String str2 = str1 + "+";
			String str3 = str2 + "+";

			return Observable.just(str1, str2, str3);
		}).subscribe(System.out::println);
		// END DIFFERENCE BETWEEN MAP AND FLATMAP
	}

	/**
	 * Returns an Observable that emits all items emitted by the source
	 * Observable that are distinct.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDistinct() throws Exception {
		Observable.just(1, 2, 1, 1, 2, 3).distinct().subscribe(new Subscriber<Integer>() {
			@Override
			public void onNext(Integer item) {
				System.out.println("Next: " + item);
			}

			@Override
			public void onError(Throwable error) {
				System.err.println("Error: " + error.getMessage());
			}

			@Override
			public void onCompleted() {
				System.out.println("Sequence complete.");
			}
		});
	}

	/**
	 * Converts three items into an Observable that emits those items.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testJust() throws Exception {
		Observable.just(1, 2, 3).subscribe(new Subscriber<Integer>() {
			@Override
			public void onNext(Integer item) {
				System.out.println("Next: " + item);
			}

			@Override
			public void onError(Throwable error) {
				System.err.println("Error: " + error.getMessage());
			}

			@Override
			public void onCompleted() {
				System.out.println("Sequence complete.");
			}
		});
	}

	/**
	 * Converts an Array into an Observable that emits the items in the Array.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFrom() throws Exception {
		Integer[] items = { 0, 1, 2, 3, 4, 5 };
		Observable<Integer> myObservable = Observable.from(items);

		myObservable.subscribe(new Action1<Integer>() {
			@Override
			public void call(Integer item) {
				System.out.println(item);
			}
		}, new Action1<Throwable>() {
			@Override
			public void call(Throwable error) {
				System.out.println("Error encountered: " + error.getMessage());
			}
		}, new Action0() {
			@Override
			public void call() {
				System.out.println("Sequence complete");
			}
		});
	}
}
