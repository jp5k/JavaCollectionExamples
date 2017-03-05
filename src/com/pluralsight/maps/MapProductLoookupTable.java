package com.pluralsight.maps;

import java.util.HashMap;
import java.util.Map;

public class MapProductLoookupTable implements ProductLookupTable {

	// A much better implementation using a Map
	
	// Good practice to call variable what the key to variable is, e.g.
	// idToProduct
	private final Map<Integer, Product> idToProduct = new HashMap<>();

	@Override
	public Product lookupById(final int id) {
		// will just return null if no id found in the map
		return idToProduct.get(id);

	}

	@Override
	public void addProduct(Product productToAdd) {
		final int id = productToAdd.getId();
		
		// check not a product with id already
		if (idToProduct.containsKey(id)) {
			throw new IllegalArgumentException(
					"Unable to add product, duplicate id for product for" +
			productToAdd);
		}
		
		// otherwise put it into map
		idToProduct.put(id, productToAdd);

	}

	@Override
	public void clear() {
		idToProduct.clear();

	}

}
