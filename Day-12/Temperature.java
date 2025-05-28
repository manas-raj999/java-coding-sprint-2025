import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int v) {
        val = v;
    }
}

public class Temperature {
    static ListNode sort(ListNode h) {
        if (h == null || h.next == null)
            return h;
        ListNode p = h, c = h.next;
        while (c != null) {
            if (c.val < 0) {
                p.next = c.next;
                c.next = h;
                h = c;
                c = p.next;
            } else {
                p = c;
                c = c.next;
            }
        }
        return h;
    }

    static void print(ListNode h) {
        while (h != null) {
            System.out.print(h.val + (h.next != null ? " -> " : ""));
            h = h.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter space-separated values:");
        String[] vals = sc.nextLine().split(" ");
        ListNode dummy = new ListNode(0), curr = dummy;
        for (String s : vals) {
            curr.next = new ListNode(Integer.parseInt(s));
            curr = curr.next;
        }
        ListNode h = dummy.next;
        System.out.println("Input:");
        print(h);
        h = sort(h);
        System.out.println("Sorted:");
        print(h);
    }
}
