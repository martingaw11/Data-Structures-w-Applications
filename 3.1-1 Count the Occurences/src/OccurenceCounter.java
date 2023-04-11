/*
 * Martin Gawron
 * 
 * 04/07/2023
 * Initial start to project.
 * 
 * 04/11/2023
 * Changing process for taking words from text, will break up
 * words like 'three-dimensional' into 'three' 'dimensional' instead
 * of adding it as 'threedimensional'
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
        // this is the creation of the symbol table that will be used
        ST<String, Integer> st = new ST<String, Integer>();
        
        // running loop until input is empty
        while (!StdIn.isEmpty()) {
            // reading in a string that has potential to be added to Symbol Table
            String potential = StdIn.readString();

            // we will store compound words in an array with words separated: three-dimensional becomes [three, dimensional]
            String[] strings = potential.split("[-|_]");

            // now loop through the array of compound words, or just one word
            for (String word : strings) {
                // refactoring each word to just be characters a-z, and lowercase
                word = word.replaceAll("[^a-zA-Z]", "");
                word = word.toLowerCase();

                // not adding 'word' that is just whitespace: '' ' '
                if (word.isBlank()) {continue;}

                // if word already in symbol table
                if (st.contains(word)) {
                    // then increment its correlated value by 1
                    st.put(word, st.get(word) + 1);
                }
                else {
                    // else we will create its first instance with a value of 1
                    st.put(word, 1);
                }
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
