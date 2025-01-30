package DoublyLinkedList;

class MovieManagement {

    // Movie Node (Doubly Linked List)
    static class MovieNode {
        String title;
        String director;
        int year;
        double rating;
        MovieNode next;
        MovieNode prev;

        MovieNode(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    private MovieNode head = null;
    private MovieNode tail = null;

    // Add movie at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("✅ Movie added at the beginning: " + title);
    }

    // Add movie at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("✅ Movie added at the end: " + title);
    }

    // Add movie at a specific position (1-based index)
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newMovie = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addMovieAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
            System.out.println("✅ Movie added at position " + position + ": " + title);
        }
    }

    // Remove a movie by title
    public void removeMovie(String title) {
        if (head == null) {
            System.out.println("❌ No movies in the list.");
            return;
        }

        MovieNode temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("❌ Movie not found: " + title);
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

        System.out.println("✅ Movie removed: " + title);
    }

    // Search for a movie by director or rating
    public void searchMovie(String directorOrRating) {
        MovieNode temp = head;
        boolean found = false;

        System.out.println("\n🔍 Search Results:");
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(directorOrRating) || String.valueOf(temp.rating).equals(directorOrRating)) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("❌ No movies found for search: " + directorOrRating);
        }
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("❌ No movies in the list.");
            return;
        }

        MovieNode temp = head;
        System.out.println("\n🎬 Movie List (Forward):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("❌ No movies in the list.");
            return;
        }

        MovieNode temp = tail;
        System.out.println("\n🎬 Movie List (Reverse):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update movie rating by title
    public void updateMovieRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("✅ Movie rating updated: " + title + " -> " + newRating);
                return;
            }
            temp = temp.next;
        }

        System.out.println("❌ Movie not found: " + title);
    }

    public static void main(String[] args) {
        MovieManagement mm = new MovieManagement();

        mm.addMovieAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mm.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        mm.addMovieAtBeginning("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        mm.addMovieAtPosition("Avatar", "James Cameron", 2009, 7.8, 2);
        mm.addMovieAtPosition("Titanic", "James Cameron", 1997, 7.9, 1);

        mm.displayMoviesForward();
        mm.displayMoviesReverse();

        mm.searchMovie("Christopher Nolan");
        mm.searchMovie("7.9");

        mm.updateMovieRating("Avatar", 8.1);
        mm.displayMoviesForward();

        mm.removeMovie("Interstellar");
        mm.displayMoviesForward();
    }
}

