import java.awt.Color;
import java.util.ArrayList;

public abstract class LifeForm {
	
	protected World myWorld;
	protected int myLifeSpan;
	protected Location myLocation;
	protected Color myColor;
	protected int myAge;
	protected boolean alive;
	protected int myDiet;
	protected int mySpecies;
	
	// lifeform constructors
	public LifeForm(int myLifeSpan, Location myLocation, Color myColor, World myWorld, int myDiet, int mySpecies) {
		super();
		this.myLifeSpan = myLifeSpan;
		this.myLocation = myLocation;
		this.myColor = myColor;
		this.myWorld = myWorld;
		this.myDiet = myDiet;
		this.mySpecies = mySpecies;
		alive = true;
	}
	
	public LifeForm(Location myLocation, World myWorld) {
		super();
		this.myWorld = myWorld;
		this.myLocation = myLocation;
		alive = true;
	}
	
	
	/* all the basic lifeform functions
	 * 		getOlder
	 * 		reproduce
	 */
	
	// we all age the same, time clicks forward and we all age one unit of time
	public void age(int time){
		myAge+=time;
		if (myAge>myLifeSpan)
			alive=false;
	}
	
	public abstract void move();
	
	public abstract void eat();
	
	// to be alive you have to be able to reproduce....
	public abstract void reproduce(int currentSizeOfCreatureList);
	
	public boolean isDead(){
		return !alive;
	}
	
	// getter and setters (aka accessors and mutators)
	
	public int getMySpecies(){
		return mySpecies;
	}
	
	public void setMySpecies(int mySpecies){
		this.mySpecies = mySpecies;
	}
	
	public void setDead(){
		this.alive=false;
	}
	
	public int getMyDiet(){
		return myDiet;
	}
	
	public void setMyDiet(int myDiet){
		this.myDiet = myDiet;
	}
	
	public int getMyLifeSpan() {
		return myLifeSpan;
	}
	
	public void setMyLifeSpan(int myLifeSpan) {
		this.myLifeSpan = myLifeSpan;
	}
	
	public Location getMyLocation() {
		return myLocation;
	}
	
	public void setMyLocation(Location myLocation) {
		this.myLocation = myLocation;
	}
	
	public Color getMyColor() {
		return myColor;
	}
	
	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}
	
	public int getAge() {
		return myAge;
	}

	public void setAge(int age) {
		this.myAge = age;
	}
	
	@Override
	public String toString() {
		return "LifeForm [myLifeSpan=" + myLifeSpan + ", myLocation="
				+ myLocation + ", myColor=" + myColor + "]";
	}
}
