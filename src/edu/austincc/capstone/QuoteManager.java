package edu.austincc.capstone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class QuoteManager {
	
	private DataSource ds;

	public QuoteManager(DataSource ds) {
		this.ds = ds;
	}

	public List<Quote> allQuotes() {
		List<Quote> quotes = new ArrayList<Quote>();
		
		try {
		    Connection connection = ds.getConnection();
		    Statement statement = connection.createStatement();
		    ResultSet results = statement.executeQuery("select * from quote");
		    
			while (results.next()) {
				quotes.add(new Quote(results.getString("text"), results.getString("author")));
			}
		    
		    results.close();
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return quotes;
	}

	public boolean newQuote(Quote quote) {
		boolean ok = false;
		
		try {
		    Connection connection = ds.getConnection();
		    PreparedStatement statement = connection.prepareStatement(
		    		"insert into quote (text, author) values (?,?)");
		   
		    statement.setString(1, quote.getText());
		    statement.setString(2, quote.getAuthor());
		    
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







