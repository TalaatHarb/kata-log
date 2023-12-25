package net.talaatharb.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WardrobeConfigurationCreatorTests {

	private static Integer wallSize;
	private static Map<Integer, Integer> prices;
	private WardrobeConfigurationCreator wardrobeConfigurationCreator;
	private Set<Integer> sizes;

	@BeforeAll
	static void globalSetup() {
		wallSize = 250;

		prices = new HashMap<>();
		prices.put(50, 59);
		prices.put(75, 62);
		prices.put(100, 90);
		prices.put(120, 111);
	}

	@BeforeEach
	void setup() {
		wardrobeConfigurationCreator = new WardrobeConfigurationCreator();
	}

	@Test
	void testNoSizesMeansNoConfigurations() {
		sizes = Set.of();
		final Set<Collection<Integer>> expected = Set.of();

		final var result = wardrobeConfigurationCreator.createConfigurations(wallSize, sizes);

		assertEquals(expected, result);
	}

	@Test
	void testExactConfigurationMatchesOneSize() {
		sizes = Set.of(250);
		final var expected = Set.of(List.of(250));

		final var result = wardrobeConfigurationCreator.createConfigurations(wallSize, sizes);

		assertEquals(expected, result);
	}

	@Test
	void testExactConfigurationMatchesMultipleOneSize() {
		sizes = Set.of(125);
		final var expected = Set.of(List.of(125, 125));

		final var result = wardrobeConfigurationCreator.createConfigurations(wallSize, sizes);

		assertEquals(expected, result);
	}

	@Test
	void testExactConfigurationMatchesTwoSizes() {
		sizes = Set.of(100, 150);
		final var expected = Set.of(List.of(150, 100));

		final var result = wardrobeConfigurationCreator.createConfigurations(wallSize, sizes);

		assertEquals(expected, result);
	}

	@Test
	void testNoExactConfigurationReturnsEmpty() {
		sizes = Set.of(100);
		final var expected = Set.of();

		final var result = wardrobeConfigurationCreator.createConfigurations(wallSize, sizes);

		assertEquals(expected, result);
	}

	@Test
	void testMultipleConfigurationMatch() {
		sizes = Set.of(100, 50);
		final var expected = Set.of(List.of(100, 100, 50), List.of(50, 50, 50, 50, 50), List.of(100, 50, 50, 50));

		final var result = wardrobeConfigurationCreator.createConfigurations(wallSize, sizes);

		assertEquals(expected, result);
	}

	@Test
	void testOnlyConfigurationIsCheapestAlways() throws IllegalAccessException {
		sizes = Set.of(100, 75);
		final var expected = List.of(100, 75, 75);

		final var result = wardrobeConfigurationCreator.cheapestConfiguration(wallSize, sizes, prices);

		assertEquals(expected, result);
	}

	@Test
	void testNoConfigurationReturnsNull() throws IllegalAccessException {
		sizes = Set.of();

		final var result = wardrobeConfigurationCreator.cheapestConfiguration(wallSize, sizes, prices);

		assertNull(result);
	}

	@Test
	void testMultipleConfigurationCheapest() throws IllegalAccessException {
		sizes = Set.of(100, 75, 50);
		final var expected = List.of(100, 75, 75);

		final var result = wardrobeConfigurationCreator.cheapestConfiguration(wallSize, sizes, prices);

		assertEquals(expected, result);
	}
}
