import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/20/12
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBook {
    @Test
    public void isDisplayingBookDetails() {
        Book testBook;
        testBook = new Book("ABC", true);

        assertEquals("ABC" + " " + true, testBook.displayBookDetails());
    }

    @Test
    public void shouldSayBookNotInLibrary() {
        boolean presentInLibrary;
        Book testBook;
        testBook = new Book("ABC", true);

        presentInLibrary = testBook.bookInLibrary("XYZ");

        assertEquals(presentInLibrary, false);
    }

    @Test
    public void shouldSayBookIsInLibrary() {
        boolean presentInLibrary;
        Book testBook;
        testBook = new Book("ABC", true);

        presentInLibrary = testBook.bookInLibrary("ABC");

        assertEquals(presentInLibrary, true);
    }

    @Test
    public void shouldReserveBook() {
        Book testBook;
        testBook = new Book("ABC", true);

        testBook.issueBook();

        assertEquals(testBook.bookAvailability(), false);
    }
}
