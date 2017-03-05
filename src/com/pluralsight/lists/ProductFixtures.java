package com.pluralsight.lists;

import com.pluralsight.sets.Supplier;

public class ProductFixtures {
	
	public static Product door = new Product("Wooden Door", 35);
	public static Product floorPanel = new Product("Floor Panel", 25);
	public static Product window = new Product("Glass Window", 10);
	
	public static Supplier bobs = new Supplier("Bob's Household Supplies");
	public static Supplier kates = new Supplier("Kate's Home Goods");
	
	static{
		bobs.products().add(door);
		bobs.products().add(floorPanel);
				
		kates.products().add(door);
		kates.products().add(floorPanel);
		
		kates.products().add(new Product("Wooden Door", 35));
		// Note, very important.  If we had used the following to add a new door
		// kates.products().add(new Product("Wooden Door", 35));
		// Then the test would fail because we hadn't implemented the equals/hashcode 
		// contract in the Product class.  Once this is implemented, then test would pass.
		
		
	}

}
