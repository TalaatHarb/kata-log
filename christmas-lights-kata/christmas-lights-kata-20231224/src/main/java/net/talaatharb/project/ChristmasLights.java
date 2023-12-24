package net.talaatharb.project;

public class ChristmasLights {

	public static final int SIZE = 1000;

	private final int[][] brightness;

	public ChristmasLights() {
		brightness = new int[SIZE][SIZE];
	}

	public boolean getStatus(int x, int y) {
		return brightness[x][y] > 0;
	}

	public int getBrightness(int x, int y) {
		return brightness[x][y];
	}

	public void turnOnAll() {
		turnOn(0, 0, SIZE - 1, SIZE - 1);
	}

	public void turnOffAll() {
		turnOff(0, 0, SIZE - 1, SIZE - 1);
	}

	public void turnOn(int startX, int startY, int endX, int endY) {
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				brightness[x][y]++;
			}
		}
	}

	public void turnOff(int startX, int startY, int endX, int endY) {
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				brightness[x][y] = brightness[x][y] == 0 ? 0 : brightness[x][y] - 1;
			}
		}
	}

	public void toggle(int startX, int startY, int endX, int endY) {
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				brightness[x][y] += 2;
			}
		}
	}

	public int getTotalOn() {
		int counter = 0;
		for (int y = 0; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				if (brightness[x][y] > 0) {
					counter++;
				}
			}
		}
		return counter;
	}

	public int getTotalBrightness() {
		int sum = 0;
		for (int y = 0; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				sum += brightness[x][y];
			}
		}
		return sum;
	}

}
