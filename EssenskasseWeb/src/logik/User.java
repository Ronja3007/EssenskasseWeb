package logik;

public class User {
	private String ID;
	private String name;
	private String firstName;
	private int budget;
	
	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public User(String ID, String name, String firstName) {
		this.ID = ID;
		this.name = name;
		this.firstName = firstName;	
		budget = 0;
	}

	public void editUser(String newFirstName, String newName) {
		this.name = newName;
		this.firstName = newFirstName;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFirstName() {
		return firstName;
	}
}
