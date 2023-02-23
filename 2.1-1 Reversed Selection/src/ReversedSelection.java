/*
 * Martin Gawron 
 * 2/23/2023
 * Copying implementation of Example class from book,
 * adding modifications for generics and testing
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * This class is a result from using the Algs 4 skeleton for 
 * a sorting class located in Page 245 for their Example class.
 * This class however only used Comparable[] a or Comparable a
 * in its parameters.
 * I decided to fix this and correctly implement the generic with
 * no warnings. 
 * ie. adding "<E extends Comparable<E>>" and replacing Comparable with E
 * In general, I did not create this class, just lightly modified it for
 * generic types and for a Reversed Selection Sort
 */
public class ReversedSelection {
    
    public static <E extends Comparable<E>> void sort(E[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

    /*
     * In terms of real change, I changed the less method from
     * :: return v.compareTo(w) < 0; ::
     * to
     * :: return v.compareTo(w) > 0; ::
     * so that we check a value greater than not less.
     * This then changes the entire class, instead of it being a normal
     * selection sort, the change makes it into a reversed selection sort.
     */
    private static <E extends Comparable<E>> boolean less(E v, E w) {
        return v.compareTo(w) > 0;
    }

    private static <E extends Comparable<E>> void exchange(E[] a, int i, int j) {
        E t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // instead of using the show method provided, I formatted my own output in main
    private static <E extends Comparable<E>> void show(E[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }


    /*
     * main method displays how this class can be used for any data type that
     * implements Comparable.
     * First I used the String data type for src/StringValues.txt to get results in bin/results/StringsOutput.txt
     * Then I used the Double data type for src/DoubleValues.txt to get results in bin/results/DoublesOutput.txt
     * 
     * The only changes between the two were made in the main method, meaning this class
     * can be used for any data type implementing Comparable, this class supports generics.
     */
    public static void main(String[] args) throws Exception {
        // THE MAIN METHOD PRIMARILY RUNS WITH STRINGS

        // reading in all strings and creating copy for comparison
        String[] original = StdIn.readAllStrings();
        String[] toBeSorted = original.clone();
        // sorting one array
        sort(toBeSorted);
        assert isSorted(toBeSorted);

        // printing original and sorted for comparison
        StdOut.printf("%-25s", "Original");
        StdOut.printf("%-25s", "Reverse Order");
        StdOut.println("\n------------------------------------------------");
        for (int i = 0; i < original.length; i++) {
            StdOut.printf("%-25s", original[i]);
            StdOut.printf("%-25s", toBeSorted[i]);
            StdOut.println();
        }
        
        // THIS WAS USED TO PRODUCE THE TEST FOR DOUBLES
        // shows that the methods can be used with any object type, implementation is generic
        /*
        double[] init = StdIn.readAllDoubles();
        Double[] original = new Double[init.length];
        for (int i = 0; i < init.length; i++) {
            original[i] = init[i];
        }
        Double[] toBeSorted = original.clone();
        sort(toBeSorted);
        assert isSorted(toBeSorted);

        StdOut.printf("%-25s", "Original");
        StdOut.printf("%-25s", "Reverse Order");
        StdOut.println("\n------------------------------------------------");
        for (int i = 0; i < original.length; i++) {
            StdOut.printf("%-25f", original[i]);
            StdOut.printf("%-25f", toBeSorted[i]);
            StdOut.println();
        }
        */
    }
}
