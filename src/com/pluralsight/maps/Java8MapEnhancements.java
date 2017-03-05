package com.pluralsight.maps;

import java.util.HashMap;
import java.util.Map;

public class Java8MapEnhancements {

	public static void main(String[] args) {

		final Product defaultProduct = new Product(-1,
				"Whatever the customer wants", 100);

		final Map<Integer, Product> idToProduct = new HashMap<>();
		idToProduct.put(1, ProductFixtures.door);
		idToProduct.put(2, ProductFixtures.floorPanel);
		idToProduct.put(3, ProductFixtures.window);

		// To return default instead of null
		Product result = idToProduct.getOrDefault(10, defaultProduct);
		System.out.println(result);
		// ..but doesn't actually update the underlying map
		System.out.println(idToProduct.get(10));
		System.out.println();

		// Replace operation, replacing door with Big Door. Will only replace if
		// key already
		// exists (otherwise will get null returned)
		Product result2 = idToProduct
				.replace(1, new Product(1, "Big Door", 50));
		System.out.println(result);
		System.out.println(idToProduct.get(1));

		// computeIfAbsent, if value is in map return it, if missing call
		// function and place new value
		// into map.
		// Will only work if element is absent
		Product result3 = idToProduct.computeIfAbsent(10, (id) -> new Product(
				id, "Custom product", 10));
		System.out.println(result3);
		System.out.println(idToProduct);

		// To loop through Map, this is now the easiest way of doing it
		// using forEach and Lambda expression
		idToProduct.forEach((key, value) -> 
		{
			System.out.println(key + "->" + value);
		});
		
	}

}
