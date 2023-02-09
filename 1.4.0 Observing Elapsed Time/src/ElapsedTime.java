import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;

public class ElapsedTime {
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
    

    public static void main(String[] args) throws Exception {
        int size = 8000000;
        for (int i = 0; i < 6; i++) {
            int delta = 2000000 * i;
            StdOut.print(PrimeNumbers(size+delta) + "\t");
        }
        StdOut.println();
        for (int i = 0; i < 6; i++) {
            int delta = 2000000 * i;
            StdOut.print(EfficientPrimeNumbers(size+delta) + "\t");
        }
        StdOut.println("\n\n");

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
    }
}
