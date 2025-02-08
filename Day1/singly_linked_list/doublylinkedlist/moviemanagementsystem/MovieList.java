package doublylinkedlist.moviemanagementsystem;

class MovieList {
    Movie head, tail;

    //add at begining
    void addAtBegining(String title, String director, int yearOfRelease, int rating) {
        Movie m1 = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = m1;
        } else {
            m1.next = head;
            head.prev = m1;
            head = m1;
        }
    }

    //add at end
    void addAtEnd(String title, String director, int yearOfRelease, int rating) {
        Movie m1 = new Movie(title, director, yearOfRelease, rating);

        if (tail == null) {
            head = tail = m1;
        }

        Movie temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        m1.prev = tail;
        tail.next = m1;
        tail = m1;
    }

    void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.print(temp.title + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    //display reverse method
    void displayReverse() {
        Movie temp = head;
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Find the last node (ensures correctness after deletion)
        while (temp.next != null) {
            temp = temp.next; // Move to the last node
        }

        while (temp != null) {
            System.out.print(temp.title + "<-");
            temp = temp.prev;
        }
        System.out.println();
    }

    //remove a movie by title
    Movie remove(String title) {
        Movie temp = head;
        Movie removed;

        if (temp != null && temp.title.equals(title)) {
            removed = temp;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return removed;
        }

        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp == null) { // Title not found
            return null;
        }

        removed = temp;

        if (temp.prev != null) {// Update the previous node's next pointer
            temp.prev.next = temp.next;
        }

        if (temp.next != null) { // Update the next node's prev pointer
            temp.next.prev = temp.prev;
        }else{ // If temp is the last node
            temp.prev.next = null;
        }

        temp.prev = null;
        temp.next = null;
        return removed;
    }

    //search a movie
    boolean searchMovie(String Director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(Director)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //update movie rating
    Movie updateRating(String title, int updateRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = updateRating;
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
