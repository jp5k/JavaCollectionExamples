package com.pluralsight.lists;

import java.util.Arrays;

public class TheArrayProblem {

	public static void main(String[] args) {

		Product door = new Product("Wooden Door", 35);
		Product floorPanel = new Product("Floor Panel", 25);

		// Create
		Product[] products = { door, floorPanel };

		// Not a very friendly toString() method
		System.out.println(products);

		// This gives a better toString()
		System.out.println(Arrays.toString(products));

		// Add - will give indexOutOfBounds exception. Would have to reimplement
		// the add operation to resize the array. This would be a lot of hard work!!!
		// Arrays are a very low level feature.  Arrays can't enforce constraints in our code, 
		// e.g no duplicates (like a set can).
		final Product window = new Product("Window", 15);
		products[2] = window;
		System.out.println(Arrays.toString(products));

	}

}
