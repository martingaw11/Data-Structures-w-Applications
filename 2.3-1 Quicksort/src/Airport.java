/*
 * Martin Gawron
 * 3/22/2023
 * Initial start to project: Creating airplane class
 * Wrote main client to test sorting of Comparables: Doubles, Strings, Airport(custom)
 */

import java.util.Scanner;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

public class Airport implements Comparable<Airport>{
    private String code;
    private String name;
    private String municipality;
    private String region;

    Airport(String code, String name, String municipality, String region) {
        this.code = code;
        this.name = name;
        this.municipality = municipality;
        this.region = region;
    }


    @Override
    public String toString() {
        return this.code + "\t" + this.name + "\t" + this.municipality + "\t" + this.region;
    }

    @Override
    public int compareTo(Airport that) {
        return this.code.compareTo(that.code);
    }


    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        /* Used for String input
        String[] listing = new String[40];
        
        int i = 0;
        while (input.hasNextLine()) {
            String next = input.next();
            listing[i++] = next;
            StdOut.println(listing[i-1]);
            if (!input.hasNext()) {break;}
        }

        Quick.sort(listing);
        StdOut.println();

        for (String element: listing) {
            StdOut.println(element);
        }
        */

        /* Used for Double input
        Double[] listing = new Double[43];
        
        int i = 0;
        while (input.hasNextLine()) {
            Double next = input.nextDouble();
            listing[i++] = next;
            StdOut.println(listing[i-1]);
            if (!input.hasNext()) {break;}
        }

        Quick.sort(listing);
        StdOut.println();

        for (Double element: listing) {
            StdOut.println(element);
        }
        */

        input.useDelimiter("\n|\t");

        Airport[] test = new Airport[37];

        int i = 0;
        while (input.hasNextLine()) {
            if (!input.hasNext()) {break;}

            String code = input.next();
            String name = input.next();
            String municipality = input.next();
            String region = input.next();

            Airport next = new Airport(code, name, municipality, region);
            StdOut.println(next);
            test[i++] = next;
        }

        Quick.sort(test);
        StdOut.println();

        for (Airport loc: test) {
            StdOut.println(loc);
        }

        input.close();
    }
}
