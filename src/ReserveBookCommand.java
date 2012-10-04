/**
 * Created with IntelliJ IDEA.
 * User: saumyasi
 * Date: 4/10/12
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReserveBookCommand implements Command {
    Librarian assistant;
    ReserveBookCommand(Librarian lib){
        assistant=lib;
    }


    public void execute(){
        String requestedBook = InputOutput.getUserInput("Enter the name of the book you want to reserve: ");
        try{
            assistant.reserveBook(requestedBook);
        }
        catch(Exception e)
        {
            InputOutput.displayOutput(e.getMessage());
        }
    }

}
