package com.pluralsight.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.pluralsight.lists.Product;

public class ProductCatalogue implements Iterable<Product> {

	// Note, a set doesn't give you many more methods than the Collection
	// interface gives you. However, do get the symantic guarantee
	// that set will contain unique elements.
	private final Set<Product> products = new HashSet<>();
	
	//If we wanted to use a TreeSet, would need to supply a comparator, e.g.
	// private final Set<Product> products = new TreeSet<>(Product.BY_NAME);

	public void isSuppliedBy(Supplier supplier) {
		// Want a set, because don't want duplicate products in our catalogue
		products.addAll(supplier.products());

	}

	public Iterator<Product> iterator() {
		return products.iterator();
	}

}
