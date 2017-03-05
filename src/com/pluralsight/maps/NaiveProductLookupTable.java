package com.pluralsight.maps;

import java.util.ArrayList;
import java.util.List;

public class NaiveProductLookupTable implements ProductLookupTable {

	// This is an ugly implementation, lots of looks to look up the id in adding and 
	// looking up.  See the MapProductLookupTable for a much better implementation
	
	private List<Product> products = new ArrayList<>();

	@Override
	public void addProduct(final Product productToAdd) {
		for (Product product : products) {
			if (product.getId() == productToAdd.getId()) {
				throw new IllegalArgumentException(
						"Unable to add product, duplicate id for product to add");
			}
		}

		products.add(productToAdd);
	}

	@Override
	public Product lookupById(final int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	public void clear() {

		products.clear();
		
	}

}
