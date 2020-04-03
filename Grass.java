import java.util.ArrayList;
import java.awt.Color;

public class Grass extends Plant {

	public Grass(Location l, World w) {
		super(l, w);
		myLifeSpan = 3;
		myColor = Color.red;
	}

	public void move() {
		
	}

	public void reproduce() {
		// this is silly code really, but as an example
		int newX = (int) (Math.random() * 20);
		int newY = (int) (Math.random() * 20);

		myWorld.getCreatureList().add(
				new Grass(new Location(newX, newY), myWorld));
	}

}
