package net.talaatharb.project.field;

public class ImagineThisIsAClientInADifferentRepository {
	public String formattedTotalPrice(int price) {
		final ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.add(price);
		return String.format("Total price is %d euro", shoppingCart.calculateTotalPrice());
	}
}
