import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SplitLinkedList {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        int baseSize = len / k;
        int extraParts = len % k;
        
        ListNode[] result = new ListNode[k];
        curr = head;
        
        for (int i = 0; i < k && curr != null; i++) {
            result[i] = curr;
            int partSize = baseSize + (i < extraParts ? 1 : 0);
            
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        
        return result;
    }
    
    public static void printPart(ListNode head) {
        if (head == null) {
            System.out.print("[]");
            return;
        }
        
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(", ");
            head = head.next;
        }
        System.out.print("]");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter task values: ");
        String[] values = sc.nextLine().split(" ");
        
        ListNode head = null, tail = null;
        for (String val : values) {
            ListNode node = new ListNode(Integer.parseInt(val));
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        
        System.out.print("Enter number of parts (k): ");
        int k = sc.nextInt();
        
        ListNode[] parts = splitListToParts(head, k);
        
        for (int i = 0; i < parts.length; i++) {
            printPart(parts[i]);
            if (i < parts.length - 1) System.out.print(" , ");
        }
        System.out.println();
        
        sc.close();
    }
}{

}
