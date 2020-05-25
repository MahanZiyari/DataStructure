import java.util.Stack;

public class Main {

    public static void main(String args[]) {
        // Driver code
        String exp = "BCD++AT/-";
        System.out.println("infix form: " + getInfix(exp));
    }

    // Get Infix for a given postfix expression
    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
    }

    static String getInfix(String exp) {
        Stack<String> s = new Stack<String>();

        for (int i = 0; i < exp.length(); i++) {
            // Push operands
            if (isOperand(exp.charAt(i))) {
                s.push(exp.charAt(i) + "");
            }

            // We assume that input is a valid postfix and expect an operator.
            else {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push("(" + op2 + exp.charAt(i) +
                        op1 + ")");
            }
        }//end of for

        // There must be a single element in stack now which is the required infix.
        return s.peek();
    }
}
