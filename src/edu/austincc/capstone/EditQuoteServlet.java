package edu.austincc.capstone;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/edit")
public class EditQuoteServlet
        extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/QuoteDB")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {
        Quote quote = null;

        try {
            QuoteManager manager = new QuoteManager(ds);

            int quoteID = Integer.parseInt(request.getParameter("id"));
            quote = manager.quoteByID(quoteID);
        } catch (NumberFormatException e) {
        }

        if (quote == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            request.setAttribute("quote", quote);
            request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request,
                                                                      response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        String text = request.getParameter("text");
        String author = request.getParameter("author");

        Quote quote = new Quote(id, text, author);
        QuoteManager manager = new QuoteManager(ds);

        manager.updateQuote(quote);
        response.sendRedirect("/");
    }
}
