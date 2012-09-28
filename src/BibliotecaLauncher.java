import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/27/12
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BibliotecaLauncher {
    public static void main(String args[])throws Exception {

        SetUpLibrary setup = new SetUpLibrary();
        User loggedInUser;
        Librarian libAssistant;
        ArrayList<String> listOfChoices=setup.initializeChoices();
        ArrayList<Book> listOfBooks=setup.initializeBooks();
        ArrayList<Movie> listOfMovies=setup.initializeMovies();
        ArrayList<User> listOfUsers=setup.initializeUsers();

        BibliotecaHelper.displayWelcomeMessage("Hi Member. Welcome to Bangalore Biblioteca");

        int memberChoice;

        loggedInUser=BibliotecaHelper.login(listOfUsers) ;
        libAssistant = new Librarian(listOfBooks,loggedInUser);


        InputOutput.displayOutput("--------Please choose what you want to do from the list given below:------");
        for (String s : listOfChoices)
            InputOutput.displayOutput(s);


        do{
            memberChoice=BibliotecaHelper.getUserChoice(listOfChoices.size());
            switch (memberChoice) {
                case 0:
                    BibliotecaHelper.displayAllBooks(listOfBooks);
                    break;
                case 1:
                    InputOutput.displayOutput(libAssistant.reserveBook(InputOutput.getUserInput("Enter the name of the book you want to reserve: ")));
                    break;
                case 2:
                    BibliotecaHelper.viewDetails(loggedInUser);
                    break;
                case 3:
                    BibliotecaHelper.displayAllMovies(listOfMovies);
                    break;

            }
        }while(memberChoice!=4);
    }
}