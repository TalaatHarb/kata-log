package net.talaatharb.project.field;

public class LocalClient {

	public static void main(String[] args) {
		final ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.add(10);
		System.out.println("shoppingCart.numberOfProducts() = " + shoppingCart.numberOfProducts());
		System.out.println("shoppingCart.calculateTotalPrice() = " + shoppingCart.calculateTotalPrice());
		System.out.println("shoppingCart.hasDiscount() = " + shoppingCart.hasDiscount());
	}

}
