package com.pluralsight.collectionconcepts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.pluralsight.lists.Product;

public class CollectionConcepts {

	public static void main(String[] args) {
		Product door = new Product("Wooden Door", 35);
		Product floorPanel = new Product("Floor Panel", 25);
		Product window = new Product("Glass Window", 10);

		// Generic type parameter <Product>
		Collection<Product> products = new ArrayList<>();
		products.add(door);
		products.add(floorPanel);
		products.add(window);

		// To iterate over a collection. Below is the old way, and new way using
		// the for loop:

		// 1) Old way using an iterator (which allows us to REMOVE OR ADD ELEMENTS)
		final Iterator<Product> productIterator = products.iterator();
		while (productIterator.hasNext()) {
			Product product = productIterator.next();
			System.out.println(product);
		}

		// 2) New way (Java automatically pulls out an iterator, and loops over
		// it !!!!)
		// HOWEVER, DOESN'T ALLOW US TO ADD OR REMOVE ELEMENTS !!!
		// WILL THROW A ConcurrentModificationException exception if try to remove or add elements !!
		for (Product product : products) {
			System.out.println(product);
		}

		
		// AND SOME OTHER METHODS WHICH CAN BE USED FOR ALL COLLECTIONS !!
		// size() method
		System.out.println(products.size());
		// isEmpty() method
		System.out.println(products.isEmpty());
		// contains() method
		System.out.println(products.contains(window));

		// removeAll method
		Collection<Product> otherProducts = new ArrayList<>();
		otherProducts.add(window);
		otherProducts.add(door);
		products.removeAll(otherProducts);
		System.out.println(products);

	}

}
