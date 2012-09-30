import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/27/12
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Librarian {
    ArrayList<Book> listOfBooks;
    User loggedInUser;

    Librarian(ArrayList<Book> listBooks, User loggedUser) {

        listOfBooks = listBooks;
        loggedInUser = loggedUser;
    }

    String reserveBook(String requestedBookName) throws IOException {
        Book requestedBook;
        if (loggedInUser == null) {
            return "You cannot issue a book since you are not logged in.";
        }
        requestedBook = BibliotecaHelper.findBookAvailability(requestedBookName, listOfBooks);

        /*a null object would signify that the book is not present in the library   */
        if (requestedBook == null)
            return "Sorry we don't have that book yet";
        else {
            if (requestedBook.isBookAvailable()) {
                requestedBook.issueBook();
                return "Thank you. Enjoy the book";
            } else {
                return "Book is already issued to another member";
            }
        }
    }
}