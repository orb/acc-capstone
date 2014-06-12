package edu.austincc.capstone;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		if (username.equals("norman") && password.equals("strongpassword")) {
			return new User(username, password);
		} else {
			return null;
		}	
	}

}
