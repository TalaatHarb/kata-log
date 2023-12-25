package net.talaatharb.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProjectApplication {
	public static void main(String[] args) throws IllegalAccessException {
		final WardrobeConfigurationCreator configurationCreator = new WardrobeConfigurationCreator();

		final int wallSize = 250;
		final var sizes = Set.of(50, 75, 100, 120);

		final Map<Integer, Integer> prices = new HashMap<>();
		prices.put(50, 59);
		prices.put(75, 62);
		prices.put(100, 90);
		prices.put(120, 111);

		final var configurations = configurationCreator.createConfigurations(wallSize, sizes);
		log.info("Available configurations: {}", configurations.toString());

		final var cheapest = configurationCreator.cheapestConfiguration(wallSize, sizes, prices);
		log.info("Cheapest configuration: {} which costs ${}", cheapest.toString(),
				configurationCreator.price(cheapest, prices));
	}
}