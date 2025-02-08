package doublylinkedlist.moviemanagementsystem;

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList m1 = new MovieList();
        m1.addAtBegining("Simba2", "Niraj chopra", 2017, 9);
        m1.addAtBegining("Pushpa", "karan johar", 2018, 10);
        m1.addAtBegining("Avtar", "Gautam Adani", 2020, 7);
//        m1.displayForward();

        m1.addAtEnd("KGF", "Rohit shetty", 2022, 8);
        m1.addAtEnd("KGF2", "Rohit shetty", 2024, 10);
        m1.displayForward();
//        m1.displayReverse();

        Movie movie = m1.remove("KGF2");
        System.out.println(movie.title);
        m1.displayForward();
        m1.displayReverse();

        System.out.println( m1.searchMovie("Niraj chopra"));
        System.out.println();

        Movie updatedRating = m1.updateRating("Avtar", 10);
        System.out.println("Movie title: "+updatedRating.title + ", Updated Rating is : " + updatedRating.rating);

    }

}
