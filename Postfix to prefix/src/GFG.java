// Java Program to convert postfix to prefix
import java.util.*;

public class GFG {

    // Driver Code
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String post_exp = "ABC/-AK/L-*";
        System.out.print("please enter a correct Postfix expression: ");
        post_exp = input.nextLine();
        System.out.println("Prefix : " + postfixToPrefix(post_exp));
    }


    // function to check if character is operator or not
    static boolean isOperator(char x)
    {

        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    // Convert postfix to Prefix expression
    static String postfixToPrefix(String post_exp)
    {
        Stack<String> stack = new Stack<String>();

        // length of expression
        int length = post_exp.length();

        // reading from right to left
        for (int i = 0; i < length; i++) {

            // check if symbol is operator
            if (isOperator(post_exp.charAt(i))) {

                // pop two operands from stack
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();

                // concat the operands and operator
                String temp = post_exp.charAt(i) + op2 + op1;

                // Push String temp back to stack
                stack.push(temp);
            }

            // if symbol is an operand
            else {

                // push the operand to the stack
                stack.push(post_exp.charAt(i) + "");
            }
        }

        // stack[0] contains the Prefix expression
        return stack.peek();
    }

}

