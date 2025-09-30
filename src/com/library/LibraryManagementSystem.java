package com.library;

import java.util.Scanner;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Library library = new Library();
		
		
		while(true) {
			System.out.println("\n--- Library Menu ---");
			System.out.println("1. Add Book");
			System.out.println("2. View Book");
			System.out.println("3. Search Book");
			System.out.println("4. Issue Book");
			System.out.println("5. Return Book");
			System.out.println("6. Exit");
			System.out.println("Enter choice: ");
			
			int choice;
			try {
				choice = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e) {				
			System.out.println("Invalid input! Enter a number.");
			continue;
			}
			
			switch(choice){
			case 1:
				System.out.println("Enter title: ");
				String title = sc.nextLine();
				System.out.println("Enter Author: ");
				String author = sc.nextLine();
				System.out.println("Enter ISBN: ");
				String isbn = sc.nextLine();
				System.out.println("Enter Copies: ");
				int copies;
				try {
					copies = Integer.parseInt(sc.nextLine());
				}catch(Exception e) {
					System.out.println("Invalid number of copies.");
					break;
				}
				library.addBook(new Book(title,author,isbn,copies));
				break;
			
			case 2:
				library.viewBooks();
				break;
			
			case 3:
				System.out.println("Enter Title/Author to search: ");
				String keyword = sc.nextLine();
				library.searchBook(keyword);
				break;
				
			case 4:
				System.out.println("Enter ISBN to issue: ");
				String issueIsbn = sc.nextLine();
				library.issueBook(issueIsbn);
				break;
			
			case 5: 
				System.out.println("Enter ISBN to return: ");
				String returnIsbn = sc.nextLine();
				library.returnBook(returnIsbn);
				break;
				
			case 6:
				System.out.println("Exiting...Thank You.");
				sc.close();
				System.exit(0);
			
			default:
				System.out.println("Invalid choice! Try again later.");
			}
		}
		
	}
}
