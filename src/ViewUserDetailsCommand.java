/**
 * Created with IntelliJ IDEA.
 * User: saumyasi
 * Date: 4/10/12
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewUserDetailsCommand implements Command {

    BibliotecaHelper helper;
    public ViewUserDetailsCommand(BibliotecaHelper helper){
        this.helper=helper;
    }
    public void execute(){
        helper.viewUserDetails();
    }
}
