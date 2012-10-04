/**
 * Created with IntelliJ IDEA.
 * User: saumyasi
 * Date: 4/10/12
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayMovieDetailsCommand implements Command {

    BibliotecaHelper helper;
    public DisplayMovieDetailsCommand(BibliotecaHelper helper){
        this.helper=helper;
    }
    public void execute(){
        helper.displayAllMovies();
    }
}
