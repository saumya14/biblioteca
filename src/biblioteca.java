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
    private Movie listOfMovies[];
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

        listOfMovies=new Movie[15];
        listOfMovies[0]=new Movie("LOTR -Fellowship","Peter Jackson","1");
        listOfMovies[1]=new Movie("LOTR -Two Towers","Peter Jackson","1");
        listOfMovies[2]=new Movie("LOTR -return of the King","Peter Jackson","1");
        listOfMovies[3]=new Movie("Titanic","James","3");
        listOfMovies[4]=new Movie("Titanic 3D","James","5");
        listOfMovies[5]=new Movie("Shrek","Adam","1");
        listOfMovies[6]=new Movie("Mission Impossible 1","Brian","1");
        listOfMovies[7]=new Movie("Mission Impossible 2","Brian","1");
        listOfMovies[8]=new Movie("Mission Impossible 3","Brian","1");
        listOfMovies[9]=new Movie("Finding Nemo","ABC","8");
        listOfMovies[10]=new Movie("Wall E","XYZ","9");
        listOfMovies[11]=new Movie("Monsters Inc 1","James","5");
        listOfMovies[12]=new Movie("Monsters Inc 2","Jackson","2");
        listOfMovies[13]=new Movie("Ted","Alex","10");
        listOfMovies[14]=new Movie("How to Survive a Plague","David France","N/A");
    }

     void displayWelcomeMessage(String message)
    {
        System.out.print(message);
    }

    int displayAllBooks()
    {
           System.out.println("Book Name------Status");

           for(Book b:listOfBooks)
           {
               System.out.println(b.displayBookDetails());
           }
        return 0;
    }
    Book findBookAvailability(String bookToSearch)
    {
        for(Book b:listOfBooks)
        {
            if(b.bookInLibrary(bookToSearch))
            {
                return b;
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

    void displayAllMovie()
    {
        for(Movie m:listOfMovies)
        {
            m.displayMovieDetails();
        }
    }

    String displayOptions() throws IOException
    {
        BufferedReader dataInput=new BufferedReader(new InputStreamReader(System.in)) ;
        String choice;

        System.out.println("--------Please choose what you want to do from the list given below:------");
        System.out.println("1->See all the books in the library");
        System.out.println("2->Reserve a book") ;
        System.out.println("3->Check your details");
        System.out.println("4->Display Movies");
        System.out.println("5->Exit");

        do
        {
            System.out.print("Please enter a valid choice:");
            choice= dataInput.readLine();
        }while(validateChoice(choice));

        return choice;
    }

    public boolean validateChoice(String choice)
    {
        return !choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5");
    }

    public static void main( String args[]) throws IOException
    {
        int memberChoice;
        Biblioteca library=new Biblioteca();

        library.displayWelcomeMessage("Hi Member. Welcome to Bangalore Biblioteca");

        memberChoice=Integer.parseInt(library.displayOptions());
        while(memberChoice!=5)
        {
            switch(memberChoice)
            {
                case 1: library.displayAllBooks();
                    break;
                case 2: library.reserveBook();
                    break;
                case 3: library.viewDetails("Please talk to Librarian. Thank you.");
                    break;
                case 4: library.displayAllMovie();
                    break;
            }
            memberChoice=Integer.parseInt(library.displayOptions());
        }
    }
}
