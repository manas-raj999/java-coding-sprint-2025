import java.util.*;

class Node {
    int val;
    Node next;

    Node(int v) {
        val = v;
    }
}

public class Color {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node d = new Node(0), t = d;
        while (sc.hasNextInt())
            t = t.next = new Node(sc.nextInt());
        int[] c = new int[3];
        for (Node n = d.next; n != null; n = n.next)
            c[n.val]++;
        for (Node n = d.next; n != null; n = n.next)
            n.val = c[0]-- > 0 ? 0 : c[1]-- > 0 ? 1 : 2;
        for (Node n = d.next; n != null; n = n.next)
            System.out.print(n.val + (n.next != null ? " → " : ""));
    }
}
