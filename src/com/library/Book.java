package com.library;

import java.io.Serializable;

public class Book implements Serializable{

	private String title;
	private String author;
	private String isbn;
	private int copies;
	
	public Book(String title, String author, String isbn, int copies) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.copies = copies;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getCopies() {
		return copies;
	}

	public void issueBook() {
		if(copies > 0) {
			copies--;
			System.out.println("Book issued successfully.");
		}else {
			System.out.println("sorry, no copies available.");
		}
	}
	
	public void returnBook() {
		copies++;
		System.out.println("Book returned successfully.");
	}
	
	
	@Override
	public String toString() {
		return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Copies: " + copies;
	}
	
	
	
}
