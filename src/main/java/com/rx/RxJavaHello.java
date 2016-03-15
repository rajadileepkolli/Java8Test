package com.rx;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 
 * The smallest building block is actually an Observer, but in practice you are
 * most often using Subscriber because that's how you hook up to Observables
 * 
 * @author wangpeng
 * @date 14 Mar 2016 18:54:26
 */
public class RxJavaHello {
	public static void main(String[] args) {
		// rxHelloWorld();
		// simple();
		// operators();
		moreOnMap();
	}

	/**
	 * Our Observable emits "Hello, world!" then completes. Now let's create a
	 * Subscriber to consume the data
	 */
	public static void rxHelloWorld() {
		Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see rx.functions.Action1#call(java.lang.Object)
			 */
			@Override
			public void call(Subscriber<? super String> subscriber) {
				// TODO Auto-generated method stub
				subscriber.onNext("Hello world！");
				subscriber.onCompleted();
			}
		});

		Subscriber<String> mySubscriber = new Subscriber<String>() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see rx.Observer#onNext(java.lang.Object)
			 */
			@Override
			public void onNext(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see rx.Observer#onCompleted()
			 */
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see rx.Observer#onError(java.lang.Throwable)
			 */
			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
			}
		};

		/**
		 * Now that we've got myObservable and mySubscriber we can hook them up
		 * to each other using subscribe()，then Outputs "Hello，World！"
		 */
		myObservable.subscribe(mySubscriber);
	}

	/**
	 * That's a lot of boilerplate code just to say "Hello, world!" That's
	 * because I took the verbose route so you could see exactly what's
	 * happening. There are lots of shortcuts provided in RxJava to make coding
	 * easier
	 */
	public static void simple() {
		Observable<String> myObservable = Observable.just("Hello, world！");
		Action1<String> onNextAction = new Action1<String>() {
			@Override
			public void call(String s) {
				System.out.println(s);
			}
		};
		myObservable.subscribe(onNextAction);

		/**
		 * Now, let's get rid of those variables by just chaining the method
		 * calls together:
		 */
		Observable.just("Hello，world！").subscribe(new Action1<String>() {

			@Override
			public void call(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});

		/**
		 * Finally, let's use Java 8 lambdas to get rid of that ugly Action1
		 * code.
		 */
		Observable.just("Hello，world！").subscribe(s -> System.out.println(s));
	}

	/**
	 * Here's how we're going to solve the item transformation problems: with
	 * operators. Operators can be used in between the source Observable and the
	 * ultimate Subscriber to manipulate emitted items. RxJava comes with a huge
	 * collection of operators, but its best to focus on just a handful at
	 * first.
	 */
	public static void operators() {
		/**
		 * append my signature to the "Hello, world!" output. the map() operator
		 * can be used to transform one emitted item into another
		 */
		Observable.just("Hello，world！").map(new Func1<String, String>() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see rx.functions.Func1#call(java.lang.Object)
			 */
			@Override
			public String call(String t) {
				// TODO Auto-generated method stub
				return t + " -Dan";
			}
		}).subscribe(s -> System.out.println(s));

		/**
		 * Again, we can simplify this by using lambdas
		 */
		Observable.just("Hello，world！").map(s -> s + " -Dan").subscribe(s -> System.out.println(s));
	}

	/**
	 * Here's an interesting aspect of map(): it does not have to emit items of
	 * the same type as the source Observable!
	 */
	public static void moreOnMap() {
		Observable.just("Hello，world！").map(new Func1<String, Integer>() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see rx.functions.Func1#call(java.lang.Object)
			 */
			@Override
			public Integer call(String t) {
				// TODO Auto-generated method stub
				return t.hashCode();
			}
		}).subscribe(i -> System.out.println(Integer.toString(i)));

		/**
		 * Interesting - we started with a String but our Subscriber receives an
		 * Integer. Again, we can use lambdas to shorten this code
		 */
		Observable.just("Hello，world！").map(s -> s.hashCode()).subscribe(i -> System.out.println(Integer.toString(i)));

		/**
		 * Like I said before, we want our Subscriber to do as little as
		 * possible. Let's throw in another map() to convert our hash back into
		 * a String
		 */
		Observable.just("Hello，world！").map(s -> s.hashCode()).map(i -> Integer.toString(i))
				.subscribe(s -> System.out.println(s));

		/**
		 * Would you look at that - our Observable and Subscriber are back to
		 * their original code! We just added some transformational steps in
		 * between. We could even add my signature transformation back in as
		 * well
		 */
		Observable.just("Hello, world!").map(s -> s + " -Dan").map(s -> s.hashCode()).map(i -> Integer.toString(i))
				.subscribe(s -> System.out.println(s));
	}
}
