import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/27/12
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class BibliotecaHelper {
    ArrayList<Movie> listMovies;
    ArrayList<Book> listBooks;
    User loggedInUser;
    ArrayList<User> listUsers;

    BibliotecaHelper(ArrayList<Movie> listMovies,ArrayList<Book> listBooks,ArrayList<User> listUsers) {
        this.listMovies=listMovies;
        this.listBooks=listBooks;
        this.listUsers=listUsers;
    }


    void displayAllMovies() {

        InputOutput.displayOutput("Movie Name-----------------Director-------------Rating");

        for (Movie m : listMovies)
            InputOutput.displayOutput(m.displayMovieDetails());
    }

    void displayAllBooks() {

        InputOutput.displayOutput("Book Name------Status");

        for (Book b : listBooks) {
            InputOutput.displayOutput(b.displayBookDetails());
        }
    }

    void viewUserDetails() {
        if (loggedInUser == null)
            InputOutput.displayOutput("Please talk to the librarian");

        else
            InputOutput.displayOutput(loggedInUser.displayUserDetails());
    }

    static Book findBookAvailability(String bookToSearch,ArrayList<Book> bookList) {

        for (Book b : bookList) {
            if (b.isBookInLibrary(bookToSearch)) {
                return b;
            }
        }
        return null;
    }

    static void displayWelcomeMessage(String message) {
        InputOutput.displayOutput(message);
    }

    static boolean validateChoice(String choice, int size) {

        for (int counter = 0; counter <= size; counter++) {
            if (Integer.parseInt(choice) == counter)
                return true;
        }
        return false;
    }

    User login() {
        InputOutput.displayOutput("You are not logged in!!! Please log in..");
        String username = InputOutput.getUserInput("Please enter your user name:");
        String password = InputOutput.getUserInput("Please enter the password:");

        for (User u : listUsers) {
            if (u.validateUser(username, password)) {
                loggedInUser = u;
                u.loggedIn();
                break;
            }
        }
        if (loggedInUser == null) {
            InputOutput.displayOutput("Wrong username/password");
        }
        return loggedInUser;
    }

    static int getUserChoice(int size) {
        String choice;
        do {
            choice = InputOutput.getUserInput("Please enter your choice: ");
        } while (!validateChoice(choice, size));

        return Integer.parseInt(choice);
    }
}
