package net.talaatharb.project;

public class OutputSystemImpl implements OutputSystem {

	@Override
	public void output(String text) {
		if (text != null) {
			if (text.startsWith("$ ")) {
				System.out.print(text);
			} else {
				System.out.println("> " + text);
			}
		}
	}

}
