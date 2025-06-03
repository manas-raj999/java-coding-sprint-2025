import java.util.*;

public class BalancedParenthesesChecker {
    public static int evalRPN(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                if (s.equals("+"))
                    stack.push(a + b);
                else if (s.equals("-"))
                    stack.push(a - b);
                else if (s.equals("*"))
                    stack.push(a * b);
                else
                    stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        System.out.println(evalRPN(arr));
        sc.close();
    }
}
