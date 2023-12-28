package net.talaatharb.project;

import java.util.Scanner;

public class ProjectApplication{
	public static void main(String[] args) {
		final SystemTime systemTime = new SystemTimeImpl();
		final OutputSystem outputSystem = new OutputSystemImpl();
		final InputSystem inputSystem = new InputSystemImpl(outputSystem, new Scanner(System.in));
		final String userName = args != null && args.length > 0 ? args[0] : "User";

		final var ohce = new Ohce(systemTime, inputSystem, outputSystem, userName);

		ohce.run();
	}
}