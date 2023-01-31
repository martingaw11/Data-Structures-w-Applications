/*
 * Martin Gawron
 * 01/30/2023
 * This is the implementation of the Transaction Class
 * This class stores the transaction of customer purchases
 */

public class Transaction implements Comparable<Transaction> {
    private final String name;
    private final double amount;
    private final Date dateOfPurchase;

    /*
     * Name is set as either one name, or first and last
     * Amount is a double that is passed with only two decimal places
     * Date is set as the Date class object for the date of the purchase
     */
    public Transaction(String n, double a, Date d) {
        name = n; amount = a; dateOfPurchase = d;
    }

    // Returning the name of the customer
    public String who() {
        return name;
    }

    // Returning the amount that they paid
    public double amount() {
        return amount;
    }

    // Returning the date of their purchase
    public Date when() {
        return dateOfPurchase;
    }

    // Formatting the String of this class
    // ex. "Martin Gawron has made a purchase of $76.90 on 1/28/2023"
    public String toString() {
        return name + " has made a purchase of $" + String.format("%.2f", amount) + " on " + dateOfPurchase;
    }

    // overridden method that determines whether two Transactions are equivalent
    public boolean equals(Object that) {
        if (that instanceof Transaction) {
            Transaction temp = (Transaction) that;
            return this.who() == temp.who() && this.amount() == temp.amount() && this.when() == temp.when();
        }
        return false;
    }

    // overriden method that compares two Transactions based on their amounts
    public int compareTo(Transaction that) {
        Double original = this.amount();
        Double other = that.amount();

        return original.compareTo(other);
    }

    // overriden method that returns the hashcode of Transaction
    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash += name.charAt(i) * Math.pow(31, name.length() - i + 1);
        }
        hash += ((Double)amount).hashCode();
        hash += dateOfPurchase.hashCode();
        return hash;
    }


    // Testing Client for Source Code
    public static void main(String[] args) throws Exception {
        // First test is creating single transaction with date, and printing the toString() to Standard Output
        Date dop = new Date(1, 28,  2023);
        Transaction test = new Transaction( "Martin Gawron", 76.90, dop);
        System.out.println(test);

        System.out.println();

        // Creating 3 more transactions of different names, amounts, and dates
        Transaction test1 = new Transaction("Elena Scott", 54.67, new Date(1, 30, 2023));
        Transaction test2 = new Transaction("John Smith", 81.99, new Date(12, 17, 2022));
        Transaction test3 = new Transaction("Mary McBeth", 103.15, new Date(8, 17, 2021));
        
        // Storing transactions in array to then be looped through printing the toStrings() of each
        Transaction[] testing = {test, test1, test2, test3};
        for (Transaction action : testing) {
            System.out.println(action);
        }

        System.out.println();

        // Looping through same array to test the individual function calls that return each piece of data
        for (Transaction action : testing) {
            System.out.println(action.who() + "\t" + action.amount + "\t" + action.when());
        }

        System.out.println();

        // Testing overriden methods equals(), compareTo(), hashCode()
        System.out.println(test1 == test2);
        System.out.println(test == testing[0]);
        System.out.println(test2.compareTo(test3));
        System.out.println(test3.compareTo(test2));
        System.out.println(test2.compareTo(testing[2]));
        System.out.println(test1.hashCode() + "\t" + test.hashCode());
        System.out.println(test3.hashCode() + "\t" + testing[3].hashCode());
    }
}