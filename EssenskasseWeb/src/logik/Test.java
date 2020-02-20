package logik;

public class Test {

	public static void main(String[] args) {
		try {
			Management manage = new Management();
			manage.newMenue(1, "Salat", 123);
			manage.newMenue(2, "Kartoffeln", 122);
			manage.newMenue(3, "Nudeln", 130);
			manage.newUser("u105", "Maier", "Herbert");
			manage.newUser("u106", "Baum", "Dirk");
			showFood(manage);
			showUser(manage);
			
			manage.editUser("u105", "Bauer", "Maria");
			showUser(manage);
			
			manage.payINOUTbyPerson("u105", 200, "10.10.1100", "no comment", 0);
			showUser(manage);
			
			manage.payINOUTbyPerson("u105", -50, "02.02.2020", "abgehoben", 0);
			showUser(manage);
			
			showPaymentByUser(manage);
			
			manage.orderFood("u105", 3, "10.10.1020");
			showUser(manage);
			
			showPaymentOrder(manage);
			
			showPaymentByUser(manage);
			
			manage.payINOUTbyPerson("u105", -50, "02.02.3003", "zu viel", 0);
			showUser(manage);
			
			manage.removeMenue(3);
			showFood(manage);
			
			manage.editMenue(2, "Lachs", 250);
			showFood(manage);
			
			showPaymentOrder(manage);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private static void showUser(Management manage) {
		System.out.println("Userliste:");
		for(User u : manage.getUserList()) {
			System.out.println(u.getID() + " " + u.getFirstName() + " " + u.getName() + " " + u.getBudget() );
		}
		System.out.println();
	}
	
	private static void showFood(Management manage) {
		System.out.println("Menueliste:");
		for(FoodMenue f : manage.getMenueList()) {
			System.out.println(f.getID() + " " + f.getDescription() + " " + f.getCost());
		}
		System.out.println();
	}
	
	private static void showPaymentByUser(Management manage) {
		System.out.println("Ein-/Auszahlungen der Leute:");
		for (Payment p : manage.getHistorys().getPaymentHistoryIN()) {
			System.out.println(p.getDate() + " " + p.getUserID() + " " + p.getAmount() + " " + p.getComment());
		}
		System.out.println();
	}
	
	private static void showPaymentOrder(Management manage) {
		System.out.println("Bestellungen:");
		for (Payment p : manage.getHistorys().getPaymentHistoryOUT()) {
			System.out.println(p.getDate() + " " + p.getUserID() + " " + p.getMenueID());
		}
		System.out.println();
	}
	
}
