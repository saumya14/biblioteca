import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

    public class Book{
        String sBookName;
        int iStatus;

        Book()
        {
            sBookName="";
            iStatus=AVAILABLE;
        }
        Book(String sBookName,int iStatus)
        {
            this.sBookName=sBookName;
            this.iStatus=iStatus;
        }

        String displayBook()
        {
            return sBookName+"\t"+iStatus;
        }
    }
    Book listOfBooks[];
    biblioteca()
    {
        listOfBooks=new Book[10];
        listOfBooks[0]=new Book("Harry Potter 1",AVAILABLE);
        listOfBooks[1]=new Book("Harry Potter 2",AVAILABLE);
        listOfBooks[2]=new Book("Harry Potter 3",AVAILABLE);
        listOfBooks[3]=new Book("Harry Potter 4",AVAILABLE);
        listOfBooks[4]=new Book("Harry Potter 5",AVAILABLE);
        listOfBooks[5]=new Book("Harry Potter 6",AVAILABLE);
        listOfBooks[6]=new Book("Harry Potter 7",AVAILABLE);
        listOfBooks[7]=new Book("Little Women 1",AVAILABLE);
        listOfBooks[8]=new Book("Little Women 2",AVAILABLE);
        listOfBooks[9]=new Book("Little Women 3",AVAILABLE);
    }

    String displayWelcomeMessage()
    {
        return "--------Hi Member. Welcome to Bangalore Biblioteca--------";
    }

    void displayAllBooks()
    {
           System.out.println("Book Name------Status( 0 means Available/1 stands for reserved");
           for(int iCounter=0;iCounter<=9;iCounter++)
           {
               System.out.println(listOfBooks[iCounter].displayBook());
           }
    }

    void reserveBook()
    {

    }

    void viewDetails()
    {


    }
    int displayOptions()  throws IOException
    {
        BufferedReader dataInput=new BufferedReader(new InputStreamReader(System.in)) ;
        int iChoice;
        String sChoice;

        System.out.println("Please choose what you want to do from the list given below: ");
        System.out.println("1->See all the books in the library");
        System.out.println("2->Reserve a book") ;
        System.out.println("3->Check your details");

        do{
            System.out.print("Please enter a valid choice:");
            sChoice= dataInput.readLine();
            iChoice=Integer.parseInt(sChoice);
        }while(iChoice!=1 && iChoice!=2 && iChoice!=3);

        return iChoice;
    }

    public static void main( String args[]) throws IOException
    {
        int iMemberChoice;

        biblioteca Biblioteca=new biblioteca();
        System.out.println(Biblioteca.displayWelcomeMessage());
        iMemberChoice=Biblioteca.displayOptions();

        switch(iMemberChoice)
        {
            case 1: Biblioteca.displayAllBooks();
                break;
            case 2: Biblioteca.reserveBook();
                break;
            case 3: Biblioteca.viewDetails();
                break;
        }

    }

}
