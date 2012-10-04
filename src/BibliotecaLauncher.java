import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/27/12
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BibliotecaLauncher {
    static ArrayList<Command> executeCommand=new ArrayList<Command>();

    static void setupChoices(BibliotecaHelper helper,Librarian libAssistant){
        executeCommand.add(new DisplayBooksCommand(helper));
        executeCommand.add(new ReserveBookCommand(libAssistant));
        executeCommand.add(new ViewUserDetailsCommand(helper));
        executeCommand.add(new DisplayMovieDetailsCommand(helper));
        executeCommand.add(new ExitCommand());
    }

    public static void main(String args[]) throws Exception {

        SetUpLibrary setup = new SetUpLibrary();
        User loggedInUser;
        Librarian libAssistant;
        ArrayList<String> listOfChoices = setup.initializeChoices();
        ArrayList<Book> listOfBooks = setup.initializeBooks();
        ArrayList<Movie> listOfMovies = setup.initializeMovies();
        ArrayList<User> listOfUsers = setup.initializeUsers();

        BibliotecaHelper helper=new BibliotecaHelper(listOfMovies,listOfBooks,listOfUsers) ;
        loggedInUser = helper.login();
        libAssistant = new Librarian(listOfBooks, loggedInUser);



        BibliotecaHelper.displayWelcomeMessage("Hi Member. Welcome to Bangalore Biblioteca");
        setupChoices(helper,libAssistant);

        int memberChoice;



        InputOutput.displayOutput("--------Please choose what you want to do from the list given below:------");
        for (String s : listOfChoices)
            InputOutput.displayOutput(s);


        do {
            memberChoice = BibliotecaHelper.getUserChoice(listOfChoices.size());
            executeCommand.get(memberChoice).execute();
        } while (true);
    }
}