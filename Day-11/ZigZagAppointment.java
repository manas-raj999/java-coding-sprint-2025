import java.util.*;

public class ZigZagAppointment {
    public static List<Integer> zigzagReorder(int[] appointments) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = appointments.length - 1;
        boolean takeFromLeft = true;

        while (left <= right) {
            if (takeFromLeft) {
                result.add(appointments[left++]);
            } else {
                result.add(appointments[right--]);
            }
            takeFromLeft = !takeFromLeft;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] appointments1 = { 1, 2, 3, 4, 5 };
        System.out.println("Input: " + Arrays.toString(appointments1));
        System.out.println("Output: " + zigzagReorder(appointments1));

        int[] appointments2 = { 10, 20, 30, 40 };
        System.out.println("Input: " + Arrays.toString(appointments2));
        System.out.println("Output: " + zigzagReorder(appointments2));
    }
}
