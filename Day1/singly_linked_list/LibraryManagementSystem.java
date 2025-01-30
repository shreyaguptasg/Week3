package Day1.singly_linked_list;

class Book {
    String title;
    String author;
    String genre;
    int id;
    boolean status;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int id, boolean status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.status = status;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagementSystem {
    Book head;
    Book tail;

    // Add a book to the first node
    public void addFirst(String title, String author, String genre, int id, boolean status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        newBook.next = head;
        head.prev = newBook;
        head = newBook;
    }

    // Add a book to the last node
    public void addLast(String title, String author, String genre, int id, boolean status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (tail == null) {
            head = tail = newBook;
            return;
        }
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    // Add book at a specific index
    public void addSpecific(int position, String title, String author, String genre, int id, boolean status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (position == 1) {
            addFirst(title, author, genre, id, status);
            return;
        }
        Book current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Out of bound ");
            return;
        }
        newBook.next = current.next;
        if (current.next != null) {
            current.next.prev = newBook;
        }
        current.next = newBook;
        newBook.prev = current;

        if (newBook.next == null) {
            tail = newBook;
        }
    }

    // Remove a book by Book ID
    public void removeByBookId(int id) {
        Book current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.id == id) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            System.out.println("Book with ID " + id + " has been removed");
            return;
        }
        while (current != null && current.id != id) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found");
            return;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
            System.out.println("Book with ID " + id + " has been removed");
        }
    }

    // Search for a book by Book Title or Author
    public void searchByTitleOrAuthor(String searchQuery) {
        if (head == null) {
            System.out.println("Library is empty");
            return;
        }
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(searchQuery) || current.author.equalsIgnoreCase(searchQuery)) {
                System.out.println("Book found: " + current.title + " by " + current.author);
                return;
            }
            current = current.next;
        }
        System.out.println("No book found with title or author: " + searchQuery);
    }

    // Update a book’s Availability Status based on Book Title
    public void updateStatusByTitle(String title, boolean isAvailable) {
        if (head == null) {
            System.out.println("Library is empty");
            return;
        }
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.status = isAvailable; // status represents availability
                System.out.println("Availability of '" + title + "' updated to " + (isAvailable ? "Available" : "Not Available"));
                return;
            }
            current = current.next;
        }
        System.out.println("Book with title '" + title + "' not found");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        Book current = head;
        while (current != null) {
            System.out.println(current.title + " | " + current.author + " | " + current.genre + " | " + (current.status ? "Available" : "Not Available"));
            current = current.next;
        }
        System.out.println("End of List");
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println(current.title + " | " + current.author + " | " + current.genre + " | " + (current.status ? "Available" : "Not Available"));
            current = current.prev;
        }
        System.out.println("Start of List");
    }

    // Count the total number of books in the library
    public int countTotalBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books in the library: " + count);
        return count;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books
        library.addFirst("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addLast("To Kill a Mockingbird", "Harper Lee", "Classic", 102, true);
        library.addLast("1984", "George Orwell", "Dystopian", 103, false);
        library.addSpecific(2, "Moby Dick", "Herman Melville", "Adventure", 104, true);

        // Display books in forward and reverse order
        System.out.println("Books in forward order:");
        library.displayBooksForward();

        System.out.println("Books in reverse order:");
        library.displayBooksReverse();

        // Search for books
        System.out.println("\nSearching for '1984' by title:");
        library.searchByTitleOrAuthor("1984");

        System.out.println("\nSearching for books by 'Harper Lee':");
        library.searchByTitleOrAuthor("Harper Lee");

        // Update book availability
        System.out.println("\nUpdating availability of '1984':");
        library.updateStatusByTitle("1984", true);

        // Remove a book
        System.out.println("\nRemoving book with ID 104:");
        library.removeByBookId(104);

        // Display books again after removal
        System.out.println("\nBooks in forward order after removal:");
        library.displayBooksForward();

        // Count total books
        System.out.println("\nCounting total books in library:");
        library.countTotalBooks();
    }
}
