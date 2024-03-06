package test.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Visitor> visitors_list = new ArrayList<Visitor>();
	private static DBHelper db;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public testServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		visitors_list.clear();
		Visitor.nextId = 0;
		db = new DBHelper("root", "", "jdbc:mysql://localhost:3306/test");
		try {
			db.connect();
			System.out.println("Connected to the database");
		} catch (SQLException e) {
			System.out.println("Error connecting to the database (" + e.getMessage() + ")");
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = null;
		String path = request.getRequestURI();
		String route = path.substring(path.lastIndexOf("/") + 1);
		if (request.getParameter("request") != null) {
			switch (request.getParameter("request")) {
			case "Reset":
				visitors_list.clear();
				Visitor.nextId = 0;
				response.sendRedirect("/test/visitor");
				break;
			case "Delete":
				while (visitors_list.removeIf(v -> v.getId() == Integer.parseInt(request.getParameter("id"))));
				response.sendRedirect("/test/visitor");
				break;
			case "Login":
                response.sendRedirect("/test/home");
				break;
			case "Register":
				response.sendRedirect("/test/home");
				break;
			}
		} else {
			visitors_list.add(new Visitor(request.getRemoteAddr(), request.getRemotePort(),LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")), path));
			switch (route) {
			case "users":
				try {
					request.setAttribute("user_list", db.getAllUsers());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				disp = request.getRequestDispatcher("/WEB-INF/users.jsp");
				break;
			case "login":
				disp = request.getRequestDispatcher("/WEB-INF/login.jsp");
				break;
			case "visitor":
			case "counter":
			case "count":
				request.setAttribute("visitors_list", visitors_list);
				disp = request.getRequestDispatcher("/WEB-INF/visitor.jsp");
				break;
			default:
				disp = request.getRequestDispatcher("/WEB-INF/home.jsp");
				break;
			}
			disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
