/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/15/12
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class biblioteca {
    public static final int RESERVED=1;
    public static final int AVAILABLE=0;

    class Book{
       String bookName;
       String authorName;
       Integer status;

        Book()
        {
            bookName="";
            authorName="";
            status=AVAILABLE;
        }
        Book(String bookName,String authorName)
        {
            this.bookName=bookName;
            this.authorName=authorName;
            status=AVAILABLE;
        }
        void displayBooks()
        {
            System.out.print(bookName+"\t"+authorName+"\t"+status);
        }
        void reserveBook(String bookName)
        {

        }


   }

    public static void main( String args[])
    {
        System.out.println("hello world");
    }

}
