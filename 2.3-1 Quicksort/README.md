# Quicksort

After learning about the more efficient quicksort, we created an airport class that would be sortable with the use of quicksort from algs4.

## Airport Class

This class takes in the following information about the airport:

- Airport Code
- Airport Name
- Airport Municipality
- Airport Region

Using the information there are the basic getter and setter functions for the class as well as overriding the toString() method and compareTo() method.
Specifically for the compareTo() we decided to have the airports be compared by Airport Code so when an array of airports gets quicksorted they airports will be sorted by ascending airport code.
