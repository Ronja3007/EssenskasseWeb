package gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import navi.Controller;

public class NewUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		String userID = request.getParameter("userID");
		String firstName = request.getParameter("firstName");
		String name = request.getParameter("name");
		request.setAttribute("IDvalue", userID);
		request.setAttribute("FNValue", firstName);
		request.setAttribute("NValue", name);
		return null;
	}

}
