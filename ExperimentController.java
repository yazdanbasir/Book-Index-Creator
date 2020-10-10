/**
 * Runs the experiments and outputs the average time taken to build an index using the 3 different data structures
 * This space was also used to perform each experiment and collect the data used in the graphs.
 *
 * @author Yazdan Basir
 */
public class ExperimentController {
    // An array containing the names of the books tested
    // They are arranged in increasing order of size
    private static String[] books = {"The Divine Comedy", "White Fang", "The Odyssey", "The Republic", "Middlemarch", "Don Quixote", "War and Peace", "Les Miserables", "The Complete Works of William Shakespeare"};

    private static ListIndex list;
    private static TreeIndex tree;
    private static HashIndex hash;

    private static long start1, start2, start3, start4, start5, start6 = 0;
    private static long end1, end2, end3, end4, end5, end6 = 0;
    private static long time1, time2, time3, time4, time5, time6 = 0;

    public static void main(String[] args) {
        list = new ListIndex();
        tree = new TreeIndex();
        hash = new HashIndex();

        list.createDictionary(); // Creates the Dictionary ArrayList
        tree.createDictionary();
        hash.createDictionary();

        // Builds an index using an ArrayList 5 times and returns the average
        for (int i = 0; i < 5; i++) {
            start1 = System.currentTimeMillis();
            list.readFile("The Complete Works of William Shakespeare");
            end1 = System.currentTimeMillis();
            
            start2 = System.currentTimeMillis();
            list.createOutputFile();
            end2 = System.currentTimeMillis();
            
            time1 = time1 + (end1-start1);
            time2 = time2 + (end2-start2);
        }
        
        System.out.println("List");
        System.out.println((time1)/5);
        System.out.println((time2)/5);
        System.out.println();

        // Builds an index using a TreeMap 5 times and returns the average
        for (int j = 0; j < 5; j++) {
            start3 = System.currentTimeMillis();
            tree.readFile("The Complete Works of William Shakespeare");
            end3 = System.currentTimeMillis();
            
            start4 = System.currentTimeMillis();
            tree.createOutputFile();
            end4 = System.currentTimeMillis();
            
            time3 = time3 + (end3-start3);
            time4 = time4 + (end4-start4);
        }
        
        System.out.println("Tree");
        System.out.println((time3)/5);
        System.out.println((time4)/5);
        System.out.println();

        // Builds an index using a HashMap 5 times and returns the average
        for (int k = 0; k < 5; k++) {
            start5 = System.currentTimeMillis();
            hash.readFile("The Complete Works of William Shakespeare");
            end5 = System.currentTimeMillis();
            
            hash.sort();
            
            start6 = System.currentTimeMillis();
            hash.createOutputFile();
            end6 = System.currentTimeMillis();
            
            time5 = time5 + (end5-start5);
            time6 = time6 + (end6-start6);
        }
        
        System.out.println("Hash");
        System.out.println((time5)/5);
        System.out.println((time6)/5);
    }

    /**
     * Method used to time the methods in ListIndex
     * 
     * @param file String
     */
    private static void timeList(String file) {
        long time = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 30; j++) {
                long b = System.currentTimeMillis();
                list.readFile(file);
                list.createOutputFile();
                long a = System.currentTimeMillis();
                time = time + ((a-b));
            }

            System.out.println(time/30);
        }
    }

    /**
     * Method used to time the methods in TreeIndex
     * 
     * @param file String
     */
    private static void timeTree(String file) {
        long time = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 30; j++) {
                long b = System.currentTimeMillis();
                tree.readFile(file);
                tree.createOutputFile();
                long a = System.currentTimeMillis();
                time = time + ((a-b));
            }

            System.out.println(time/30);
        }
    }

    /**
     * Methods used to time the methods in HashIndex
     * Prints the average time taken
     * 
     * @param file String
     */
    private static void timeHash(String file) {
        long time = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 30; j++) {
                long b = System.currentTimeMillis();
                hash.readFile(file);
                //long a = System.currentTimeMillis();
                hash.sort();
                hash.createOutputFile();
                long a = System.currentTimeMillis();
                time = time + ((a-b));
            }

            System.out.println(time/30);
        }
    }
}