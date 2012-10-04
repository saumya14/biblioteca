import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: saumyasi
 * Date: 4/10/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayBooksCommand implements Command {

    BibliotecaHelper helper;
    public DisplayBooksCommand(BibliotecaHelper helper){
        this.helper=helper;
    }
    public void execute(){
        helper.displayAllBooks();
    }

}
