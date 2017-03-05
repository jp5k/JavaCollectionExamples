package com.pluralsight.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps {

	public static void main(String[] args) {
		final Map<Integer, Product> idToProduct = new HashMap<>();
		idToProduct.put(1, ProductFixtures.door);
		idToProduct.put(2, ProductFixtures.floorPanel);
		idToProduct.put(3, ProductFixtures.window);
		
			
		System.out.println(idToProduct);
		System.out.println();
		
		// keySet is set of Integers, represents the keys of the map
		final Set<Integer> ids = idToProduct.keySet();
		System.out.println(ids);
		// If we make a modification, update is reflected in underlying collection
		// So removing an element, removes it from both view and underlying map
		ids.remove(1);
		System.out.println(ids);
		System.out.println(idToProduct);
		
		// If we tried to add an element, get an error
		// because we don't know what value is associated with that key
		//ids.add(4);
		
		// Can return Collection of Values (may not be unique)
		final Collection<Product> products = idToProduct.values();
		// Can see what products are etc..
		System.out.println(products);
		System.out.println();
		
		// Can do remove based mutation, but not add based mutation
		products.remove(ProductFixtures.floorPanel);
		System.out.println(products);
		System.out.println(idToProduct);
		System.out.println();
		
		// Can't do the following, will break (don't know what key to add)
		//products.add(ProductFixtures.floorPanel);
		
		// entrySet is useful for looping over the Map 
		final Set<Map.Entry<Integer,Product>> entries = idToProduct.entrySet();
		
		for (Map.Entry<Integer, Product> entry : entries)
		{
			System.out.println(entry.getKey() + "-->" + entry.getValue());
			// setValue allows a change in the entrySet
			entry.setValue(ProductFixtures.floorPanel);
		}
		
		System.out.println(idToProduct);
		
	}
	
}
