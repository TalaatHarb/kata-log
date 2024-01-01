package net.talaatharb.project.field;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ImagineThisIsAClientInADifferentRepositoryTest {


	@Test
	public void singleItem_numberOfProductsInTheCart() throws Exception {
		final ImagineThisIsAClientInADifferentRepository client = new ImagineThisIsAClientInADifferentRepository();

		assertEquals("Total price is 50 euro", client.formattedTotalPrice(50));
	}

}
