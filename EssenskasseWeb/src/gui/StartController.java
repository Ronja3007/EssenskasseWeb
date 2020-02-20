package gui;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logik.Datacontroller;
import logik.Payment;
import navi.Controller;

public class StartController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		List<Payment> lastOrders = Datacontroller.getInstance().getManage().getHistorys().getPaymentHistoryORDER();
	
		return null;
	}

}
