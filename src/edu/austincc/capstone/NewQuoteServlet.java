package edu.austincc.capstone;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/new")
public class NewQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/QuoteDB")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/newquote.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String text   = request.getParameter("text");
		String author = request.getParameter("author");
				
		System.out.println("POST " + text + " -> " + author);
		
		Quote quote = new Quote(text, author);
		QuoteManager manager = new QuoteManager(ds);
		
		if (manager.newQuote(quote)) {
			//success
			response.sendRedirect("/");
		} else {
			//fail
			request.getRequestDispatcher("/WEB-INF/newquote.jsp").forward(request, response);
		}
	}
}













