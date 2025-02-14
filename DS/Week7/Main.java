class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next = new ListNode(6);
        
        ListNode result1 = solution.removeElements(head1, 6);
        printList(result1);

        ListNode head2 = null;
        ListNode result2 = solution.removeElements(head2, 1);
        printList(result2);

        ListNode head3 = new ListNode(7);
        head3.next = new ListNode(7);
        head3.next.next = new ListNode(7);
        head3.next.next.next = new ListNode(7);
        
        ListNode result3 = solution.removeElements(head3, 7);
        printList(result3);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
