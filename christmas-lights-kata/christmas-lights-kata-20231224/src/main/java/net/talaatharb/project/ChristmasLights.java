package net.talaatharb.project;

public class ChristmasLights {

	public static final int SIZE = 1000;

	private boolean[][] lights;

	public ChristmasLights() {
		lights = new boolean[SIZE][SIZE];
	}

	public boolean getStatus(int x, int y) {
		return lights[x][y];
	}

	public void turnOnAll() {
		turnOn(0, 0, SIZE - 1, SIZE - 1);
	}

	public void turnOffAll() {
		for (int y = 0; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				lights[x][y] = false;
			}
		}
	}

	public void turnOn(int startX, int startY, int endX, int endY) {
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				lights[x][y] = true;
			}
		}
	}

	public void turnOff(int startX, int startY, int endX, int endY) {
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				lights[x][y] = false;
			}
		}
	}

	public void toggle(int startX, int startY, int endX, int endY) {
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				lights[x][y] = !lights[x][y];
			}
		}
	}

	public int getTotalOn() {
		int counter = 0;
		for (int y = 0; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				if (lights[x][y]) {
					counter++;
				}
			}
		}
		return counter;
	}

}
