package net.talaatharb.project;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Ohce implements Runnable {

	public static final String STOP_PHRASE = "Stop!";
	private final SystemTime systemTime;

	private final InputSystem inputSystem;
	private final OutputSystem outputSystem;
	private final String userName;

	@Override
	public void run() {
		welcomeMessage();

		String message;
		do {
			message = inputSystem.getInput();
			handle(message);
		} while (!STOP_PHRASE.equals(message));

		outputSystem.output("Adios " + userName);
	}

	private void welcomeMessage() {
		final int hour = systemTime.getHour();

		String message = "";
		if (hour >= 20 && hour <= 24 || hour >= 0 && hour <= 6) {
			message = "¡Buenas noches " + userName;
		} else if (hour > 6 && hour <= 12) {
			message = "¡Buenos días " + userName;
		} else {
			message = "¡Buenas tardes " + userName;
		}

		outputSystem.output(message);
	}

	private void handle(String message) {
		if (!STOP_PHRASE.equals(message)) {
			final String reversedString = reverseString(message);
			outputSystem.output(reversedString);
			if (message != null && message.equals(reversedString)) {
				outputSystem.output("¡Bonita palabra!");
			}
		}
	}

	private String reverseString(String string) {
		if (string == null) {
			return null;
		}

		final StringBuilder builder = new StringBuilder();
		for (int i = string.length() - 1; i >= 0; i--) {
			builder.append(string.charAt(i));
		}
		return builder.toString();
	}

}
