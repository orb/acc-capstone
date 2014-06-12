package edu.austincc.capstone;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/QuoteDB")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login    = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = validateUser(login, password);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/");
		} else {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
		}
	}

	private User validateUser(String username, String password) {
		UserManager manager = new UserManager(ds);
		User user = manager.userByNameAndPassword(username, password);
		return user;
	}
}









