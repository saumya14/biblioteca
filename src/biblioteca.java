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

    ArrayList listOfBooks;
    biblioteca()
    {
        listOfBooks = new ArrayList();
    }

    String displayWelcomeMessage()
    {
        return "--------Hi Member. Welcome to Bangalore Biblioteca--------";
    }

    void displayAllBooks()
    {

    }

    void reserveBook()
    {

    }

    void viewDetails()
    {


    }
    void displayOptions()  throws IOException
    {
        BufferedReader dataInput=new BufferedReader(new InputStreamReader(System.in)) ;
        int intChoice;
        String choice;

        System.out.println("Please choose what you want to do from the list given below: ");
        System.out.println("1->See all the books in the library");
        System.out.println("2->Reserve a book") ;
        System.out.println("3->Check your details");

        do{
            System.out.println("Please enter a valid choice:");
            choice= dataInput.readLine();
            intChoice=Integer.parseInt(choice);
        }while(intChoice!=1 && intChoice!=2 && intChoice!=3);


        switch(intChoice)
        {
            case 1: displayAllBooks();
                    break;
            case 2: reserveBook();
                    break;
            case 3: viewDetails();
                    break;

        }


    }



    public static void main( String args[]) throws IOException
    {
        biblioteca Biblioteca=new biblioteca();
        System.out.println(Biblioteca.displayWelcomeMessage());
        Biblioteca.displayOptions();

    }

}
