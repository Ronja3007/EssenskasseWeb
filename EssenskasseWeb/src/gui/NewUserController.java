package gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logik.Datacontroller;
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
		if(userID != null && firstName != null && name != null) {
			Datacontroller.getInstance().getManage().newUser(userID, name, firstName);
			System.out.println(userID + " " + firstName + " " + name);
		}else {
			throw new Exception("Please fill in all fields!");
		}
		return null;
	}
}