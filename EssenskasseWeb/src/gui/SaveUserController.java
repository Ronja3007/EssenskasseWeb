package gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import navi.Controller;

public class SaveUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		// TODO Auto-generated method stub
		
		new UserController().execute(request, response, message);
		return "/users";
	}

}
