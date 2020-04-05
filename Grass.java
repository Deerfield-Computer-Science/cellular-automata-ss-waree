import java.util.ArrayList;
import java.awt.Color;

import acm.util.RandomGenerator;

public class Grass extends Plant {

	public Grass(Location l, World w) {
		super(l, w);
		myLifeSpan = 3;
		mySpecies = 0;
	}

	public void move() {

	}

	public void eat() {
		System.out.println("uses photosynthesis");
	}

	public void reproduce(int currentSizeOfCreatureList) {
		int x = myLocation.getX();
		int y = myLocation.getY();
		Location l = new Location(x, y);
		int attempts = 0;
		int x2 = x;
		int y2 = y;
		while ((attempts < 3)
				&& (myWorld.isOccupied(l) || (x2 >= myWorld.getWidth())
						|| (y2 >= myWorld.getHeight()) || (x2 <= 0) || (y2 <= 0))) {
			attempts++;
			x2 = x + 1 * numbers[(int)(3*Math.random())];
			y2 = y + 1 * numbers[(int)(3*Math.random())];
			l.setX(x2);
			l.setY(y2);
		}
		if (!myWorld.isOccupied(l)){
			myWorld.getCreatureList().add(new Grass(l,myWorld));
		}
	}
	
	public int[] numbers = {-1,0,1};

	private RandomGenerator rgen = RandomGenerator.getInstance();
}
