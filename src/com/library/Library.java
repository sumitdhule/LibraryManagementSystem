package com.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books = new ArrayList<>();
	private static final String FILE_NAME = "data/book.dat";
	
	public Library() {
		loadBooks();
	}
	
	 // Add new book
    public void addBook(Book book) {
        books.add(book);
        saveBooks();
        System.out.println("✅ Book added successfully!");
    }
	
	 // View all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 No books available.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }
	
	//Search by title or author
	public void searchBook(String keyword) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(keyword) ||
                b.getAuthor().equalsIgnoreCase(keyword)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Book not found!");
        }
    }
	
	 // Issue book
    public void issueBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                b.issueBook();
                saveBooks();
                return;
            }
        }
        System.out.println("❌ Book not found with ISBN: " + isbn);
    }
	
    // Return book
    public void returnBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                b.returnBook();
                saveBooks();
                return;
            }
        }
        System.out.println("❌ Book not found with ISBN: " + isbn);
    }
	
	 // Save books to file
    private void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println(" Error saving books: " + e.getMessage());
        }
    }
	
    //Load books to files
	private void loadBooks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Error loading books: " + e.getMessage());
        }
    }
}
