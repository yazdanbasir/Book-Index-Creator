import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TreeIndexTest.
 *
 * @author Yazdan Basir
 */
public class TreeIndexTest {
    TreeIndex tester;
    
    /**
     * Default constructor for test class ListIndexTest
     */
    public TreeIndexTest() {
        tester = new TreeIndex();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        tester = new TreeIndex();
    }
    
    @Test
    public void addEntryTreeTest1() {
        tester.createDictionary();
        assertEquals(true, tester.addEntry("apple", 100));
    }
    
    @Test
    public void addEntryTreeTest2() {
        tester.createDictionary();
        assertEquals(false, tester.addEntry("ABCDEF", 100));
    }
    
    @Test
    public void addEntryTreeTest3() {
        tester.createDictionary();
        tester.addEntry("apple", 100);
        assertEquals(true, tester.addEntry("apple", 101));
    }
    
    @Test
    public void addEntryTreeTest4() {
        tester.createDictionary();
        tester.addEntry("apple", 100);
        assertEquals(false, tester.addEntry("apple", 100));
    }
    
    @Test
    public void isWordInDictionaryTreeTest1() {
        tester.createDictionary();
        assertEquals(true, tester.isWordInDictionary("apple"));
    }
    
    @Test
    public void isWordInDictionaryTreeTest2() {
        tester.createDictionary();
        assertEquals(false, tester.isWordInDictionary("ABCDEF"));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
}