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
public class Biblioteca {
    private Book listOfBooks[];
    Biblioteca()
    {
        listOfBooks=new Book[10];
        listOfBooks[0]=new Book("Harry Potter 1",true);
        listOfBooks[1]=new Book("Harry Potter 2",true);
        listOfBooks[2]=new Book("Harry Potter 3",true);
        listOfBooks[3]=new Book("Harry Potter 4",true);
        listOfBooks[4]=new Book("Harry Potter 5",true);
        listOfBooks[5]=new Book("Harry Potter 6",true);
        listOfBooks[6]=new Book("Harry Potter 7",true);
        listOfBooks[7]=new Book("Little Women",true);
        listOfBooks[8]=new Book("Little Women 2",true);
        listOfBooks[9]=new Book("Little Women 3",true);
    }

     void displayWelcomeMessage(String message)
    {
        System.out.print(message);
    }

    int displayAllBooks()
    {
           System.out.println("Book Name------Status");

           for(int iCounter=0;iCounter<=listOfBooks.length-1;iCounter++)
           {
               System.out.println(listOfBooks[iCounter].displayBookDetails());
           }
        return 0;
    }
    Book findBookAvailability(String bookToSearch)
    {
        for(int iCounter=0;iCounter<listOfBooks.length-1;iCounter++)
        {
            if(listOfBooks[iCounter].bookInLibrary(bookToSearch))
            {
                return listOfBooks[iCounter];
            }
        }
        return null;
    }

    void reserveBook() throws IOException
    {
        BufferedReader dataRead=new BufferedReader(new InputStreamReader(System.in));
        String sReserveBookName;
        Book requestedBook;

        System.out.print("Enter the name of the book you want to reserve:\t");
        sReserveBookName=dataRead.readLine();
        requestedBook=findBookAvailability(sReserveBookName);

        /*a null object would signify that the book is not present in the library   */
        if(requestedBook==null)
            System.out.println("“Sorry we don't have that book yet");
        else
        {
            if(requestedBook.getisAvailable())
            {
                System.out.println("Thank you. Enjoy the book");
                requestedBook.setBookStatusToReserved();
            }
            else
            {
                System.out.println("Book is already issued to another member");
            }
        }
    }

    void viewDetails(String message)
    {
          System.out.print(message);
    }

    String displayOptions() throws IOException
    {
        BufferedReader dataInput=new BufferedReader(new InputStreamReader(System.in)) ;
        String choice;

        System.out.println("--------Please choose what you want to do from the list given below:------");
        System.out.println("1->See all the books in the library");
        System.out.println("2->Reserve a book") ;
        System.out.println("3->Check your details");
        System.out.println("4->Exit");

        do
        {
            System.out.print("Please enter a valid choice:");
            choice= dataInput.readLine();
        }while(validateChoice(choice));

        return choice;
    }

    public boolean validateChoice(String choice)
    {
        return(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));
    }

    public static void main( String args[]) throws IOException
    {
        int memberChoice;
        Biblioteca library=new Biblioteca();

        library.displayWelcomeMessage("Hi Member. Welcome to Bangalore Biblioteca");

        memberChoice=Integer.parseInt(library.displayOptions());
        while(memberChoice!=4)
        {
            switch(memberChoice)
            {
                case 1: library.displayAllBooks();
                    break;
                case 2: library.reserveBook();
                    break;
                case 3: library.viewDetails("Please talk to Librarian. Thank you.");
                    break;
            }
            memberChoice=Integer.parseInt(library.displayOptions());
        }
    }
}
