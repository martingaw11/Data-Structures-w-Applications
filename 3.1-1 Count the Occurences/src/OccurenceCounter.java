/*
 * Martin Gawron
 * 
 * 04/07/2023
 * Initial start to project.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;

/*
 * Basic class with just the test client of counting the number of
 * occurences of each word in a text file passed to the main method.
 * 
 * Special characters and numeric values "0-9" will not count as characters
 * of a word and will be removed for the counting of occurences.
 * 
 * This is doen so using the data structure of a symbol table as provided
 * by the algs4 library.
 */
public class OccurenceCounter {
    public static void main(String[] args) throws Exception {
        // THIS WAS A TEST TO SEE IF REPLACEALL WORKS FOR MY CASE
        /* 
        String[] input = StdIn.readAllStrings();

        for (String word : input) {
            String better = word.replaceAll("[^a-zA-Z]", "");
            StdOut.println(better);
        }
        */
        // this is the creation of the symbol table that will be used
        ST<String, Integer> st = new ST<String, Integer>();

        // going to iterate through every string in the text, originally separated by " "
        while (!StdIn.isEmpty()) {
            // taking in the word
            String key = StdIn.readString();

            // refactoring the word to get rid of special characters and numbers and making lowercase
            key = key.replaceAll("[^a-zA-Z]", "");
            key = key.toLowerCase();

            // if the resulting key is just whitespace, move onto next iteration
            if (key.isBlank()) {continue;}

            // check to see of the symbol table already has key
            if (st.contains(key)) {
                // if so, add 1 to its value for the running count of occurences
                st.put(key, st.get(key) + 1);
            }
            else {
                // if not, we will create the very first occurence in the sybmol table
                st.put(key, 1);
            }
        }

        // this is all just formatting the output in such a way that is readable
        // the output specifically is each word that appears in the text and its related number of occurences
        StdOut.printf("%-25s", "Word");
        StdOut.printf("%-25s", "Occurences");
        StdOut.println("\n--------------------------------------");
        for (String key : st.keys()) {
            //StdOut.println(key + '\t' + st.get(key));
            StdOut.printf("%-25s", key);
            StdOut.printf("%-25s", st.get(key));
            StdOut.println();
        }
    }
}
