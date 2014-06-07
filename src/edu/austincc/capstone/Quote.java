package edu.austincc.capstone;

public class Quote {
	private int id;
	private String text;
	private String author;
	
	public Quote(int id, String text, String author) {
		super();
		this.id = id;
		this.text = text;
		this.author = author;
	}
	
	public Quote(String text, String author) {
		this(-1, text, author);
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getText() {
		return text;
	}

	public String getAuthor() {
		return author;
	}
	
}
