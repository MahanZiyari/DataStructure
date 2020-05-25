import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        System.out.println("infix form: " + prefixToInfix(prefix));
    }

    public static boolean isOperator(char c){
        return !Character.isLetterOrDigit(c);
    }

    public static String prefixToInfix(String exp){
        int length = exp.length();
        Stack<String> stack = new Stack<>();
        String op1, op2, temp;

        for (int i = length - 1; i >= 0; i--) {
            if (isOperator(exp.charAt(i))){
                op1 = stack.peek();
                stack.pop();
                op2  = stack.peek();
                stack.pop();

                stack.push("(" + op1 + exp.charAt(i) + op2 + ")" );
            }
            else {
                stack.push( String.valueOf(exp.charAt(i)) );
            }
        }
        return stack.peek();
    }
}
