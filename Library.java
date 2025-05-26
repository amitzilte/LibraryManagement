import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("📚 Welcome to Library Management System 📚");

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook(sc);
                case 2 -> displayBooks();
                case 3 -> searchBook(sc);
                case 4 -> issueBook(sc);
                case 5 -> returnBook(sc);
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    private static void addBook(Scanner sc) {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();
        books.add(new Book(title, author));
        System.out.println("✅ Book added successfully.");
    }

    private static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("⚠️ No books in the library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private static void searchBook(Scanner sc) {
        System.out.print("Enter book title to search: ");
        String title = sc.nextLine();
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("🔍 Found: " + b);
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }

    private static void issueBook(Scanner sc) {
        System.out.print("Enter title of book to issue: ");
        String title = sc.nextLine();
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.isIssued()) {
                    System.out.println("❌ Book is already issued.");
                } else {
                    b.issue();
                    System.out.println("✅ Book issued successfully.");
                }
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }

    private static void returnBook(Scanner sc) {
        System.out.print("Enter title of book to return: ");
        String title = sc.nextLine();
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (!b.isIssued()) {
                    System.out.println("⚠️ Book was not issued.");
                } else {
                    b.returnBook();
                    System.out.println("✅ Book returned successfully.");
                }
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }
}
