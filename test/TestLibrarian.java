import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/28/12
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestLibrarian {
    User u = new User("ABC", "abc", "abc@gmail.com", "12345");
    ArrayList<Book> testList = new ArrayList<Book>();

    @Test
    public void shouldSayUserNotLoggedIn() throws Exception {
        testList.add(new Book("LOTR", true));
        Librarian testLibrarian = new Librarian(testList, null);

        assertEquals(testLibrarian.reserveBook("LOTR"), "You cannot issue a book since you are not logged in.");

    }

    @Test
    public void shouldSaySuccesfulReservation() throws Exception {
        Librarian testLibrarian = new Librarian(testList, u);
        testList.add(new Book("LOTR", true));

        assertEquals(testLibrarian.reserveBook("LOTR"), "Thank you. Enjoy the book");
    }

    @Test
    public void shouldSayBookNotInLibrary() throws Exception {
        Librarian testLibrarian = new Librarian(testList, u);
        testList.add(new Book("LOTR", true));

        assertEquals(testLibrarian.reserveBook("LOTR123"), "Sorry we don't have that book yet");
    }

    @Test
    public void shouldSayBookAlreadyIssued() throws Exception {
        Librarian testLibrarian = new Librarian(testList, u);
        testList.add(new Book("LOTR", false));

        assertEquals(testLibrarian.reserveBook("LOTR"), "Book is already issued to another member");
    }

}
