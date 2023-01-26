/*
 * Martin Gawron
 * 1/25/2023
 * 1.1.1 Tabulation
 * This code takes in a text file as input and prints to standard output the names of the students, 
 * their scores, and average of their scores (accurate to 3 decimal places)
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class App {
    /*
     * Prints the names, scores and average of scores for each respective student
     * @param String[] args
     * @return None
     * text file is input through args and used to pull student information out,
     * this information is then formatted and printed to Standard Output
     */
    public static void main(String[] args) throws Exception {
        // Creating header of table formatted to clarify columns w/ divider
        StdOut.printf("|%-10s|", "Names");
        StdOut.printf("%-24s", "Scores");
        StdOut.printf("|%-10s|", "Averages");
        StdOut.println("\n------------------------------------------------");

        // Loops through contents of text file, extracting name and scores
        while (StdIn.hasNextLine()) {
            // Reads in name and prints it to Standard Output
            String name = StdIn.readString();
            StdOut.printf("|%-10s|", name);
            double[] scores = new double[3];

            // for loop for filling in scores[] and printing scores to Standard Output
            for (int i = 0;  i < 3; i++) {
                scores[i] = StdIn.readDouble();
                StdOut.printf("%-8.3f", scores[i]);
            }

            // Calculate average, printing it to Standard Output with nextline for next row
            double average = (scores[0] + scores[1] + scores[2]) / 3.0;
            StdOut.printf("|%-10.3f|", average);
            StdOut.println();
        }
    }
}
