package navi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gui.PayController;
import gui.UserController;
import gui.MenueController;
import gui.NewMenueController;
import gui.NewUserController;
import gui.OrderController;

@WebServlet(value="*.do", loadOnStartup=1)
public class FrontController extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	private static final String LAYOUT_SEITE = "/WEB-INF/jsp/template.jsp";
	private Map<String, Controller> controller;
	
	@Override
	public void init() throws ServletException {
		controller = new HashMap<String, Controller>();
		controller.put("/orders", new OrderController());
		controller.put("/payIN", new PayController());
		controller.put("/users", new UserController());
		controller.put("/newUser", new NewUserController());
		controller.put("/menues", new MenueController());
		controller.put("/newMenue", new NewMenueController());
		
		System.out.println("Frontcontroller initialisiert");
		System.out.println(LAYOUT_SEITE);
	}
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		StringBuffer meldung = new StringBuffer();
		// /mvc/test/eins.do ohne /mvc und .do ==> /test/eins
		String navi = request.getRequestURI().substring( // /mvc/test/eins.do
				request.getContextPath().length(),		// /mvc
				request.getRequestURI().length() -3);	// .do
		
		System.out.println("REQUESTED: " + navi + "----------------------******************------------------------");
		
		if(request.getMethod().toString().equals("GET")){
			navi = "/orders";
		}
		
		try
		{
			Controller c = controller.get(navi);
			if (c != null)
			{
				String neueNavi = c.execute(request, response, meldung);
				if (neueNavi != null) {
					navi = neueNavi;
					System.out.println("NEU: " + navi + "----------------------******************------------------------");
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			meldung.append(e.getMessage());
//			e.printStackTrace();
		}

		request.setAttribute("notifications", meldung.toString());
		String requestedUrl = "/WEB-INF/jsp" + navi + ".jsp";
		
		if (isValidUrl(navi)) {
			request.setAttribute("url", requestedUrl);
		} else {
			request.setAttribute("url", "/WEB-INF/jsp/error/error.jsp");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(LAYOUT_SEITE);
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
	
	private boolean isValidUrl(String url) {
		if (controller.get(url) != null) {
			return true;
		}
		return false;
	}
}