import java.util.ArrayList;
import java.util.List;

public class Main {
    //a list to store indexes of open and close parentheses
    static List<PairLocation> pairLocationList = new ArrayList<>();

    public static void main(String[] args) {
        String exp = "((2+1) - (4/2)) * (3-1)";
        if (checkParentheses(exp.toCharArray())){
            System.out.println("parentheses is balanced, here is the indexes:");
            print();
        }else
            System.out.println("parentheses is not balanced");
    }

    public static boolean checkParentheses(char[] exp){
        // an empty stack to stash parentheses
        List<Character> stack = new ArrayList<>();

        // traverse the expression to check parentheses
        for (int i = 0; i < exp.length; i++) {

            // pushing open parentheses into stack
            if (exp[i] == '('){
                stack.add(exp[i]);
                pairLocationList.add(new PairLocation(i, -1));
            }


            //poping open parentheses from the stack
            if (exp[i] == ')'){
                //if we see an ending parentheses without a pair, we returning false
                if (stack.isEmpty())
                    return false;
                //if stack is not empty, then we pop an open parentheses from it
                else{
                    stack.remove(stack.size()-1);
                    /* the first close parentheses is belong to the last open parentheses,
                    so we assign the index of the reached close parentheses to the last open parentheses with out a pair
                     */
                    for (int j = pairLocationList.size() - 1; j >= 0; j--) {
                        if (pairLocationList.get(j).getCloseIndex() == -1){
                            pairLocationList.get(j).setCloseIndex(i);
                            break;
                        }
                    }
                }
            }
        }
        //if there is something left in expression then there is a open parentheses without a closing one
        return stack.isEmpty() ? true : false;
    }

    public static void print(){
        for (PairLocation p :
                pairLocationList) {
            System.out.format("(%d , %d) ", p.getOpenIndex(), p.getCloseIndex());
        }
    }
}
