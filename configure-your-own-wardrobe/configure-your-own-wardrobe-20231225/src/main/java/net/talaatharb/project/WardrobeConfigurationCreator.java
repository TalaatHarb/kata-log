package net.talaatharb.project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WardrobeConfigurationCreator {

	public Set<List<Integer>> createConfigurations(final int wallSize, final Collection<Integer> sizes) {
		final var orderedSizes = new ArrayList<>(sizes);
		Collections.sort(orderedSizes);

		return createConfigurations(wallSize, orderedSizes, 0);
	}

	private Set<List<Integer>> createConfigurations(final Integer wallSize, final List<Integer> orderedSizes,
			int index) {
		final var result = new HashSet<List<Integer>>();
		final int count = orderedSizes.size();

		while (count > index) {
			final int size = orderedSizes.get(count - index - 1);
			final int reminder = wallSize - size;
			if (reminder > 0) {
				final var completedConfigurations = createConfigurations(reminder, orderedSizes, index).stream()
						.map(c -> {
							final var configuration = new ArrayList<Integer>(c.size() + 1);
							configuration.add(size);
							configuration.addAll(c);

							return configuration;
						}).collect(Collectors.toSet());
				result.addAll(completedConfigurations);
			} else if (reminder == 0) {
				result.add(List.of(size));
				break;
			}
			index++;
		}

		return result;
	}

	public List<Integer> cheapestConfiguration(final int wallSize, final Collection<Integer> sizes,
			final Map<Integer, Integer> prices) throws IllegalAccessException {
		List<Integer> result = null;
		int price = Integer.MAX_VALUE;
		final var configurations = createConfigurations(wallSize, sizes);

		for (final List<Integer> configuration : configurations) {
			final int configurationPrice = price(configuration, prices);
			if (configurationPrice < price) {
				price = configurationPrice;
				result = configuration;
			}
		}

		return result;
	}

	public int price(List<Integer> configuration, Map<Integer, Integer> prices) throws IllegalAccessException {
		int price = 0;
		for (final Iterator<Integer> iterator = configuration.iterator(); iterator.hasNext();) {
			final int size = iterator.next();
			final Integer sizePrice = prices.get(size);
			if (sizePrice != null) {
				price += sizePrice;
			} else {
				throw new IllegalAccessException("No price for size: " + size);
			}
		}
		return price;
	}
}
