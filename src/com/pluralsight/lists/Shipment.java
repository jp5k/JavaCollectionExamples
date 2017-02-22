package com.pluralsight.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// We are wrapping our collection of Products, and representing this in our Shipment business class.
// This is good programming practice.
public class Shipment implements Iterable<Product> {

	private static final int LIGHT_VAN_MAX_WEIGHT = 20;

	private static final int PRODUCT_NOT_PRESENT = -1;

	private final List<Product> products = new ArrayList<>();

	private List<Product> heavyVanProducts;
	private List<Product> lightVanProducts;
	
	public void add(Product product) {
		products.add(product);

	}

	public void replace(Product oldProduct, Product newProduct) {

		// an index of -1 will represent a product not in the list
		final int index = products.indexOf(oldProduct);
		if (index != PRODUCT_NOT_PRESENT) {
			products.set(index, newProduct);
		}

	}

	public void prepare() {

		// sort our list of products by weight

		// Old Java 7 way of doing things...
		// Collections.sort(products, Product.BY_WEIGHT);

		// New Java 8 way of doing things, passing in the comparator which we
		// have defined on the Product class.
		products.sort(Product.BY_WEIGHT);

		// find the product index that needs the heavy van
		int splitPoint = findSplitPoint();

		// assign views of the product list for heavy and light vans
		// Use sublist to return a view over our list.
		lightVanProducts = products.subList(0, splitPoint);
		heavyVanProducts = products.subList(splitPoint, products.size());		
	}

	private int findSplitPoint() {
		for (int i = 0; i < products.size(); i++) {
			// Use List get() method to get the product at that index
			final Product product = products.get(i);
			if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT)
			{
				// This will be the first product to go into the heavy van
				return i;
			}
		}

		return 0;
	}

	public List<Product> getHeavyVanProducts() {
		return heavyVanProducts;
	}

	public List<Product> getLightVanProducts() {
		return lightVanProducts;
	}

	@Override
	// Because we've implemented iterator for our class, we need to implement
	// the interface method iterator
	public Iterator<Product> iterator() {
		// Delegate to the iterator method on the products class
		return products.iterator();
	}

}
