import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/21/12
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestUser {
    @Test
    public void shouldSayValidUser()
    {
        User testUser=new User("XYZ","123");
        boolean result;

        result=testUser.validateUser("XYZ","123") ;

        assertEquals(result,true);

    }
    @Test
    public void shouldSayInvalidUser()
    {
        User testUser=new User("ABC","567");
        boolean result;

        result=testUser.validateUser("XYZ","123") ;

        assertEquals(result,false);

    }
    @Test
    public void shouldSayLoggedIn()
    {

    }
}
