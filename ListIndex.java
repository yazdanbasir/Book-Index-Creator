import java.util.*;
import java.io.*;

/**
 * Creates an index of words using an ArrayList as the prominent data structure
 * Overrides the createOutputFile() and addEntry() methods
 * Uses the readFile() method from the abstract class
 * 
 * @author Yazdan Basir
 */
public class ListIndex extends Index {
    private static ArrayList <Entry> list;
    
    /**
     * Constructor for the ListIndex class
     */
    public ListIndex() {
        list = new ArrayList <Entry> ();
    }

    /**
     * Creates the output file
     * Writes each entry in the ArrayList to the file
     */
    @Override
    public void createOutputFile() {
        try {
            File outputFile = new File("List Index Output.txt");

            outputFile.createNewFile();

            PrintWriter writeFile = new PrintWriter(outputFile);
            
            // Will iterate through the Arraylist
            Iterator <Entry> itr = list.iterator();
            
            while (itr.hasNext()) {
                Entry e = itr.next(); // Holds the next value in the ArrayList
                writeFile.println(e.word + " " + e.set);
            }

            writeFile.close();

        } catch (Exception e) {
            System.out.println("An error has occurred in createOutputFile: " + e);
        }
    }

    /**
     * First checks if the word is valid or not (by checking if it's in the provided dictionary)
     * Adds the word to the ArrayList then - creates a new entry if not present already
     */
    @Override
    public boolean addEntry(String w, Integer line) {
        if (!isWordInDictionary(w)) {
            return false; // Returns if the word being looked at isn't in the dictionary/isn't valid
        }

        int index = find(w); // Uses binarySearch to find whether the word is already in the ArrayList

        if (index < 0) { // If the word isn't present
            list.add((-1 * (index + 1)), new Entry(w)); // Creates a new Entry and adds it to the ArrayList
            list.get((-1 * (index + 1))).set.add(line); // Adds the line to the set of that word

            return true;

        } else if (index >= 0) { // If the word is already present

            if (list.get(index).set.contains(line)) { // If that line is already in the set of the word
                return false;

            } else {
                list.get(index).set.add(line); // Add the line to the set of the word

                return true;
            }
        }

        return false;
    }

    /**
     * BinarySearch helper method for addEntry()
     * Returns the index where the word is in the ArrayList
     * Returns a negative index if not present
     */
    public int find(String w) {
        return Collections.binarySearch(list, w);
    }

    /**
     * Inner class that is used to create an instance of a word and the set of lines it appears in
     *
     * @author Yazdan Basir
     */
    public class Entry implements Comparable <String> {
        TreeSet <Integer> set; // Holds the lines where the word has been found
        String word;

        /**
         * Constructor for the Entry class
         * 
         * @param w String
         */
        public Entry(String w) {
            this.word = w;
            this.set = new TreeSet <Integer> ();
        }

        /**
         * Custom compareTo method to sort the Entry instances
         * Allows the Binary Search to be performed
         */
        public int compareTo(String that) {
            return this.word.compareTo(that);
        }
    }
}