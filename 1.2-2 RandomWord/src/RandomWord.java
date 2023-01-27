/*
 * Martin Gawron
 * 01/27/2023
 * Practice Exercise for generating a random word from a list located
 * within a file that is passed to the program with only one iteration.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    /*
     * Main takes in a text file as an argument and the program iterates over
     * the list and picks out a "champion" or random word that will then be printed
     * to Standard Output.
     * This basic algorithm uses a random boolean returned from a Bernoulli distribution
     * to determine if the next word in the text file should be printed over the current
     * "champion"
     */
    public static void main(String[] args) throws Exception {
        // establishes the frist word in the text file as "champion"
        int count = 2;
        String champion = StdIn.readString();

        // making sure to loop through every word in the text file
        while (!StdIn.isEmpty()) {
            // using the bernoulli(double p) method to determine if the next word "wins" and
            // takes over as champion
            if (StdRandom.bernoulli(1.0/count)) {
                champion = StdIn.readString();
            }
            // if the next word does not "win" we still iterate over it so that we can take in
            // the next word
            else {
                StdIn.readString();
            }
            // we iterate count by 1 so that we know how many words have been in the "fight" for
            // "champion" so that we can use the bernoulli method to accurately get a random
            // boolen correlated to the probability that this word would be picked out of the 
            // previous words that have been passed
            count++;
        }
        
        StdOut.print(champion);
    }
}
