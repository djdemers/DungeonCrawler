//Static imports at the top
// Regular imports below static imports
// Both groups sorted alphabetically

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class JunitTesting {
    @Test
    public void testGreeting(){
        Main classTest = new Main();
        assertEquals("Hello, world!", classTest.getGreeting());
    }

}
