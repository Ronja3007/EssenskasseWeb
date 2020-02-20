package logik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Savings {
	
	private static final String FILEUSER = "C:/Things/user.txt";
	private static final String FILEMENUE = "C:/Things/menue.txt";
	public static final String FILEPAYMENTIN = "C:/Things/paymentIN.txt";
	public static final String FILEPAYMENTOUT = "C:/Things/paymentOUT.txt";

	public Savings() {
		// TODO Auto-generated constructor stub
	}

	public static void savePayment(List<Payment> payments, String file) throws Exception{
		String txt = "";
		if(file.equals(FILEPAYMENTIN)) {
			txt = intoStringIN(payments);
		}else if(file.equals(FILEPAYMENTOUT)) {
			txt = intoStringOUT(payments);
		}else {
			throw new Exception("wrong file");
		}
		saveInFile(txt, file);
	}

	private static String intoStringOUT(List<Payment> payments) {
		String txt = "";
		for(Payment p : payments) {
			txt += p.getUserID() + "%" + p.getMenueID() + "%" + p.getDate() + "§"; 
		}
		return txt;
	}

	private static String intoStringIN(List<Payment> payments) {
		String txt = "";
		for(Payment p : payments) {
			txt += p.getUserID() + "%" + p.getDate() + "%" + p.getAmount() + "%" + p.getComment() + "§"; 
		}
		return txt;
	}

	public static void saveUser(List<User> user) throws Exception {
		String txt = "";
		for(User u : user) {
			txt += u.getID() + "%" + u.getFirstName() + "%" + u.getName() + "§";
		}
		saveInFile(txt, FILEUSER);
	}
	
	public static void saveMenue(List<FoodMenue> menue) throws Exception {
		String txt = "";
		for(FoodMenue m : menue) {
			txt += m.getID() + "%" + m.getDescription() + "%" + m.getCost() + "§";
		}
		saveInFile(txt, FILEMENUE);
	}
	
	private static void saveInFile(String txt, String file) throws Exception {
		try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(txt);
            out.close();
        } catch (IOException e) {
            throw new Exception("Error saving");
        }
	}
	
	public static List<User> readUser() throws Exception {
		List<User> user = new ArrayList<>();
		String read = readFromFile(FILEUSER);
		String[] usR = read.split("§");
		for(String s : usR) {
			String[] parts = s.split("%");
			user.add(new User(parts[0], parts[2], parts[1]));
		}
		return user;
	}
	
	public static List<FoodMenue> readMenue() throws Exception {
		List<FoodMenue> menues = new ArrayList<>();
		String read = readFromFile(FILEMENUE);
		String[] menS = read.split("§");
		for(String s : menS) {
			String[] parts = s.split("%");
			menues.add(new FoodMenue(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2])));
		}
		return menues;
	}
	
	public static List<Payment> readPayment(String file) throws Exception {
		List<Payment> payments = null;
		String read = readFromFile(file);
		if(file.equals(FILEPAYMENTIN)) {
			payments = getPaymentsIN(read);
		}else if(file.equals(FILEPAYMENTOUT)) {
			payments = getPaymentsOUT(read);
		}else {
			throw new Exception("error creating payments");
		}
		return payments;
	}
	
	private static List<Payment> getPaymentsIN(String read) throws Exception {
		List<Payment> payment = new ArrayList<>();
		String[] payMts = read.split("§");
		for(String s : payMts) {
			String[] parts = s.split("%");
			payment.add(new Payment(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
		}
		return payment;
	}

	private static List<Payment> getPaymentsOUT(String read) {
		List<Payment> payment = new ArrayList<>();
		String[] payMts = read.split("§");
		for(String s : payMts) {
			String[] parts = s.split("%");
			payment.add(new Payment(parts[0], Integer.parseInt(parts[1]), parts[2]));
		}
		return payment;
	}

	private static String readFromFile(String file) throws Exception {
		String txt = "";
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        txt =in.readLine();
	        in.close();
	    } catch (IOException e) {
	        throw new Exception("Error reading");
	    }
	    return txt;
	}
}
