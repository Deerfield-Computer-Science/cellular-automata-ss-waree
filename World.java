import java.util.ArrayList;

public class World {

	private int width;

	private int height;

	private ArrayList<LifeForm> creatureList;

	public World(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.creatureList = new ArrayList<LifeForm>();
	}

	public void letTimePass() {

		makeNewCreatures();
		eatThings();
		creaturesGetOlder();
		purgeTheDead();
		moveCreatures();
	}

	public void eatThings() {
		int v=0;
		for (LifeForm l : creatureList) {
			System.out.println("creature "+v+" ");
			l.eat();
			v++;
			
		}
	}
	public void moveCreatures() {
		for (LifeForm l : creatureList) {
			l.move();
		}
	}

	public void makeNewCreatures() {
		int currentSizeOfCreatureList = creatureList.size();
		System.out.println("size of list is " + currentSizeOfCreatureList);
		for (int i = 0; i < currentSizeOfCreatureList; i++) {
			creatureList.get(i).reproduce(currentSizeOfCreatureList);
		}
	}

	public void purgeTheDead() {
		System.out.println("----------disposing bodies----------");
		int i = 0;
		while (i < creatureList.size()) {
			if (creatureList.get(i).isDead())
				creatureList.remove(i);
			else
				i++;
		}
	}

	public void creaturesGetOlder() {
		for (LifeForm l : creatureList) {
			l.age(1);
		}
	}

	public boolean isOccupied(Location l) {
		for (LifeForm f : creatureList) {
			if ((f.getMyLocation().getX() == l.getX())
					&& (f.getMyLocation().getY() == l.getY()))
				return true;
		}
		return false;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<LifeForm> getCreatureList() {
		return creatureList;
	}

	public void setCreatureList(ArrayList<LifeForm> creatureList) {
		this.creatureList = creatureList;
	}

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height
				+ ", creatureList=" + creatureList + "]";
	}
}
