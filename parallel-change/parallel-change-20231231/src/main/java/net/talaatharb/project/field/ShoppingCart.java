package net.talaatharb.project.field;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private final List<Integer> prices = new ArrayList<>();

	public void add(int price) {
		prices.add(price);
	}

	public int calculateTotalPrice() {
		return prices.stream().reduce(0, (sum, n) -> sum += n);
	}

	public boolean hasDiscount() {
		return prices.stream().anyMatch(p -> p >= 100);
	}

	public int numberOfProducts() {
		return prices.size();
	}
}
