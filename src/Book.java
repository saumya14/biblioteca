/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/20/12
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book
{
    String bookName;
    boolean isAvailable;

    Book(String bookName,boolean isAvailable)
    {
        this.bookName=bookName;
        this.isAvailable=isAvailable;
    }
    boolean getisAvailable()
    {
        return isAvailable;
    }
    String displayBookDetails()
    {
           return bookName+" "+isAvailable;
    }
    boolean bookInLibrary(String bookToFind)
    {
        if(bookName.equals(bookToFind))
            return true;
        return false;
    }
    void setBookStatusToReserved()
    {
        isAvailable=false;
    }
}
