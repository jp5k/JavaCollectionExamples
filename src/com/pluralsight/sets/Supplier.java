package com.pluralsight.sets;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.lists.Product;

public class Supplier {
	
	private final String supplierName;
	
	private List<Product> products = new ArrayList<>();
	
	public Supplier(String supplierName){
		this.supplierName = supplierName;
	}

	public List<Product> products() {
		return this.products;
	}
	

}
