import java.util.*;

public class PostfixToPrefixTransformer {
    public static String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (isOperator(c)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String prefix = c + operand1 + operand2;
                stack.push(prefix);
            } else {
                stack.push(String.valueOf(c));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String postfix = sc.nextLine();

        String prefix = postfixToPrefix(postfix);
        System.out.println(prefix);

        sc.close();
    }
}
