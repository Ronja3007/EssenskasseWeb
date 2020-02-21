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

	public User(String ID, String name, String firstName) throws Exception {
		if(valid(ID, firstName, name)) {
			this.ID = ID;
			this.name = name;
			this.firstName = firstName;	
			budget = 0;
		}
	}

	private boolean valid(String ID, String firstName, String name) throws Exception {
		char[] letters = ID.toCharArray(); 
		if(name.equals("")|| name.equals(" ")) {
			throw new Exception("Invalid name!");
		}
		if(firstName.equals("")|| firstName.equals(" ")) {
			throw new Exception("Invalid first name!");
		}
		if(ID.equals("")|| ID.equals(" ") || String.valueOf(letters[0]) != "u" || noNumber(letters)) {
			throw new Exception("Invalid ID!  uNNN");
		}
		return true;
	}

	private boolean noNumber(char[] letters) throws Exception {
		String txt = "";
		for (int i = 1; i < letters.length; i++) {
			txt+= String.valueOf(letters[i]);
		}
		try {
			Integer.parseInt(txt);
		}catch (NumberFormatException e) {
			return false;
		}
		return true;
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
