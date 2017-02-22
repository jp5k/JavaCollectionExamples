package com.pluralsight.lists;

import java.util.Comparator;

public class Product {

	// Java 8 way of introducing a comparator, which defines a sort order over
	// our products
	public static final Comparator<Product> BY_WEIGHT = Comparator.comparing(Product::getWeight);

	private final String name;
	private final int weight;

	public Product(String name, int weight) {

		this.name = name;
		this.weight = weight;

	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", weight=" + weight + "]";
	}

}
