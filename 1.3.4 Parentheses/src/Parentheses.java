/*
 * Martin Gawron
 * 2/01/2023
 * This is a class that acts the main method for a program that takes in
 * a string of parentheses and determines whether the parentheses are
 * properly balanced. This is done by creating a Parentheses object
 * for each string, and this object will store the string and a bool value
 * of whether it is balanced or not.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;

/*
 * The class Parentheses stores the initial string of '(){}[]' chars,
 * upong construction the class stores the single parameter string, 
 * and then uses that string to determine if it is balanced and stores
 * that into the isBoolean variable. The entire process could have been
 * written as a single function, but for java and organization purposes,
 * an object is created that stores these attribute values for each instance.
 */
public class Parentheses {
    // String parentheses is final since it will never change once it is assigned
    private final String parentheses;
    private boolean isBalanced;

    /*
     * Constructor takes in the string of chars '(){}[]' and stores it in String parentheses
     * Then it determines whether the parentheses is balanced or not and stores that in boolean isBalanced
     */
    public Parentheses(String parentheses) {
        this.parentheses = parentheses;

        // Creating a stack for the parentheses '({[' as we encounter them in the string
        Stack<Character> leftHand = new Stack<Character>();

        // Looping through each character to determine whether the string is balanced
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);

            // Determing if the current character is in '({[' and adding it to end of stack
            if (c == '(' || c == '{' || c == '[') {
                leftHand.push(c);
            }
            // If the character is not in '({[' then it must be in ')}]'
            else {
                // If stack is empty, then there is no '({[' to pair up with a ')}]' respectively
                if (leftHand.isEmpty()) {
                    // So we set isBalanced to false and break since this case won't change for future characters
                    isBalanced = false;
                    break;
                }
                // But the stack may not be empty
                else {
                    char left = leftHand.pop();
                    // In this case we pop the last character, and check whether it matches up to the current
                    // character with the two being a pair of '()' or '{}' or '[]'
                    if ((left == '(' && c == ')') || (left == '[' && c == ']') || (left == '{' && c == '}')) {
                        // Since they do match up, we will set isBalanced to True for now
                        isBalanced = true;
                    }
                    else {
                        // If they do not match up, we set isBalanced to false and break since future characters
                        // will not change the outcome
                        isBalanced = false;
                        break;
                    }
                }
            }
        }

        // After iterating through the entire string and isBalanced is still true,
        // we must check is the stack is empty, if it is not that means we still
        // had some '({[' left over and the string of parentheses was not balanced.
        if (isBalanced && !leftHand.isEmpty()) {
            isBalanced = false;
        }
    }

    // Returns if the string is balanced or not
    public boolean isBalanced() {
        return isBalanced;
    }

    // Returns the String parentheses as this is basically the identity of the class
    public String toString() {
        return parentheses;
    }


    /*
     * Test client for the class. A text file of various different parenthetical strings
     * is passed as an argument. Eachline is used to create a Parentheses object, which 
     * stores if it is balanced as a class attribute. This is then used to print to 
     * Standard Output to show if the string is balanced.
     */
    public static void main(String[] args) throws Exception {
        // Looping through each line of the text file and checking if string is balanced
        while (StdIn.hasNextLine()) {
            String input = StdIn.readString();

            // Creating a Parentheses object which process the string and determines if it is balanced
            Parentheses testing = new Parentheses(input);

            // Using the Parentheses object, we print out the string and whether it is balanced in a formatted manner
            StdOut.printf("%-25s", testing);
            StdOut.println(testing.isBalanced);
        }
    }
}
