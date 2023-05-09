/*
 * Martin Gawron
 * 05/05/2023
 * Initial Start to 4.1.7 assignment
 * 
 */
//used to import files into In
import java.io.File;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class GraphClient {
    public static void main(String[] args) throws Exception {
        //importing the graph texts into In objects
        In tinyGText = new In(new File("src/tinyG.txt"));
        In graph1Text = new In(new File("src/graph1.txt"));
        In graph2Text = new In(new File("src/graph2.txt"));
        
        //then using the In objects to create each graph respectively
        Graph tinyGGraph = new Graph(tinyGText);
        Graph graph1 = new Graph(graph1Text);
        Graph graph2 = new Graph(graph2Text);

        //printing out the results of the graphs
        StdOut.println("tinyG.txt graph\n------------------\n" + tinyGGraph + "\n");
        StdOut.println("graph1.txt graph\n------------------\n" + graph1 + "\n");
        StdOut.println("graph2.txt graph\n------------------\n" + graph2 + "\n");
    }
}
