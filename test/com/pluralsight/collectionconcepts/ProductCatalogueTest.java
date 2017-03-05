package com.pluralsight.collectionconcepts;

import static com.pluralsight.lists.ProductFixtures.door;
import static com.pluralsight.lists.ProductFixtures.floorPanel;
import static com.pluralsight.lists.ProductFixtures.window;

import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.Assert;
import org.junit.Test;

import com.pluralsight.lists.ProductFixtures;
import com.pluralsight.sets.ProductCatalogue;

public class ProductCatalogueTest {

	@Test
	public void shouldOnlyHoldUniqueProducts() throws Exception {
		ProductCatalogue catalogue = new ProductCatalogue();

		// Add some suppliers
		catalogue.isSuppliedBy(ProductFixtures.bobs);
		catalogue.isSuppliedBy(ProductFixtures.kates);

		// Check that the catalogue contains the elements which the suppliers
		// supply
		Assert.assertThat(catalogue, containsInAnyOrder(door, floorPanel));
		// Note the previous test would have failed if we had used a List,
		// because we would have multiple products of the same type in our
		// catalogue, provided by different suppliers.
	}

}
