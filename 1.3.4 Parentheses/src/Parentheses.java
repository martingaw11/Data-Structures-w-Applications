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

public class Parentheses {
    private final String parentheses;
    private boolean isBalanced;

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

    public boolean isBalanced() {
        return isBalanced;
    }

    public String toString() {
        return parentheses;
    }


    public static void main(String[] args) throws Exception {
        while (StdIn.hasNextLine()) {
            String input = StdIn.readString();

            Parentheses testing = new Parentheses(input);
            StdOut.printf("%-25s", testing);
            StdOut.println(testing.isBalanced);
        }
    }
}
