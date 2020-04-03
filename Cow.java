import java.util.ArrayList;
import java.awt.Color;
import acm.util.RandomGenerator;

public class Cow extends Animal {
	public Cow(Location l, World w) {
		super(l, w);
		myLifeSpan = 5;
		myColor = Color.white;
	}

	public void move() {
		int x = myLocation.getX();
		int y = myLocation.getY();
		Location l = new Location(0, 0);
		int i = 0;
		int x2 = x;
		int y2 = y;
		while (myWorld.isOccupied(l) && i < 5 && x2 < myWorld.getWidth()
				&& y2 < myWorld.getHeight() && x2 >= 0 && y2 >= 0) {
			i++;
			x2 = x + 1 * (rgen.nextBoolean() ? 1 : -1);
			y2 = y + 1 * (rgen.nextBoolean() ? 1 : -1);
			l.setX(x2);
			l.setY(y2);
		}
		if (!myWorld.isOccupied(l))
			setMyLocation(l);
	}

	public void reproduce() {

	}

	private RandomGenerator rgen = RandomGenerator.getInstance();

}
