import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.OutputStream;


import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/15/12
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBiblioteca extends TestCase
{
    @Test
    public void testDisplayWelcomeMessage()  throws Exception
    {
        super.setUp();
        Biblioteca bTest=new Biblioteca();

        PrintStream originalOut=System.out;
        OutputStream os=new ByteArrayOutputStream();
        PrintStream ps=new PrintStream(os);
        System.setOut(ps);

        bTest.displayWelcomeMessage("Hi Member. Welcome to Bangalore Biblioteca");
        assertEquals("Hi Member. Welcome to Bangalore Biblioteca",os.toString());
        System.setOut(originalOut);
    }

    @Test
    public void testViewDetails()  throws Exception
    {
        super.setUp();
        Biblioteca bTest=new Biblioteca();

        PrintStream originalOut=System.out;
        OutputStream os=new ByteArrayOutputStream();
        PrintStream ps=new PrintStream(os);
        System.setOut(ps);

        bTest.displayWelcomeMessage("Please talk to Librarian. Thank you.");
        assertEquals("Please talk to Librarian. Thank you.",os.toString());
        System.setOut(originalOut);
    }






}
