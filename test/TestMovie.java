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
public class TestMovie extends TestCase {
    @Test
    public void testDisplayMovieDetails() throws Exception {
        super.setUp();
        Movie mTest = new Movie("LOTR", "ABC", "3");
        String result;

        result = mTest.displayMovieDetails();

        assertEquals("LOTR ABC ***", result);
    }
}
