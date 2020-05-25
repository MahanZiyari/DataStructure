import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String infix = "B+(c+d)-A/T";
        System.out.println("prefix form: " + infixToPrefix(infix));
    }

    public static boolean isOperator(char c){
        if (!Character.isLetterOrDigit(c))
            return true;
        return false;
    }

    public static int getPriority(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);

                // If the scanned character is an ')', pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())){
                    if(stack.peek() == '(')
                        return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    public static String infixToPrefix(String infix){
        int length = infix.length();

        infix = reverseString(infix);
        char[] chars = infix.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '(')
                chars[i] = ')';
            else if (chars[i] == ')')
                chars[i] = '(';
        }
        infix = String.valueOf(chars);
        String prefix = infixToPostfix(infix);
        return reverseString(prefix);
    }

    public static String reverseString(String exp){
        char temp;
        char[] chars = exp.toCharArray();
        int i, j;
        for (i = 0, j = exp.length() - 1; i <= j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        exp  = String.valueOf(chars);
        return exp;
    }
}
