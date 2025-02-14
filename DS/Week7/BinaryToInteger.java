class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class BinaryToInteger {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode current = head;
        
        while (current != null) {
            result = result * 2 + current.val;
            current = current.next;
        }
        
        return result;
    }

    public static void main(String[] args) {
        BinaryToInteger solution = new BinaryToInteger();
        
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(0);
        head1.next.next = new ListNode(1);
        
        System.out.println(solution.getDecimalValue(head1));
        
        ListNode head2 = new ListNode(0);
        
        System.out.println(solution.getDecimalValue(head2));
    }
}
