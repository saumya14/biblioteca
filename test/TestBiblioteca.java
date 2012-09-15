import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/15/12
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBiblioteca {
    @Test
    public void testDisplayWelcomeMessage()
    {
        biblioteca bTest=new biblioteca();
        assertTrue(bTest.displayWelcomeMessage().equals("--------Hi Member. Welcome to Bangalore Biblioteca--------"));

    }





}
