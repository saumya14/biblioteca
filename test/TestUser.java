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
public class TestUser {
    @Test
    public void shouldSayValidUser() {
        User testUser = new User("XYZ", "123", "ABC@gmail.com", "91-12345");
        boolean result;

        result = testUser.validateUser("XYZ", "123");

        assertEquals(result, true);

    }

    @Test
    public void shouldSayInvalidUser() {
        User testUser = new User("ABC", "567", "ABC@gmail.com", "91-12345");
        boolean result;

        result = testUser.validateUser("XYZ", "123");

        assertEquals(result, false);

    }

    @Test
    public void shouldSayNotLoggedIn() {
        User testUser = new User("ABC", "123", "ABC@gmail.com", "91-12345");
        boolean result;

        result = testUser.isLoggedIn();

        assertEquals(result, false);
    }

    @Test
    public void shouldSayLoggedIn() {
        User testUser = new User("ABC", "123", "ABC@gmail.com", "91-12345");
        boolean result;

        testUser.loggedIn();
        result = testUser.isLoggedIn();

        assertEquals(result, true);
    }

    @Test
    public void shouldDisplayUserDetails() throws Exception {
        User testUser = new User("ABC", "123", "ABC@gmail.com", "91-12345");

        assertEquals("ABC ABC@gmail.com 91-12345",testUser.displayUserDetails());
    }
}
