/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/20/12
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    private String bookName;
    private boolean isAvailable;

    Book(String name, boolean availability) {
        bookName = name;
        isAvailable = availability;
    }

    boolean bookAvailability() {
        return isAvailable;
    }

    String displayBookDetails() {
        return bookName + " " + isAvailable;
    }

    boolean bookInLibrary(String bookToFind) {
        return bookName.equals(bookToFind);
    }

    void issueBook() {
        isAvailable = false;
    }
}
