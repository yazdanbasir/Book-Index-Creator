import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListIndexTest.
 *
 * @author Yazdan Basir
 */
public class ListIndexTest {
    ListIndex tester;
    
    /**
     * Default constructor for test class ListIndexTest
     */
    public ListIndexTest() {
        tester = new ListIndex();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        tester = new ListIndex();
    }
    
    @Test
    public void addEntryListTest1() {
        tester.createDictionary();
        assertEquals(true, tester.addEntry("apple", 100));
    }
    
    @Test
    public void addEntryListTest2() {
        tester.createDictionary();
        assertEquals(false, tester.addEntry("ABCDEF", 100));
    }
    
    @Test
    public void addEntryListTest3() {
        tester.createDictionary();
        tester.addEntry("apple", 100);
        assertEquals(true, tester.addEntry("apple", 101));
    }
    
    @Test
    public void addEntryListTest4() {
        tester.createDictionary();
        tester.addEntry("apple", 100);
        assertEquals(false, tester.addEntry("apple", 100));
    }
    
    @Test
    public void isWordInDictionaryListTest1() {
        tester.createDictionary();
        assertEquals(true, tester.isWordInDictionary("apple"));
    }
    
    @Test
    public void isWordInDictionaryListTest2() {
        tester.createDictionary();
        assertEquals(false, tester.isWordInDictionary("ABCDEF"));
    }
    
    @Test
    public void findTest1() {
        tester.createDictionary();
        tester.addEntry("apple", 100);
        assertEquals(0, tester.find("apple"));
    }
    
    @Test
    public void findTest2() {
        tester.createDictionary();
        assertEquals(-1, tester.find("apple"));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
}