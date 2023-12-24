package net.talaatharb.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChristmasLightsTests {

	private ChristmasLights christmasLights;

	@BeforeEach
	void setup() {
		christmasLights = new ChristmasLights();
	}

	@Test
	void testWhenStartedAllLightsAreOff() {
		// action = nothing

		// assert all turned off
		for (int y = 0; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				assertFalse(christmasLights.getStatus(x, y));
			}
		}
	}

	@Test
	void testTurnOnAllLightsTurnsAllOn() {
		// action = turn on all
		christmasLights.turnOnAll();

		// assert all turned on
		for (int y = 0; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				assertTrue(christmasLights.getStatus(x, y));
			}
		}
	}

	@Test
	void testTurnOffAllLightsTurnsAllOff() {
		// action = turn off all after turning on
		christmasLights.turnOnAll();
		christmasLights.turnOffAll();

		// assert all turned on
		for (int y = 0; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				assertFalse(christmasLights.getStatus(x, y));
			}
		}
	}

	@Test
	void testTurnOnRange() {
		// action = turn on (0,0) -> (999, 0) 'first row'
		christmasLights.turnOn(0, 0, ChristmasLights.SIZE - 1, 0);

		// assert range is turned on and rest is off
		for (int x = 0; x < ChristmasLights.SIZE; x++) {
			assertTrue(christmasLights.getStatus(x, 0));
		}

		for (int y = 1; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				assertFalse(christmasLights.getStatus(x, y));
			}
		}
	}

	@Test
	void testTurnOffRange() {
		// action = turn off (499,499) -> (500,500) 'four squares in the middle'
		christmasLights.turnOnAll();
		christmasLights.turnOff(499, 499, 500, 500);

		for (int y = 499; y < 501; y++) {
			for (int x = 499; x < 501; x++) {
				assertFalse(christmasLights.getStatus(x, y));
			}
		}
	}

	@Test
	void testToggleRange() {
		// action = toggle (0,0) -> (999, 0) 'first row'
		christmasLights.toggle(0, 0, ChristmasLights.SIZE - 1, 0);

		// assert range is turned on and rest is off
		for (int x = 0; x < ChristmasLights.SIZE; x++) {
			assertTrue(christmasLights.getStatus(x, 0));
		}

		for (int y = 1; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				assertFalse(christmasLights.getStatus(x, y));
			}
		}
	}

	@Test
	void testCountLightsOnWorks() {
		assertEquals(0, christmasLights.getTotalOn());

		christmasLights.turnOnAll();

		assertEquals(ChristmasLights.SIZE * ChristmasLights.SIZE, christmasLights.getTotalOn());
	}

}
