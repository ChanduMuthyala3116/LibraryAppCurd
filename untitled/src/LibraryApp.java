import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

public class LibraryApp {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully");
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        System.out.println("\n--- Book List ---");
        for (Book b : books) {
            String status = b.isIssued ? "Issued" : "Available";
            System.out.println("ID: " + b.id + ", Title: " + b.title +
                    ", Author: " + b.author +
                    ", Status: " + status);
        }
    }

    public static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) {
            if (b.id == id) {
                System.out.print("Enter new title: ");
                b.title = sc.nextLine();

                System.out.print("Enter new author: ");
                b.author = sc.nextLine();

                System.out.println("Book updated");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();

        boolean removed = books.removeIf(b -> b.id == id);

        if (removed) {
            System.out.println("Book deleted");
        } else {
            System.out.println("Book not found");
        }
    }

    public static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                String status = b.isIssued ? "Issued" : "Available";
                System.out.println("Found: " + b.title + " by " + b.author +
                        " (" + status + ")");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully");
                } else {
                    System.out.println("Book already issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully");
                } else {
                    System.out.println("Book was not issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void menu() {
        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Search Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: updateBook(); break;
                case 4: deleteBook(); break;
                case 5: searchBook(); break;
                case 6: issueBook(); break;
                case 7: returnBook(); break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}