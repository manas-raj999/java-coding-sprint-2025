import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MagicTicketMachine {
    public static ListNode doubleNumber(ListNode head) {
        if (head == null)
            return null;

        Stack<Integer> stack = new Stack<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        int carry = 0;
        ListNode result = null;

        while (!stack.isEmpty() || carry > 0) {
            int digit = stack.isEmpty() ? 0 : stack.pop();
            int doubled = digit * 2 + carry;

            carry = doubled / 10;
            ListNode newNode = new ListNode(doubled % 10);
            newNode.next = result;
            result = newNode;
        }

        return result;
    }

    public static void printList(ListNode head) {
        List<Integer> digits = new ArrayList<>();
        while (head != null) {
            digits.add(head.val);
            head = head.next;
        }
        System.out.println(digits);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter digits: ");
        String[] values = sc.nextLine().split(" ");

        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i]));
            current = current.next;
        }

        ListNode result = doubleNumber(head);
        printList(result);

        sc.close();
    }
}
