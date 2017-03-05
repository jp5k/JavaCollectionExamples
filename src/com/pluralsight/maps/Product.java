package com.pluralsight.maps;

import java.util.Comparator;

public class Product {

	// Java 8 way of introducing a comparator, which defines a sort order over
	// our products
	public static final Comparator<Product> BY_WEIGHT = Comparator.comparing(Product::getWeight);
	public static final Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);
	
	private final int id;
	private final String name;
	private final int weight;

	public Product(final int id, final String name, final int weight) {

		this.id = id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
// IMPLEMENTING THE HASHCODE/EQUALS METHOD, LET THE IDE DO THIS FOR YOU!!
	

}
