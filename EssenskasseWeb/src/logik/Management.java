package logik;

import java.util.ArrayList;
import java.util.List;

public class Management {
	private List<User> userList;
	private List<FoodMenue> menueList;
	private Historys historys;
	
	public Management() {
		historys = new Historys();
		userList = new ArrayList<>();
		menueList = new ArrayList<>();
	}
	
	public void payINOUTbyPerson (String userID, int cent, String date, String comment, int order) throws Exception {
		for(User u : userList) {
			if(u.getID().equals(userID)) {
				int budget = u.getBudget();
				u.setBudget(budget + cent);
				if(order == 0) {
					historys.addPaymentIN(new Payment(userID, date, cent, comment));
				}
			}
		}
	}
	
	public void orderFood(String userID, int menueID, String date) throws Exception {
		historys.addPaymentOrder(new Payment(userID, menueID, date));
		FoodMenue menue = getMenue(menueID); 
		payINOUTbyPerson(userID, -menue.getCost(), null, null, 1);
	}
	
	private FoodMenue getMenue(int menueID) {
		for (FoodMenue f : menueList) {
			if(f.getID() == menueID) {
				return f;
			}
		}
		return null;
	}

	public Historys getHistorys() {
		return historys;
	}

	public void editUser(String ID, String name, String firstName) throws Exception {
		for(User u : userList) {
			if(u.getID().equals(ID)) {
				u.editUser(name, firstName);
			}
		}
		saveUser(userList);
	}
	
	public void removeUser(String ID) throws Exception {
		for(User u : userList) {
			if(u.getID().equals(ID)) {
				userList.remove(u);
				break;
			}
		}
		saveUser(userList);
	}
	
	public void newUser(String ID, String name, String firstName) throws Exception {
		userList.add(new User(ID, name, firstName));
		saveUser(userList);
	}
	
	public void editMenue(int menueID, String description, int cost) throws Exception {
		for(FoodMenue f : menueList) {
			if(f.getID() == menueID) {
				f.editMenue(description, cost);
				break;
			}
		}
		saveMenue(menueList);
	}

	public void removeMenue(int menueID) throws Exception {
		for(FoodMenue f : menueList) {
			if(f.getID() == menueID) {
				menueList.remove(f);
				break;
			}
		}
		saveMenue(menueList);
	}
	
	public void newMenue(int menueID, String description, int cost) throws Exception {
		menueList.add(new FoodMenue(menueID, description, cost));
		saveMenue(menueList);
	}
	
	private void saveUser(List<User> user) throws Exception {
		Savings.saveUser(user);
	}
	
	private void saveMenue(List<FoodMenue> menue) throws Exception {
		Savings.saveMenue(menue);
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public List<FoodMenue> getMenueList() {
		return menueList;
	}
}
