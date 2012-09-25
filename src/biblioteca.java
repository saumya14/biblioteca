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
public class Biblioteca
{
    private ArrayList<Book> listOfBooks=new ArrayList<Book>();
    private ArrayList<Movie> listOfMovies=new ArrayList<Movie>();
    private ArrayList<User> listofUsers=new ArrayList<User>();
    private User loggedInUser=null;

    Biblioteca()
    {
        listOfBooks.add(new Book("Harry Potter 1",true));
        listOfBooks.add(new Book("Harry Potter 2",true));
        listOfBooks.add(new Book("Harry Potter 3",true));
        listOfBooks.add(new Book("Harry Potter 4",true));
        listOfBooks.add(new Book("Harry Potter 5",true));
        listOfBooks.add(new Book("Harry Potter 6",true));
        listOfBooks.add(new Book("Harry Potter 7",true));
        listOfBooks.add(new Book("Little Women",true));
        listOfBooks.add(new Book("Little Women 2",true));
        listOfBooks.add(new Book("Little Women 3",true));

        listOfMovies.add(new Movie("LOTR -Fellowship","Peter Jackson","1"));
        listOfMovies.add(new Movie("LOTR -Two Towers","Peter Jackson","1"));
        listOfMovies.add(new Movie("LOTR -return of the King","Peter Jackson","1"));
        listOfMovies.add(new Movie("Titanic","James","3"));
        listOfMovies.add(new Movie("Titanic 3D","James","5"));
        listOfMovies.add(new Movie("Shrek","Adam","1"));
        listOfMovies.add(new Movie("Mission Impossible 1","Brian","1"));
        listOfMovies.add(new Movie("Mission Impossible 2","Brian","1"));
        listOfMovies.add(new Movie("Mission Impossible 3","Brian","1"));
        listOfMovies.add(new Movie("Finding Nemo","ABC","8"));
        listOfMovies.add(new Movie("Wall E","XYZ","9"));
        listOfMovies.add(new Movie("Monsters Inc 1","James","5"));
        listOfMovies.add(new Movie("Monsters Inc 2","Jackson","2"));
        listOfMovies.add(new Movie("Ted","Alex","10"));
        listOfMovies.add(new Movie("How to Survive a Plague","David France","N/A"));

        listofUsers.add(new User("1111-111","abc","abc@gmail.com","1234"));
        listofUsers.add(new User("1111-112","abc1","abc1@gmail.com","123"));
        listofUsers.add(new User("1111-113","abc2","abc2@gmail.com","1234"));

    }

    String getUserInput(String prompt)
    {
        String inputLine=null;
        System.out.print(prompt +" ");
        try
        {
            BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
            inputLine=is.readLine();
            if(inputLine.length()==0)
                return null;
        }
        catch(IOException e)
        {
            System.out.println("IOException: "+e);
        }
        return inputLine;
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
        String sReserveBookName;
        Book requestedBook;
        while(loggedInUser==null)
        {
            login();
        }
        sReserveBookName=getUserInput("Enter the name of the book you want to reserve: ");
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
          if (loggedInUser==null)
              System.out.println(message);

          else
            loggedInUser.displayUserDetails();
    }

    void displayAllMovie()
    {
        for(Movie m:listOfMovies)
        {
            m.displayMovieDetails();
        }
    }

    void login()
    {
        System.out.println("You are not logged in!!! Please log in..");
        String username=getUserInput("Please enter your user name:");
        String password=getUserInput("Please enter the password:");

        for(User u:listofUsers)
        {
            if(u.validateUser(username,password))
            {
                loggedInUser=u;
                u.setLoggedInStatus();
                break;
            }
        }
        if(loggedInUser==null)
        {
            System.out.println("Wrong username/password");
        }
    }

    String displayOptions() throws IOException
    {
        String choice;

        System.out.println("--------Please choose what you want to do from the list given below:------");
        System.out.println("1->See all the books in the library");
        System.out.println("2->Reserve a book") ;
        System.out.println("3->Check your details");
        System.out.println("4->Display Movies");
        System.out.println("5->Exit");

        do
        {
            choice= getUserInput("Please enter a valid choice: ");
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
