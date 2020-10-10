import java.io.*;
import java.util.*;

/**
 * Abstract class Index - describes the methods to be used by each index
 * Every index has its own createOutputFile() and addEntry() method
 * readFile(), createDictionary(), isWordInDictionary() are implemented here as they are used without modification across all 3 indexes
 *
 * @author Yazdan Basir
 */
public abstract class Index {
    private static ArrayList <String> dictionary;
    
    /**
     * Writes all the words and their sets to a newly created output file
     */
    public abstract void createOutputFile();
    
    /**
     * Adds the word and its line to the respective data structure being used
     * 
     * @param line Integer
     * @param w String
     */
    public abstract boolean addEntry(String w, Integer line);
    
    /**
     * Reads the file provided, splits the lines into words, and has each word added to the data structure
     * 
     * @param fileName String
     */
    public void readFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));

            int lineCount = 1;
            
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^A-Za-z]+"); // Splits the line into individual words
                
                for (int i = 0; i < words.length; i++) {
                    words[i] = words[i].toLowerCase(); // Converts the word to lowercase
                    addEntry(words[i], lineCount); // Adds the word and the line it was found on the data structure
                }

                lineCount++; // Increments the line number being read
            }

        } catch (Exception e) {
            System.out.println("An error has occurred in readFile: " + e);
        }
    }

    /**
     * Reads the provided dictionary file and creates a dictionary ArrayList to be used to check if a word is valid
     */
    public static void createDictionary() {
        try{ 
            BufferedReader reader = new BufferedReader(new FileReader("Dictionary.txt"));
            dictionary = new ArrayList <String> (); // Creates an ArrayList called dictionary to hold all words in the Dictionary.txt file
            
            String line = "";

            while ((line = reader.readLine()) != null) {
                // Reads through the Dictionary.txt file and adds every word into the Dictionary ArrayList
                dictionary.add(line);
            }

        } catch (Exception e) {
            System.out.println("An error has occured in createDictionary(): " + e);
        }
    }

    /**
     * Performs a binary search to check whether the word being looked at is in the dictionary or not
     * 
     * @param w String
     */
    public static boolean isWordInDictionary(String w) {
        // Performs a Binary Search on the ArrayList to check if the argument word is valid
        int index = Collections.binarySearch(dictionary, w.toLowerCase());
        
        if (index < 0) { // Returns false if word not found
            return false;
        } else { // Returns true otherwise
            return true;
        }
    }
}