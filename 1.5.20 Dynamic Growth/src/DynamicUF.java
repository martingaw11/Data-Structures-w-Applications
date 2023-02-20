/*
 * Martin Gawron 
 * 2/16/2023
 * By using a resizing array, implement a dynamic union find
 * that removes the restriction of needing a concrete number
 * of objects.
 * Do this by adding a new method : newSite() : returns int identifier
 * 
 * 2/20/2023
 * Revised the main method for testing if DynamicUF works or not,
 * results are located within .bin/results
 * This code will be commented out so that the main client can
 * be used to process just normal data not for testing
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
// Used to test output of DynamicUF
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;


/*
 * New implementation of Union Find that is altered for
 * dynamic growth.
 */
public class DynamicUF {
    private ArrayList<Integer> id;
    private ArrayList<Integer> sz;
    private int count = 0;

    // Basic creation of the new dynamic union find object
    public DynamicUF() {
        // JUST NEED TO INITIALIZE id and sz AS INTEGER ARRAYLISTS

        // these two will be added to by newSites()
        id = new ArrayList<Integer>();
        sz = new ArrayList<Integer>();
    }

    /*
     * new method for Union Find for dynamic growth, independent from size restriction
     * This function loops and adds all integers from end of existing id ArrayList to p (inclusive),
     * the assumption that all integers in between will be needed saves us function calls and
     * makes ArrayList easier to deal with as index of ID is correlated to the ID of object
     */
    public int newSite(int p) {
        // ADDING TO id AND sz FOR NEW ELEMENTS

        int currentSize = id.size();

        // starting at id.size() -- n+1 -- if last element is id.size() -- n
        // iterating through p, so that p is also added
        // incrementing by 1 so that all elements in between can be added
        for (int i = currentSize; i <= p; i++) {
            // essentially id[size() + n] = size() + n such that {id.size() <= n <= p}  <-- psuedo
            id.add(i);

            // is only connected to itself at first so size of component is 1
            sz.add(1);
        }

        // adding new components to the count
        count += p - currentSize + 1;

        // must return identifier, so will return the ID of new element/component
        return p;
    }

    // weighted quick union implmentation of root
    public int root(int i) {
        // RETURNS ROOT OF TREE

        // root will equal itself, iterating to find root
        while (i != id.get(i)) {
            // setting i equal to its parent for iterating up the tree
            i = id.get(i);
        }
        return i;
    }

    // same premise as the weight quick union implementation
    // instead uses the ArrayLists for dynamic growth
    public void union(int p, int q) {
        // JOINS TWO TREES, SMALL CONNECTED TO BIG TREE

        int max_id = Math.max(p, q);
        // checking to see if the greater of the two sites is within the bounds of existing sites,
        //  meaning this site might not exist yet
        if (max_id >= id.size()) {
            // if not already in existence, we will add it (and its predecessors) to id
            newSite(max_id);
        }
        // now we can continue to basic union since p and q definitely exist as sites

        // going to join p and q based on their roots
        int i = root(p);
        int j = root(q);

        // if already part of same tree, end method
        if (i == j) {
            return;
        }

        if (sz.get(i) < sz.get(j)) {
            // setting id[i] to j
            id.set(i, j);

            // adjusting size of root for new addition
            sz.set(j, sz.get(j) + sz.get(i));
        }
        else {
            // setting id[j] to i
            id.set(j, i);

            // adjusting size of root for new addition
            sz.set(i, sz.get(i) + sz.get(j));
        }

        // one less component now that they are connected
        count--;
    }

    // weighted quick union implementation of connected
    public boolean connected(int p, int q) {
        // CONNECTED IF P AND Q HAVE SAME ROOT (part of same tree)

        // return false is one of the sites is non-existent in ID
        if (Math.max(p, q) >= id.size()) {
            return false;
        }

        // return whether or not the sites exist in the same tree
        return root(p) == root(q);
    }

    // returns the number of components
    public int count() {
        return count;
    }


    public static void main(String[] args) throws Exception {
        //THIS CODE WAS USED TO GET THE RESULTS IN .bin/results FOR TESTING DynamicUF
        /*
        StdOut.printf("%-45s", "Weight Quick Union UF");
        StdOut.printf("%-38s", "Dynamic UF");
        StdOut.printf("%15s", "Test Check");
        StdOut.println("\n---------------------------------------------------------------------------------------------------");

        WeightedQuickUnionUF base = new WeightedQuickUnionUF(1024);
        DynamicUF testing = new DynamicUF();

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            String forBase;
            String forTest;
            if (base.find(p) == base.find(q)) {
                forBase = p + " already connected to " + q;
            }
            else {
                base.union(p, q);
                forBase = p + " connecting to " + q;
            }

            if (testing.connected(p, q)) {
                forTest = p + " already connected to " + q;
            }
            else {
                testing.union(p, q);
                forTest = p + " connecting to " + q;
            }
            StdOut.printf("%-45s", forBase);
            StdOut.printf("%-38s", forTest);
            if (forBase.equals(forTest)) {
                StdOut.printf("%15s", "Passed");
            }
            else {
                StdOut.printf("%15s", "Failed");
            }
            StdOut.println();
        }
        int baseCount = base.count();
        int testCount = testing.count();

        StdOut.printf("%-45s", baseCount + " components");
        StdOut.printf("%-38s", testCount + " components");

        if (baseCount == testCount) {
            StdOut.printf("%15s", "Passed");
        }
        else {
            StdOut.printf("%15s", "Failed");
        }
        */

        //THIS IS THE MAIN CLIENT CODE FOR DynamicUF
        
        DynamicUF network = new DynamicUF();

        // running until the end of the data file
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            // checking if p and q are already connected
            if (network.connected(p, q)) {
                StdOut.println(p + " already connected to " + q);
            }
            // if not, then we will connect p to q
            else {
                network.union(p, q);
                StdOut.println(p + " connecting to " + q);
            }
        }
        // printing out the number of components in our network
        StdOut.println(network.count() + " components");
        
    }
}
