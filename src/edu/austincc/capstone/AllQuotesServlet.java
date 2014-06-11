package edu.austincc.capstone;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/list")
public class AllQuotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/QuoteDB")
	DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		QuoteManager manager = new QuoteManager(ds);
		
		request.setAttribute("quotes", manager.allQuotes());
		request.setAttribute("now", new Date());

		request.getRequestDispatcher("/WEB-INF/quote.jsp").forward(request, response);
	}
}
