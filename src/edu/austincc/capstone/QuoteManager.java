package edu.austincc.capstone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class QuoteManager
        extends DataManager
{

    private DataSource ds;

    public QuoteManager(DataSource ds)
    {
        this.ds = ds;
    }

    public List<Quote> allQuotes()
    {
        List<Quote> quotes = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        try {
            connection = ds.getConnection();
            statement = connection.createStatement();
            results = statement.executeQuery("select * from quote");

            while (results.next()) {
                quotes.add(new Quote(results.getInt("id"),
                                     results.getString("text"),
                                     results.getString("author")));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            close(results);
            close(statement);
            close(connection);
        }

        return quotes;
    }

    public boolean newQuote(Quote quote)
    {
        boolean ok = false;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ds.getConnection();
            statement = connection.prepareStatement(
                    "insert into quote (text, author) values (?,?)");

            statement.setString(1, quote.getText());
            statement.setString(2, quote.getAuthor());

            statement.execute();
            ok = true;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            close(statement);
            close(connection);
        }

        return ok;
    }

    public Quote quoteByID(int quoteID)
    {
        Quote quote = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            connection = ds.getConnection();
            statement = connection.prepareStatement("select * from quote where id = ?");
            statement.setInt(1, quoteID);

            results = statement.executeQuery();

            if (results.next()) {
                quote = new Quote(results.getInt("id"),
                                  results.getString("text"),
                                  results.getString("author"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            close(results);
            close(statement);
            close(connection);
        }

        return quote;
    }

    public boolean updateQuote(Quote quote)
    {
        boolean ok = false;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ds.getConnection();
            statement = connection.prepareStatement(
                    "update quote set text=?, author=? where id=?");

            statement.setString(1, quote.getText());
            statement.setString(2, quote.getAuthor());
            statement.setInt(3, quote.getID());

            statement.execute();
            ok = true;

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ok;
    }

}
