/*
 * Martin Gawron
 * 2/20/2023
 * This is a quick class made just to find out the max value within the provided
 * data so that I can effectively test the DynamicUF class to the standard
 * WeightedUnionUF that is provided by algs4
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * UFdata1.txt :: numSites = 30
 * UFdata2.txt :: numSites = 76
 * UFdata3.txt :: numSites = 225
 * UFdata4.txt :: numSites = 626
 * UFdata5.txt :: numSites = 1024
 */

public class maxVal {
    
    public static void main(String args[]) {
        int maxVal = 0;

        while (StdIn.hasNextLine()) {
            int firstVal = StdIn.readInt();
            if (firstVal > maxVal) {
                maxVal = firstVal;
            }
            int secondVal = StdIn.readInt();
            if (secondVal > maxVal) {
                maxVal = secondVal;
            }
        }

        StdOut.println(maxVal);
    }
}
