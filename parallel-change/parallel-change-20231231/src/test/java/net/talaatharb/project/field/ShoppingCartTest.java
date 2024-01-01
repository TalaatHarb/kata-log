package net.talaatharb.project.field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ShoppingCartTest {


	@Test
	void singleItem_numberOfProductsInTheCart() throws Exception {
		final ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.add(10);

		assertEquals(1, shoppingCart.numberOfProducts());
	}

	@Test
	void singleItem_totalPrice() throws Exception {
		final ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.add(10);

		assertEquals(10, shoppingCart.calculateTotalPrice());
	}

	@Test
	void singleItem_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() throws Exception {
		final ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.add(100);

		assertTrue(shoppingCart.hasDiscount());
	}

	@Test
	void singleItem_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() throws Exception {
		final ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.add(99);

		assertFalse(shoppingCart.hasDiscount());
	}

}
