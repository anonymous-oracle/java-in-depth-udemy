package genericsdemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenericsDemo<T extends List & Serializable> { // the bounds should be such that all bounds are satisfied by
															// the parameter type which will be used; also if the first
															// bound is a class then no other bounds should be a class
															// and the class type should be at the start of the bounds

	public static void main(String[] args) {
		Container<String> stringStore = new Store<>();
		stringStore.set("java");
		// stringStore.set(1);
		System.out.println(stringStore.get());

		Container<Integer> integerStore = new Store<>();
		integerStore.set(1);
		System.out.println(integerStore.get());

		Container<List<Integer>> listStore = new Store<>();
		listStore.set(Arrays.asList(1, 2, 3));
		System.out.println(listStore.get());

		// Container<int> intStore = new Store<>();
		List<Number> list = new ArrayList<>();
		list.add(1);
		list.add(22.0);
		// list.add(new String("22.0"));

		List[] array = new ArrayList[2];
		array[0] = new ArrayList();
		array[1] = new LinkedList();

//		GenericsDemo<List> list1 = new GenericsDemo<>(); // List type gives compilation error when Serializable interface is used since List does not implement it, However ArrayList implements it
		GenericsDemo<ArrayList> list2 = new GenericsDemo<>(); // if the bound is a final class that cannot be inherited,
																// then the type parameter should be the bound itself

	}

	public static void rawTypeTest() {
		System.out.println("\n\nInside rawTypeTest");
		int ISBN = 1505297729;
		List<Double> prices = new ArrayList<>();
		HalfIntegrator.getPrice(ISBN, prices);
		Double price = prices.get(0);

	}
}

class HalfIntegrator{

	public static void getPrice(int iSBN, List<Double> prices) {
		prices.add(45);
		
	}
	
}

interface Container<T> {
	void set(T a);

	T get();
}

class Store<T> implements Container<T> {
	private T a;

	public void set(T a) {
		this.a = a;
	}

	public T get() {
		return a;
	}
}
