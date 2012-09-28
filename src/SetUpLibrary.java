import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/27/12
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class SetUpLibrary {
    ArrayList<Book> listOfBooks = new ArrayList<Book>();
    ArrayList<User> listOfUsers = new ArrayList<User>();
    ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
    ArrayList<String> listOfChoices = new ArrayList<String>();

    ArrayList<Book> initializeBooks() {
        listOfBooks.add(new Book("Harry Potter 1", true));
        listOfBooks.add(new Book("Harry Potter 2", true));
        listOfBooks.add(new Book("Harry Potter 3", true));
        listOfBooks.add(new Book("Harry Potter 4", true));
        listOfBooks.add(new Book("Harry Potter 5", true));
        listOfBooks.add(new Book("Harry Potter 6", true));
        listOfBooks.add(new Book("Harry Potter 7", true));
        listOfBooks.add(new Book("Little Women", true));
        listOfBooks.add(new Book("Little Women 2", true));
        listOfBooks.add(new Book("Little Women 3", true));

        return listOfBooks;
    }

    ArrayList<Movie> initializeMovies() {

        listOfMovies.add(new Movie("LOTR -Fellowship", "Peter Jackson", "1"));
        listOfMovies.add(new Movie("LOTR -Two Towers", "Peter Jackson", "1"));
        listOfMovies.add(new Movie("LOTR -return of the King", "Peter Jackson", "1"));
        listOfMovies.add(new Movie("Titanic", "James", "3"));
        listOfMovies.add(new Movie("Titanic 3D", "James", "5"));
        listOfMovies.add(new Movie("Shrek", "Adam", "1"));
        listOfMovies.add(new Movie("Mission Impossible 1", "Brian", "1"));
        listOfMovies.add(new Movie("Mission Impossible 2", "Brian", "1"));
        listOfMovies.add(new Movie("Mission Impossible 3", "Brian", "1"));
        listOfMovies.add(new Movie("Finding Nemo", "ABC", "8"));
        listOfMovies.add(new Movie("Wall E", "XYZ", "9"));
        listOfMovies.add(new Movie("Monsters Inc 1", "James", "5"));
        listOfMovies.add(new Movie("Monsters Inc 2", "Jackson", "2"));
        listOfMovies.add(new Movie("Ted", "Alex", "10"));
        listOfMovies.add(new Movie("How to Survive a Plague", "David France", "N/A"));

        return listOfMovies;
    }

    ArrayList<User> initializeUsers() {

        listOfUsers.add(new User("1111-111", "abc", "abc@gmail.com", "1234"));
        listOfUsers.add(new User("1111-112", "abc1", "abc1@gmail.com", "123"));
        listOfUsers.add(new User("1111-113", "abc2", "abc2@gmail.com", "1234"));

        return listOfUsers;

    }

    ArrayList<String> initializeChoices() {

        listOfChoices.add("0->See all the books in the library");
        listOfChoices.add("1->Reserve a book");
        listOfChoices.add("2->Check your details");
        listOfChoices.add("3->Display Movies");
        listOfChoices.add("4->Exit");

        return listOfChoices;
    }
}
