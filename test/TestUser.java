import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/21/12
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestUser{
    @Test
    public void shouldSayValidUser()
    {
        User testUser=new User("XYZ","123","ABC@gmail.com","91-12345");
        boolean result;

        result=testUser.validateUser("XYZ","123") ;

        assertEquals(result,true);

    }
    @Test
    public void shouldSayInvalidUser()
    {
        User testUser=new User("ABC","567","ABC@gmail.com","91-12345");
        boolean result;

        result=testUser.validateUser("XYZ","123") ;

        assertEquals(result,false);

    }
    @Test
    public void shouldSayNotLoggedIn()
    {
         User testUser=new User("ABC","123","ABC@gmail.com","91-12345");
         boolean result;

        result=testUser.getLoggedInStatus();

        assertEquals(result,false);
    }
    @Test
    public void shouldSayLoggedIn()
    {
        User testUser=new User("ABC","123","ABC@gmail.com","91-12345");
        boolean result;

        testUser.setLoggedInStatus();
        result=testUser.getLoggedInStatus();

        assertEquals(result,true);
    }
    @Test
    public void shouldDisplayUserDetails()throws Exception
    {
        User testUser=new User("ABC","123","ABC@gmail.com","91-12345");
        String separator;

        PrintStream originalOut=System.out;
        OutputStream os=new ByteArrayOutputStream();
        PrintStream ps=new PrintStream(os);
        System.setOut(ps);
        testUser.displayUserDetails();
        separator=System.getProperty("line.separator");

        assertEquals("ABC ABC@gmail.com 91-12345"+separator,os.toString());
        System.setOut(originalOut);
    }
}
