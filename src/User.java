/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/21/12
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    String userName;
    String password;
    boolean loggedIn;

    public User(String name,String password)
    {
        userName=name;
        this.password=password;
        loggedIn=false;
    }

    boolean validateUser(String inUser,String iPassword)
    {
        return(userName.equals(inUser) && password.equals(iPassword));
    }
}
