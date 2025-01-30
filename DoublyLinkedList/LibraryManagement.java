package DoublyLinkedList;

class LibraryManagement {

    // Book Node (Doubly Linked List)
    static class BookNode {
        int bookID;
        String title;
        String author;
        String genre;
        boolean available;
        BookNode next;
        BookNode prev;

        BookNode(int bookID, String title, String author, String genre, boolean available) {
            this.bookID = bookID;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.available = available;
            this.next = null;
            this.prev = null;
        }
    }

    private BookNode head = null;
    private BookNode tail = null;
    private int totalBooks = 0;

    // Add a book at the beginning
    public void addBookAtBeginning(int bookID, String title, String author, String genre, boolean available) {
        BookNode newBook = new BookNode(bookID, title, author, genre, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        totalBooks++;
        System.out.println("✅ Book added at the beginning: " + title);
    }

    // Add a book at the end
    public void addBookAtEnd(int bookID, String title, String author, String genre, boolean available) {
        BookNode newBook = new BookNode(bookID, title, author, genre, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        totalBooks++;
        System.out.println("✅ Book added at the end: " + title);
    }

    // Add a book at a specific position (1-based index)
    public void addBookAtPosition(int bookID, String title, String author, String genre, boolean available, int position) {
        if (position <= 1) {
            addBookAtBeginning(bookID, title, author, genre, available);
            return;
        }

        BookNode newBook = new BookNode(bookID, title, author, genre, available);
        BookNode temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addBookAtEnd(bookID, title, author, genre, available);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
            totalBooks++;
            System.out.println("✅ Book added at position " + position + ": " + title);
        }
    }

    // Remove a book by Book ID
    public void removeBook(int bookID) {
        if (head == null) {
            System.out.println("❌ No books in the library.");
            return;
        }

        BookNode temp = head;

        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("❌ Book not found with ID: " + bookID);
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        totalBooks--;
        System.out.println("✅ Book removed: " + temp.title);
    }

    // Search for a book by Title or Author
    public void searchBook(String titleOrAuthor) {
        BookNode temp = head;
        boolean found = false;

        System.out.println("\n🔍 Search Results:");
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(titleOrAuthor) || temp.author.equalsIgnoreCase(titleOrAuthor)) {
                System.out.println(temp.bookID + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Not Available"));
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("❌ No books found for search: " + titleOrAuthor);
        }
    }

    // Update a book's Availability Status
    public void updateBookAvailability(int bookID, boolean newStatus) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.available = newStatus;
                System.out.println("✅ Book availability updated: " + temp.title + " -> " + (newStatus ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }

        System.out.println("❌ Book not found with ID: " + bookID);
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("❌ No books in the library.");
            return;
        }

        BookNode temp = head;
        System.out.println("\n📚 Library Book List (Forward):");
        while (temp != null) {
            System.out.println(temp.bookID + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("❌ No books in the library.");
            return;
        }

        BookNode temp = tail;
        System.out.println("\n📚 Library Book List (Reverse):");
        while (temp != null) {
            System.out.println(temp.bookID + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    // Count total books
    public int countBooks() {
        return totalBooks;
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addBookAtEnd(101, "The Alchemist", "Paulo Coelho", "Fiction", true);
        library.addBookAtEnd(102, "1984", "George Orwell", "Dystopian", true);
        library.addBookAtBeginning(103, "To Kill a Mockingbird", "Harper Lee", "Classic", false);
        library.addBookAtPosition(104, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", true, 2);
        library.addBookAtPosition(105, "Moby Dick", "Herman Melville", "Adventure", true, 1);

        library.displayBooksForward();
        library.displayBooksReverse();

        library.searchBook("George Orwell");

        library.updateBookAvailability(102, false);
        library.displayBooksForward();

        library.removeBook(104);
        library.displayBooksForward();

        System.out.println("\n📖 Total Books in Library: " + library.countBooks());
    }
}

