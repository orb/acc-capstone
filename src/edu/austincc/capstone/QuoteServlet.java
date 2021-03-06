package edu.austincc.capstone;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("")
public class QuoteServlet
        extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/QuoteDB")
    DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        QuoteManager manager = new QuoteManager(ds);

        List<Quote> quotes = manager.allQuotes();

        Random random = new Random();

        Quote randomQuote = quotes.get(random.nextInt(quotes.size()));

        request.setAttribute("quotes", quotes);
        request.setAttribute("quote", randomQuote);
        request.setAttribute("now", new Date());

        request.getRequestDispatcher("/WEB-INF/random.jsp").forward(request, response);
    }
}
