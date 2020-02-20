package logik;

public class FoodMenue {
	private int ID;
	private String description;
	private int cost;
	
	public FoodMenue(int ID, String description, int cost) {
		this.ID = ID;
		this.description = description;
		this.cost = cost;
	}
	
	public int getID() {
		return ID;
	}
	public String getDescription() {
		return description;
	}
	public int getCost() {
		return cost;
	}
	
	public void editMenue(String newDescription, int newCost) {
		this.description = newDescription;
		this.cost = newCost;
	}
}
