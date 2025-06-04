import java.util.*;

public class AvirupGift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String op = sc.next();
            if (op.equals("PUSH")) {
                String gift = sc.next();
                stack.push(gift);
                count.put(gift, count.getOrDefault(gift, 0) + 1);
            } else if (op.equals("POP")) {
                if (!stack.isEmpty()) {
                    String gift = stack.pop();
                    count.put(gift, count.get(gift) - 1);
                    if (count.get(gift) == 0) {
                        count.remove(gift);
                    }
                }
            } else if (op.equals("COUNT")) {
                if (stack.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(count.get(stack.peek()));
                }
            }

        }
    }
}
