import java.util.*;
import java.io.*;

/**
 * Creates the book index using a HashMap as the main data structure
 * Overrides the createOutputFile() and addEntry() methods
 * Uses the readFile() method from the abstract class
 *
 * @author Yazdan Basir
 */
public class HashIndex extends Index {
    private static HashMap <String, TreeSet<Integer>> hashMap;
    public static ArrayList <String> list;

    /**
     * Constructor for the HashIndex class
     */
    public HashIndex() {
        hashMap = new HashMap <String, TreeSet<Integer>> ();
    }

    /**
     * Creates a new output file, acccesses the elements in the sorted ArrayList, writes them to the file
     */
    @Override
    public void createOutputFile() {
        try {
            File outputFile = new File("Hash Index Output.txt");
            outputFile.createNewFile();

            PrintWriter writeFile = new PrintWriter(outputFile);

            // Iterator created to speed up accessing the elements
            Iterator <String> itr = list.iterator();

            while (itr.hasNext()) {
                String line = itr.next();

                //Writes the key and value returned from that key to the file
                writeFile.println(line + " " + hashMap.get(line));
            }

            writeFile.close();

        } catch (Exception e) {
            System.out.println("An error has occurred in createOutputFile: " + e);
        }
    }

    /**
     * Adds each word and line number to the HashMap
     * First checks whether the word is in the Dictionary
     * Then checks whether the word is already present in the HashMap
     * 
     * @param w String
     * @param line Integer
     */
    @Override
    public boolean addEntry(String w, Integer line) {
        if (!isWordInDictionary(w)) {
            return false; // Returns false if the word is invalid/not present in the dictionary
        }

        if (!hashMap.containsKey(w)) { // If the HashMap doesn't contain this word
            hashMap.put(w, new TreeSet <Integer> ()); // Create a new entry for it
            hashMap.get(w).add(line); // Add the line number to the word's set

            return true;

        } else if (hashMap.containsKey(w)) { // If the word already exists in the HashMap
            if (!hashMap.get(w).contains(line)) { // If the line isn't already in the set
                hashMap.get(w).add(line); // Add it to the set

                return true;
            } 
        }

        return false;
    }

    /**
     * Creates a Set from the keySet of the HashMap
     * Adds everything to an ArrayList and sorts the ArrayList
     */
    public void sort() {
        Set <String> s = hashMap.keySet(); // Set of keys created
        list = new ArrayList <String> ();

        for (String a: s) {
            list.add(a); // All keys added to ArrayList
        }

        Collections.sort(list); // ArrayList sorted
    }
}