import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/28/12
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBibliotecaHelper {
    @Test
    public void shouldSayValidChoice() {

        boolean result = BibliotecaHelper.validateChoice("2", 3);

        assertEquals(result, true);
    }
    @Test
    public void shouldSayInValidChoice() {

        boolean result = BibliotecaHelper.validateChoice("4", 3);

        assertEquals(result,false);
    }
}
