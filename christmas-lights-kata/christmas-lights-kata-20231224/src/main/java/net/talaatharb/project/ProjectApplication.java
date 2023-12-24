package net.talaatharb.project;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProjectApplication {
	public static void main(String[] args) {
		final ChristmasLights christmasLights = new ChristmasLights();

		christmasLights.turnOn(887, 9, 959, 629);

		christmasLights.turnOn(454, 398, 844, 448);

		christmasLights.turnOff(539, 243, 559, 965);

		christmasLights.turnOff(370, 819, 676, 868);

		christmasLights.turnOff(145, 40, 370, 997);

		christmasLights.turnOff(301, 3, 808, 453);

		christmasLights.turnOn(351, 678, 951, 908);

		christmasLights.toggle(720, 196, 897, 994);

		christmasLights.toggle(831, 394, 904, 860);

		log.info("Total lights on is: {}", christmasLights.getTotalOn());
	}
}