package logik;

public class Payment {
	private String userID;
	private String date;
	private int amount;
	private String comment;
	private int menueID;
	
	
	public Payment(String userID, String date, int amount, String comment) throws Exception { //IN
		if(validDate(date)) {
			this.userID = userID;
			this.date = date;
			this.amount = amount;
			this.comment = comment;
			
		}
	}
	
	private boolean validDate(String date) throws Exception {
		try {
			char[] letters = date.toCharArray(); 
			int day = Integer.parseInt(String.valueOf(letters[0]) + String.valueOf(letters[1]));
			int month = Integer.parseInt(String.valueOf(letters[3]) + String.valueOf(letters[4]));
			int year = Integer.parseInt(String.valueOf(letters[6]) + String.valueOf(letters[7]) + String.valueOf(letters[8]) + String.valueOf(letters[9]));
			if(day <= 31 && day > 0 && month > 0 && month <= 12 && year > 0) {
				return true;
			}
		} catch (NumberFormatException e) {
			throw new Exception("invalid date");
		}
		return false;
	}

	public Payment(String userID, int menueID, String date) {  //OUT
		this.userID = userID;
		this.menueID = menueID;
		this.date = date;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getDate() {
		return date;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getComment() {
		return comment;
	}

	public int getMenueID() {
		return menueID;
	}

}
