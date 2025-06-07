import java.util.*;

public class lunchtime {
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }

        int top = 0;
        int rotations = 0;

        while (!queue.isEmpty() && rotations < queue.size()) {
            if (queue.peek() == sandwiches[top]) {
                queue.poll();
                top++;
                rotations = 0;
            } else {
                queue.offer(queue.poll());
                rotations++;
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }
        int[] sandwiches = new int[n];
        for (int i = 0; i < n; i++) {
            sandwiches[i] = sc.nextInt();
        }
        System.out.println(countStudents(students, sandwiches));
    }
}
