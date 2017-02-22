package com.pluralsight.collectionconcepts;

import static com.pluralsight.lists.ProductFixtures.door;
import static com.pluralsight.lists.ProductFixtures.window;
import static com.pluralsight.lists.ProductFixtures.floorPanel;
import static org.hamcrest.Matchers.contains;

import org.junit.Test;
import org.junit.Assert;

import com.pluralsight.lists.Shipment;

public class ShipmentTest {

	private Shipment shipment = new Shipment();

	@Test
	public void shouldAddItems() throws Exception {

		shipment.add(door);
		shipment.add(window);

		// contains in HamCrest is iterable over our collection
		// Our Shipment class is something that can be iterated over (but it
		// isn't a collection)
		Assert.assertThat(shipment, contains(door, window));

	}

	@Test
	public void shouldReplaceItems() throws Exception {
		shipment.add(door);
		shipment.add(window);

		shipment.replace(door, floorPanel);

		Assert.assertThat(shipment, contains(floorPanel, window));
	}

	@Test
	public void shouldNotReplaceMissingItems() throws Exception {
		shipment.add(window);

		// Trying to do a replace with something that was never in the shipment
		// in the first place.
		shipment.replace(door, floorPanel);
		Assert.assertThat(shipment, contains(window));
	}

	@Test
	public void shouldIdentifyVanRequirements() throws Exception {
		shipment.add(door);
		shipment.add(window);
		shipment.add(floorPanel);

		shipment.prepare();

		Assert.assertThat(shipment.getLightVanProducts(), contains(window));
		Assert.assertThat(shipment.getHeavyVanProducts(),
				contains(floorPanel, door));

	}

}
