package net.talaatharb.project;

import java.util.Scanner;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputSystemImpl implements InputSystem {

	private final OutputSystem outputSystem;

	private final Scanner scanner;

	@Override
	public String getInput() {
		outputSystem.output("$ ");
		return scanner.nextLine();
	}

}
