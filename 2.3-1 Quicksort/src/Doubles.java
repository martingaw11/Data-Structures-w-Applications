/*
 * Martin Gawron
 * 3/28/2023
 * 
 * init: adding this to show that we can use ArrayList
 * for a dynamic array size and then pass that info into
 * Quick.java to be sorted. Array size will not be known 
 * before hand
 */
import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

/*
 * This is just supposed to be a test client, not a doubles object class
 */
public class Doubles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Starting out with arraylist to dynamically store doubles
        ArrayList<Double> test = new ArrayList<>();
        StdOut.println("UnOrdered Doubles");

        //loop through entire input
        while (sc.hasNextLine()) {
            //will break to avoid trying to extract from empty line
            if (!sc.hasNext()) { break; }
            double input = sc.nextDouble();

            test.add(input);

            StdOut.println(input);
        }

        //making an array of Doubles the size of our arraylist and adding
        //said Doubles so that we can pass the data into Quick.java
        Double[] sortable = new Double[test.size()];
        int i = 0;
        for (Double dub: test) {
            sortable[i++] = dub;
        }

        //sorting our array
        Quick.sort(sortable);

        StdOut.println("\nOrdered Doubles");
        for (Double dub: sortable) {
            StdOut.println(dub);
        }

        sc.close();
    }
}
