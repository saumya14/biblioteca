import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;


/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/21/12
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMovie extends TestCase
{
    @Test
    public void testDisplayMovieDetails()throws Exception
    {
        super.setUp();
        Movie mTest=new Movie("LOTR","ABC","3");
        String separator;

        PrintStream originalOut=System.out;
        OutputStream os=new ByteArrayOutputStream();
        PrintStream ps=new PrintStream(os);
        System.setOut(ps);
        mTest.displayMovieDetails();
        separator=System.getProperty("line.separator");

        assertEquals("LOTR ABC ***"+separator,os.toString());
        System.setOut(originalOut);

    }
}
