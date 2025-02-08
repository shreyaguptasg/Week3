package doublylinkedlist.librarymanagementsystem;

class LibraryManagement {
    private Book head = null;
    private Book tail = null;
    private int bookCount = 0;

    // Add a book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    // Add a book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    // Add a book at a specific position
    public void addBookAtPosition(int position, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (position < 1 || position > bookCount + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        if (position == bookCount + 1) {
            addBookAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int count = 1;
        while (count < position - 1) {
            temp = temp.next;
            count++;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
        bookCount++;
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            bookCount--;
            System.out.println("Book with ID " + bookId + " removed.");
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found.");
        } else {
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                tail = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
            bookCount--;
            System.out.println("Book with ID " + bookId + " removed.");
        }
    }

    // Search for a book by Title
    public void searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + getBookDetails(temp));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with title \"" + title + "\" not found.");
    }

    // Search for a book by Author
    public void searchBookByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book found: " + getBookDetails(temp));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book by author \"" + author + "\" not found.");
    }

    // Update a book’s Availability Status
    public void updateAvailabilityStatus(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                System.out.println("Availability status updated for Book ID " + bookId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Books in forward order:");
        Book temp = head;
        while (temp != null) {
            System.out.println(getBookDetails(temp));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Books in reverse order:");
        Book temp = tail;
        while (temp != null) {
            System.out.println(getBookDetails(temp));
            temp = temp.prev;
        }
    }

    // Count the total number of books
    public void countBooks() {
        System.out.println("Total number of books: " + bookCount);
    }

    // Helper method to get book details as a string
    private String getBookDetails(Book book) {
        return "Title: " + book.title + ", Author: " + book.author + ", Genre: " + book.genre +
                ", Book ID: " + book.bookId + ", Available: " + (book.isAvailable ? "Yes" : "No");
    }
}
