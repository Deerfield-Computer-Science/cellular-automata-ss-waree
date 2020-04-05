import java.util.ArrayList;
import java.awt.Color;
import acm.util.RandomGenerator;

public class Tiger extends Animal {
	public Tiger(Location l, World w) {
		super(l, w);
		myLifeSpan = 7;
		myColor = Color.red;
		myDiet = 2;
		mySpecies = 2;
	}

	public void move() {

		int x = myLocation.getX();
		int y = myLocation.getY();
		Location l = new Location(x, y);
		int attempts = 0;
		int x2 = x;
		int y2 = y;
		while ((attempts < 5)
				&& (myWorld.isOccupied(l) || (x2 >= myWorld.getWidth())
						|| (y2 >= myWorld.getHeight()) || (x2 <= 0) || (y2 <= 0))) {
			attempts++;
			x2 = x + 1 * numbers2[(int) (5 * Math.random())];
			y2 = y + 1 * numbers2[(int) (5 * Math.random())];
			l.setX(x2);
			l.setY(y2);
		}
		if (!myWorld.isOccupied(l))
			setMyLocation(l);
	}

	public void eat() {
		int index = 0;
		System.out.println("this creature looks for prey");
		for (LifeForm prey : myWorld.getCreatureList()) {
			if (isEdible(prey.getMySpecies(), prey.getMyDiet(), prey
					.getMyLocation().getX(), prey.getMyLocation().getY(), prey
					.isDead())) {
				System.out.println(myDiet + ">" + prey.getMyDiet());
				System.out.println("will eat creature " + index);
				myWorld.getCreatureList().get(index).setDead();
				System.out.println("creature " + index + " is now dead "
						+ myWorld.getCreatureList().get(index).isDead());
				break;
			}
			System.out.println(index + " at " + prey.getMyLocation().getX()
					+ "," + prey.getMyLocation().getY() + " is not edible");
			index++;
		}
	}

	public boolean isEdible(int preySpecies, int preyDiet, int preyLocationX,
			int preyLocationY, boolean isDead) {
		if (!isDead()
				&& (mySpecies != preySpecies)
				&& (myDiet > preyDiet)
				&& ((preyLocationX == myLocation.getX() + 1)
						|| (preyLocationX == myLocation.getX() - 1) || (preyLocationX == myLocation
						.getX()))
				&& ((preyLocationY == myLocation.getY() + 1)
						|| (preyLocationY == myLocation.getY() - 1) || (preyLocationY == myLocation
						.getY()))) {
			return true;
		}
		return false;
	}

	public void reproduce(int currentSizeOfCreatureList) {
		for (int i = 0; i < currentSizeOfCreatureList; i++) {
			if (matable(myWorld.getCreatureList().get(i).getMySpecies(),
					myWorld.getCreatureList().get(i).getMyLocation().getX(),
					myWorld.getCreatureList().get(i).getMyLocation().getY())) {
				mate();
			}
		}
	}

	public boolean matable(int mateSpecies, int mateLocationX, int mateLocationY) {
		if ((mySpecies == mateSpecies)
				&& ((mateLocationX == myLocation.getX() + 1)
						|| (mateLocationX == myLocation.getX() - 1) || (mateLocationX == myLocation
						.getX()))
				&& ((mateLocationY == myLocation.getY() + 1)
						|| (mateLocationY == myLocation.getY() - 1) || (mateLocationY == myLocation
						.getY()))) {
			return true;
		}
		return false;
	}

	public void mate() {
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
			x2 = x + 1 * numbers[(int) (3 * Math.random())];
			y2 = y + 1 * numbers[(int) (3 * Math.random())];
			l.setX(x2);
			l.setY(y2);
		}
		if (!myWorld.isOccupied(l)) {
			myWorld.getCreatureList().add(new Cow(l, myWorld));
		}
	}

	public int[] numbers = { -1, 0, 1 };

	public int[] numbers2 = { -2, -1, 0, 1, 2 };

	private RandomGenerator rgen = RandomGenerator.getInstance();

}
