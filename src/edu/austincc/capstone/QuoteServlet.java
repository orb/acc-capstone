package edu.austincc.capstone;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class QuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Quote quote1() {
		return new Quote("Logic will get you from A to B. Imagination will take you everywhere.",
				"Albert Einstein");
	}
	
	public Quote quote2() {
		return new Quote("This is a quote", "Norman");
	}
	
	public Quote quote3() {
		return new Quote("I like turtles", "Some kid on the internet");
	}
	
	public Quote[] allQuotes() {
		return new Quote[] {quote1(), quote2(), quote3()};
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request.setAttribute("quotes", allQuotes());
		request.setAttribute("now", new Date());

		request.getRequestDispatcher("/WEB-INF/quote.jsp").forward(request, response);
	}
}
















