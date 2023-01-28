/*
 * This is an implementation of the Date class that was given in the textbook
 * Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne
 */

public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y) {
        month = m; day = d; year = y;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }
}
