/*
 * Martin Gawron
 * 02/14/2023
 * CSC-280-350
 * Assignment: 1.4.0 A Observing Elapsed Time
 */

// imported Stopwatch from algs4 rather copying Stopwatch data type into seperate class
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;

public class StopwatchClient {
    /*
     * This is the implementation copied from the PrimeNumbers.html file given to
     * us for the assignment. Slight adjustment was made where the parameter of 
     * upper bounds for the search are passed for a method call.
     */
    public static int PrimeNumbers(int n) {
        // Find all prime numbers <= n

        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        // Repeatedly find prime numbers
        while (number <= n) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // ClosestPair if number is prime
            for (int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false          
                    break; // Exit the for loop
                }
            }

            // Increase count
            if (isPrime) {
                count++; // Increase the count
            }

            // Check if the next number is prime
            number++;
        }

        return count;
    }

    /*
     * This is the implementation copied from the EfficientPrimeNumbers.html file given to
     * us for the assignment. Slight adjustment was made where the parameter of 
     * upper bounds for the search are passed for a method call.
     */
    public static int EfficientPrimeNumbers(int n) {
        // Find all prime numbers <= n

        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness
        int squareRoot = 1; // Check whether number <= squareRoot

        java.util.List<Integer> list = new java.util.ArrayList<>();

        // Not needed for the intended method use
        // System.out.println("The prime numbers are \n");

        // Repeatedly find prime numbers
        while (number <= n) {
        // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            if (squareRoot * squareRoot < number) {
                squareRoot++;
            }

            // Test whether number is prime
            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
                if (number % list.get(k) == 0) { // If true, not prime
                    isPrime = false; // Set isPrime to false          
                    break; // Exit the for loop
                }
            }

            // increase the count
            if (isPrime) {
                count++; // Increase the count
                list.add(number);
            }

            // Check if the next number is prime
            number++;
        }

        return count;
    }
    
    /*
     * This is the test client of StopwatchClient, the main method is to run
     * each method for different upper bounds of search for prime numbers,
     * a stopwatch from Algs4 is used to see how much time it takes for the 
     * method to return the correct value. The results are printed in a table 
     * formatted so that the time values can be compared and the time complexity
     * can be analyzed.
     */
    public static void main(String[] args) throws Exception {
        int size = 8000000;
        /* WAS USED TO COMPARE METHOD OUTPUTS
        for (int i = 0; i < 6; i++) {
            int delta = 2000000 * i;
            StdOut.print(PrimeNumbers(size+delta) + "\t");
        }
        StdOut.println();
        for (int i = 0; i < 6; i++) {
            int delta = 2000000 * i;
            StdOut.print(EfficientPrimeNumbers(size+delta) + "\t");
        }
        */

        StdOut.println("\n");

        // formatting table header showing upper bounds of each function call
        StdOut.printf("%30s", " ");
        for (int i = 0; i < 6; i++) {
            int delta = 2000000 * i;
            StdOut.print("|");
            StdOut.printf("%10d", size+delta);
        }

        StdOut.println();
        for (int i = 0; i < 96; i ++) {
            StdOut.print("-");
        }

        // for loop goes through and finds how long it takes for the PrimeNumbers
        //  method to find the number of prime numbers in the upper bounds passed
        // and then formatted to show the time(seconds) to the thousandths
        StdOut.println();
        StdOut.printf("%-30s", "Prime Numbers");
        for (int i = 0; i < 6; i++) {
            int delta = 2000000 * i;
            StdOut.print("|");
            Stopwatch timer = new Stopwatch();
            PrimeNumbers(size+delta);
            double time = timer.elapsedTime();
            StdOut.printf("%10s", ((Double)time).toString());
        }

        // same as loop before but this time running upper bounds to the
        // EfficientPrimeNumbers method to input the time it takes to find the 
        // number of prime numbers within the argument and formats it into the table
        StdOut.println();
        StdOut.printf("%-30s", "Efficient Prime Numbers");
        for (int i = 0; i < 6; i++) {
            int delta = 2000000 * i;
            StdOut.print("|");
            Stopwatch timer = new Stopwatch();
            EfficientPrimeNumbers(size+delta);
            double time = timer.elapsedTime();
            StdOut.printf("%10s", ((Double)time).toString());
        }
        StdOut.println("\n");

        // As you can see from the output, EfficientPrimeNumbers is considerably faster
    }
}
