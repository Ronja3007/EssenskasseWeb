package gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import navi.Controller;

public class NewMenueController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		String menueNR = request.getParameter("menueNR");
		String menueDescription = request.getParameter("menueDescription");
		String menueCost = request.getParameter("menueCost");
		request.setAttribute("NRvalue", menueNR);
		request.setAttribute("DescrValue", menueDescription);
		request.setAttribute("CostValue", menueCost);
		return null;
	}

}
