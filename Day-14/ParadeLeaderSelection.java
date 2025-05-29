import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ParadeLeaderSelection {
    public static List<Integer> findMiddleToEnd(ListNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null)
            return result;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            result.add(slow.val);
            slow = slow.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter badge numbers: ");
        String[] values = sc.nextLine().split(" ");

        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i]));
            current = current.next;
        }

        List<Integer> result = findMiddleToEnd(head);
        System.out.println(result);

        sc.close();
    }
}
