package doublylinkedlist.librarymanagementsystem;

public class LibraryManagementMain {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Add books
        library.addBookAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, false);
        library.addBookAtPosition(2, "1984", "George Orwell", "Dystopian", 103, true);

        // Display books
        library.displayBooksForward();
        library.displayBooksReverse();

        // Search books
        library.searchBookByTitle("1984");
        library.searchBookByAuthor("Harper Lee");

        // Update availability
        library.updateAvailabilityStatus(102, true);

        // Count books
        library.countBooks();

        // Remove a book
        library.removeBookById(101);
        library.displayBooksForward();
    }
}

