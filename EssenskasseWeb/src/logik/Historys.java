package logik;

import java.util.ArrayList;
import java.util.List;

public class Historys {
	private List<Payment> paymentHistoryIN;
    private List<Payment> paymentHistoryORDER;
    private Balance balance;
    
    public Historys() {
    	balance = new Balance();
    	paymentHistoryIN = new ArrayList<>();
    	paymentHistoryORDER = new ArrayList<>();
    }
    
	public List<Payment> getPaymentHistoryIN() {
		return paymentHistoryIN;
	}
	public List<Payment> getPaymentHistoryOUT() {
		return paymentHistoryORDER;
	}
	
	public void addPaymentIN(Payment p) throws Exception {
		paymentHistoryIN.add(p);
		balance.pay(p.getAmount());
		Savings.savePayment(paymentHistoryIN, Savings.FILEPAYMENTIN);
	}
	
	public void addPaymentOrder(Payment p) throws Exception {
		paymentHistoryORDER.add(p);
		balance.pay(-p.getAmount());
		Savings.savePayment(paymentHistoryORDER, Savings.FILEPAYMENTOUT);
	}
}
