package doublylinkedlist.moviemanagementsystem;

class Movie {
    String title;
    String director;
    int yearOfRelease;
    int rating;
    Movie prev;
    Movie next;

    public Movie(String title, String director, int yearOfRelease, int rating){
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}
