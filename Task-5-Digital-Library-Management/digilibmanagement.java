package tasks;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String name;
    boolean issued;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.issued = false;
    }
}

public class digilibmanagement {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void adminMenu() {
        int ch;
        do {
            System.out.println("\n--- Admin Module ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Remove Book");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> removeBook();
            }
        } while (ch != 4);
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();
        books.add(new Book(id, name));
        System.out.println("Book added successfully ✅");
    }

    static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Book b : books) {
            if (b.id == id) {
                books.remove(b);
                found = true;
                System.out.println("Book removed ❌");
                break;
            }
        }
        if (!found)
            System.out.println("Book not found 🚫");
    }

    static void userMenu() {
        int ch;
        do {
            System.out.println("\n--- User Module ---");
            System.out.println("1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> viewBooks();
                case 2 -> issueBook();
                case 3 -> returnBook();
            }
        } while (ch != 4);
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && !b.issued) {
                b.issued = true;
                System.out.println("Book issued successfully 📕");
                return;
            }
        }
        System.out.println("Book not available 🚫");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && b.issued) {
                b.issued = false;
                System.out.println("Book returned successfully 📘");
                return;
            }
        }
        System.out.println("Invalid return ❌");
    }

    static void viewBooks() {
        System.out.println("\n--- Library Books ---");
        if (books.isEmpty()) {
            System.out.println("No books available 📭");
            return;
        }
        for (Book b : books) {
            System.out.println("ID: " + b.id +
                    " | Name: " + b.name +
                    " | Status: " + (b.issued ? "Issued ❌" : "Available ✅"));
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Digital Library Management =====");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> adminMenu();
                case 2 -> userMenu();
            }
        } while (choice != 3);

        System.out.println("Thank you for using Digital Library 📚");
    }
}
