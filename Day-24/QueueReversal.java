import java.util.*;

public class QueueReversal {
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }

        reverseQueue(queue);

        for (int i = 0; i < n; i++) {
            System.out.print(queue.poll());
            if (i < n - 1)
                System.out.print(" ");
        }
    }
}
