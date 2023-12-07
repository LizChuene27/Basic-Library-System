import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibrarySystem {
 private Map<String, Book> library;

  public LibrarySystem() {
  library = new HashMap<>();
  }

  public void run() {
  Scanner scanner = new Scanner(System.in);
  int choice;

  do {
  System.out.println("Welcome to your online library");
  System.out.println("1. Add books to the library");
  System.out.println("2. Borrow books from library");
  System.out.println("3. Return books to library");
  System.out.println("4. Exit the library");
  System.out.print("What would you like to do today: ");
  choice = scanner.nextInt();
  scanner.nextLine();

  switch (choice) {
  case 1:
  addBooks(scanner);
  break;
  case 2:
  borrowBooks(scanner);
  break;
  case 3:
  returnBooks(scanner);
  break;
  case 4:
  System.out.println("Leaving library...");
  break;
  default:
  System.out.println("Invalid. Please try again.");
  }

  System.out.println();

  } while (choice != 4);

  }

  private void addBooks(Scanner scanner) {
  System.out.print("What's the title of the book you would like to add to library?: ");
  String title = scanner.nextLine();
  System.out.print("Who is the author of the book?: ");
  String author = scanner.nextLine();
  System.out.print("How many of those books would you like to add: ");
  int quantity = scanner.nextInt();
  scanner.nextLine();

  if (library.containsKey(title)) {
  Book book = library.get(title);
  book.setQuantity(book.getQuantity() + quantity);
  System.out.println("Quantity updated for book: " + title);

  } else {

  Book book = new Book(title, author, quantity);
  library.put(title, book);
  System.out.println("Your book has been added to the library: " + title);

  }

  }

  private void borrowBooks(Scanner scanner) {

  System.out.print("What's the title of the book you would like to borrow?: ");
  String title = scanner.nextLine();
  System.out.print("How many of the books would you like to borrow?: ");
  int quantity = scanner.nextInt();
  scanner.nextLine();

 

  if (library.containsKey(title)) {
  Book book = library.get(title);
  if (book.getQuantity() >= quantity) {
  book.setQuantity(book.getQuantity() - quantity);
  System.out.println("You have borrowed " + quantity + " books: " + title);

  } else {
  System.out.println("There aren't enough books at the moment, can't borrow " + quantity + " books: " + title);
  }

  } else {
  System.out.println("Book is not in this library: " + title);
  }

  }


  private void returnBooks(Scanner scanner) {
  System.out.print("What is the title of the book you are returning?: ");
  String title = scanner.nextLine();
  System.out.print("How many books are you returning?: ");
  int quantity = scanner.nextInt();
  scanner.nextLine();

  if (library.containsKey(title)) {
  Book book = library.get(title);
  book.setQuantity(book.getQuantity() + quantity);
  System.out.println("You have returned " + quantity + " books: " + title);
  } else {
  System.out.println("Book is not in this library: " + title);
  }

  }
  public static void main(String[] args) {
  LibrarySystem librarySystem = new LibrarySystem();
  librarySystem.run();
  }

}

class Book {
  private String title;
  private String author;
  private int quantity;

  public Book(String title, String author, int quantity) {
  this.title = title;
  this.author = author;
  this.quantity = quantity;
  }

 

  public String getTitle() {
  return title;

  }

  public String getAuthor() {
  return author;
  }

  public int getQuantity() {
  return quantity;
  }

  public void setQuantity(int quantity) {
  this.quantity = quantity;
  }

}