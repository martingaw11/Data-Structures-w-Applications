/*
 * Martin Gawron
 * 01/28/2023
 * This is the implementation of the Transaction Class
 * This class stores the transaction of customer purchases
 */

public class Transaction {
    private String name;
    private double amount;
    private Date dateOfPurchase;

    /*
     * Name is set as either one name, or first and last
     * Amount is a double that is passed with only two decimal places
     * Date is set as the Date class object for the date of the purchase
     */
    public Transaction(String n, double a, Date d) {
        name = n; amount = a; dateOfPurchase = d;
    }

    // Returning the name of the customer
    public String name() {
        return name;
    }

    // Returning the amount that they paid
    public double amount() {
        return amount;
    }

    // Returning the date of their purchase
    public Date date() {
        return dateOfPurchase;
    }

    // Formatting the String of this class
    // ex. "Martin Gawron has made a purchase of $50.99 on 1/28/2023"
    public String toString() {
        return name + " has made a purchase of $" + String.format("%.2f", amount) + " on " + dateOfPurchase;
    }

    
    public static void main(String[] args) throws Exception {
        Date dop = new Date(1, 28,  2023);
        Transaction test = new Transaction( "Martin Gawron", 76.90, dop);

        System.out.println(test);
    }
}