/*
 * Martin Gawron
 * 3/22/2023
 * Initial start to project: Creating airplane class
 * Wrote main client to test sorting of Comparables: Doubles, Strings, Airport(custom)
 * 
 * 3/28/2023
 * Making Airport class complete by adding accessor/mutator methods as well as commenting
 */

import java.util.Scanner;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

/*
 * Airport implements comparable and stores the basic information
 * that is needed to know about a specific airport such as its 
 * corresponding code, name of airport, municipality and region in
 * which it is located
 */
public class Airport implements Comparable<Airport>{
    private String code;
    private String name;
    private String municipality;
    private String region;

    //Constructor taking in code, name, municipality, and region of the airport
    Airport(String code, String name, String municipality, String region) {
        this.code = code;
        this.name = name;
        this.municipality = municipality;
        this.region = region;
    }

    //MUTATOR Methods
    public void code(String code) {
        this.code = code;
    }

    public void name(String name) {
        this.name = name;
    }

    public void municipality(String municipality) {
        this.municipality = municipality;
    }

    public void region(String region) {
        this.region = region;
    }

    //ACCESSOR Methods
    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getMunicipality() {
        return this.municipality;
    }

    public String getRegion() {
        return this.region;
    }

    @Override
    public String toString() {
        return this.code + "\t" + this.name + "\t" + this.municipality + "\t" + this.region;
    }

    @Override
    public int compareTo(Airport that) {
        return this.code.compareTo(that.code);
    }


    //TEST CLIENT FOR THE AIRPORT CLASS
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //giving pattern so that next lines and tabs are used to separate data for file
        input.useDelimiter("\n|\t");

        Airport[] test = new Airport[37];

        int i = 0;
        //running loop until we don't have next line
        while (input.hasNextLine()) {
            //loop will break if current line has no content to be extracted
            if (!input.hasNext()) {break;}

            //getting the necessary data for the creation of airport
            String code = input.next();
            String name = input.next();
            String municipality = input.next();
            String region = input.next();

            //creating the airport to be stored in the array
            Airport next = new Airport(code, name, municipality, region);
            
            //making test[i] the airport and then iterating i by 1 for the next one after
            test[i++] = next;
        }

        //sorting our airport array, compareTo makes it sorted by airport code
        Quick.sort(test);

        //Printing out the sorted airport array
        for (Airport loc: test) {
            StdOut.print(loc);
        }

        input.close();
    }
}
