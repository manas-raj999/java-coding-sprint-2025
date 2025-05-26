class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class CycleDetection {
    public static boolean detectAndRemoveCycle(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeCycle(head, slow);
                return true;
            }
        }

        return true;
    }

    private static void removeCycle(ListNode head, ListNode meetingPoint) {
        ListNode start = head;

        if (start == meetingPoint) {
            while (meetingPoint.next != start) {
                meetingPoint = meetingPoint.next;
            }
            meetingPoint.next = null;
            return;
        }

        while (start.next != meetingPoint.next) {
            start = start.next;
            meetingPoint = meetingPoint.next;
        }

        meetingPoint.next = null;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);
        head1.next.next.next = head1.next;

        System.out.println("Example 1 - With cycle:");
        System.out.println("Result: " + detectAndRemoveCycle(head1));
        System.out.print("After removal: ");
        printList(head1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(8);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        System.out.println("\nExample 2 - No cycle:");
        System.out.println("Result: " + detectAndRemoveCycle(head2));
        System.out.print("List: ");
        printList(head2);
    }
}
