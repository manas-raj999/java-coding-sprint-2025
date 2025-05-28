import java.util.*;

class DoublyListNode {
    int val;
    DoublyListNode prev, next;

    DoublyListNode(int val) {
        this.val = val;
    }
}

public class SortDoublyLinkedList {
    public static DoublyListNode mergeSort(DoublyListNode head) {
        if (head == null || head.next == null) return head;
        
        DoublyListNode mid = getMiddle(head);
        DoublyListNode nextOfMid = mid.next;
        
        mid.next = null;
        nextOfMid.prev = null;
        
        DoublyListNode left = mergeSort(head);
        DoublyListNode right = mergeSort(nextOfMid);
        
        return merge(left, right);
    }
    
    private static DoublyListNode getMiddle(DoublyListNode head) {
        DoublyListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private static DoublyListNode merge(DoublyListNode left, DoublyListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        
        if (left.val <= right.val) {
            left.next = merge(left.next, right);
            if (left.next != null) left.next.prev = left;
            left.prev = null;
            return left;
        } else {
            right.next = merge(left, right.next);
            if (right.next != null) right.next.prev = right;
            right.prev = null;
            return right;
        }
    }
    
    public static void printList(DoublyListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" <-> ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        
        if (n == 0) return;
        
        System.out.print("Enter values: ");
        DoublyListNode head = new DoublyListNode(sc.nextInt());
        DoublyListNode current = head;
        
        for (int i = 1; i < n; i++) {
            DoublyListNode node = new DoublyListNode(sc.nextInt());
            current.next = node;
            node.prev = current;
            current = node;
        }
        
        head = mergeSort(head);
        printList(head);
        
        sc.close();
    }
}{

}
