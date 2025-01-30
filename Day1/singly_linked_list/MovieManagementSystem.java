package Day1.singly_linked_list;

class Movie{
    String title;
    String director;
    int yearOfRelease;
    int rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int yearOfRelease, int rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next=null;
        this.prev=null;
    }
}

public class MovieManagementSystem {
    Movie head;
    Movie tail;
    //add movie at the start of the node
    public void addFirst(String title, String director, int yearOfRelease, int rating){
        Movie newMovie = new Movie(title,director,yearOfRelease,rating);
        if(head==null){
            head = tail = newMovie;
            return;
        }
        newMovie.next=head;
        head.prev=newMovie;
        head=newMovie;
    }
    //add movie at the last node
    public void addLast(String title, String director, int yearOfRelease, int rating){
        Movie newMovie = new Movie(title,director,yearOfRelease,rating);
        if(head==null){
            head = tail = newMovie;
            return;
        }
        newMovie.prev=tail;
        tail.next=newMovie;
        tail = newMovie;
    }
    //add movie at some specific location
    public void addSpecificLocation(int position, String title, String director, int yearOfRelease, int rating){
        Movie newMovie = new Movie(title,director,yearOfRelease,rating);
        if(position==1){
           addFirst(title,director,yearOfRelease,rating);
            return;
        }
       Movie current = head;
        for(int i=1; current!=null && i< position-1; i++){
            current= current.next;
        }
        if(current==null){
            System.out.println("out of bound position");
            return;
        }

        newMovie.next = current.next;
        if (current.next != null) {
            current.next.prev = newMovie;
        }
        current.next = newMovie;
        newMovie.prev = current;

        if (newMovie.next == null) {
            tail = newMovie;
        }
    }
    //Remove a movie record by Movie Title.
    public void removeByTitle(String title){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        if(head.title.equals(title)){
            head= head.next;
            if(head!=null) {
                head.prev = null;
            }
            else {
                tail = null;
            }
            System.out.println("movie with title " + title + " has been removed");
            return;
        }
        Movie current = head;
        while(current!=null && !current.title.equals(title)){
            current= current.next;
        }
        if(current==null){
            System.out.println("movie with title " + title + " not found");
            return;
        }
        if(current.prev!=null)
             current.prev.next=current.next;
        if(current.next!=null) {
            current.next.prev = current.prev;
        }
        else {
            tail = current.prev;
        }

        System.out.println("movie with title " + title + " has been removed");

    }
    //Search for a movie record by Director or Rating.
    public void searchByDirector(String director){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Movie current = head;
        while(current!=null){
            if(current.director.equals(director)){
                System.out.println("movie with director " + director + " was found");
                return;
            }
            current= current.next;
        }
        System.out.println("no movie found with director " + director);
    }
    //Display all movie records in both forward and reverse order.
    public void displayForwardDirection(){
        Movie current = head;
        while(current!=null){
            System.out.println(current.title + " " + current.director + " " + current.yearOfRelease + " " + current.rating + " -->");
            current= current.next;
        }
        System.out.println("Null");
    }
    public void displayBackwardDirection(){
        Movie current = tail;
        while(current!=null){
            System.out.println(current.title + " " + current.director + " " + current.yearOfRelease + " " + current.rating + " -->");
            current= current.prev;
        }
        System.out.println("Null");
    }
    //Update a movie's Rating based on the Movie Title.
    public void updateRatingByTitle(String title, int rating){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        Movie current = head;
        while(current!=null){
            if(current.title.equals(title)){
                current.rating=rating;
                System.out.println("movie with title " + title + " is updated with rating  " + rating);
                return;
            }
            current= current.next;
        }
        System.out.println("movie with title " + title + " does not found");
    }
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        // Adding movies
        mms.addFirst("Inception", "Christopher Nolan", 2010, 9);
        mms.addLast("Interstellar", "Christopher Nolan", 2014, 8);
        mms.addLast("The Dark Knight", "Christopher Nolan", 2008, 10);
        mms.addSpecificLocation(2, "Memento", "Christopher Nolan", 2000, 9);

        // Display movies
        System.out.println("\nMovies in Forward Direction:");
        mms.displayBackwardDirection();

        System.out.println("\nMovies in Backward Direction:");
        mms.displayBackwardDirection();

        // Search movies
        System.out.println("\nSearching for movies by director:");
        mms.searchByDirector("Christopher Nolan");

        // Update rating
        System.out.println("\nUpdating rating:");
        mms.updateRatingByTitle("Inception", 10);
        mms.displayForwardDirection();

        // Remove movie
        System.out.println("\nRemoving a movie:");
        mms.removeByTitle("Memento");
        mms.displayForwardDirection();
    }
}



