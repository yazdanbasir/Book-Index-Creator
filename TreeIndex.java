import java.util.*;
import java.io.*;

/**
 * Creates a book index using a TreeMap as the main data structure
 * Overrides the createOutputFile() and addEntry() methods
 * Uses the readFile() method from the abstract class
 * 
 * @author Yazdan Basir
 */
public class TreeIndex extends Index {
    private static TreeMap <String, TreeSet <Integer>> treeMap;

    /**
     * Constructor for the TreeIndex class
     */
    public TreeIndex() {
        treeMap = new TreeMap <String, TreeSet <Integer>> ();
    }

    /**
     * Iterates through the TreeMap and prints each element to an output file
     */
    @Override
    public void createOutputFile() {
        try {
            File outputFile = new File("Tree Index Output.txt");
            outputFile.createNewFile();

            PrintWriter writeFile = new PrintWriter(outputFile);

            // Iterator created using the TreeMap's entry set to make the process efficient
            Iterator <Map.Entry<String,TreeSet<Integer>>> iterator = treeMap.entrySet().iterator();
            Map.Entry <String, TreeSet<Integer>> entry = null;

            while (iterator.hasNext()) {
                entry = iterator.next();

                //Prints the key and corresponding value (the set of lines) to the file
                writeFile.println(entry.getKey() + " " + entry.getValue());
            }

            writeFile.close();

        } catch (Exception e) {
            System.out.println("An error has occurred in createOutputFile: " + e);
        }
    }

    /**
     * Adds each word and line to the TreeMap
     * 
     * @param w String
     * @param line Integer
     */
    @Override
    public boolean addEntry(String w, Integer line) {
        if (!isWordInDictionary(w)) {
            return false; // Checks whether word is valid/present in the dictionary
        }

        if (!treeMap.containsKey(w)) { // If the TreeMap doesn't contain the word
            treeMap.put(w, new TreeSet <Integer> ()); // Make a new entry 
            treeMap.get(w).add(line); // Add that line to its set

            return true;

        } else if (treeMap.containsKey(w)) { // If the TreeMap already has that word
            if (!treeMap.get(w).contains(line)) { // But the set doesn't contain that specific line
                treeMap.get(w).add(line); // Add the line number to the set

                return true;
            } 
        }

        return false;
    }
}