public class SortedMergeDoublyCircularLinkedList {

    static Node mergeUtil(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node last1 = head1.prev;
        Node last2 = head2.prev;
        
        last1.next = last2.next = null;

        Node finalHead = null;
        if (head1.data < head2.data) {
            finalHead = head1;
            head1 = head1.next;
        } else {
            finalHead = head2;
            head2 = head2.next;
        }
        
        Node current = finalHead;
        
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1.prev = current;
                current = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2.prev = current;
                current = head2;
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            current.next = head1;
            head1.prev = current;
            current = head1;
            head1 = head1.next;
        }

        while (head2 != null) {
            current.next = head2;
            head2.prev = current;
            current = head2;
            head2 = head2.next;
        }

        current.next = finalHead;
        finalHead.prev = current;

        return finalHead;
    }

    static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.prev = head1;
        head1.next.next = new Node(5);
        head1.next.next.prev = head1.next;
        head1.next.next.next = head1;
        head1.prev = head1.next.next;

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.prev = head2;
        head2.next.next = new Node(6);
        head2.next.next.prev = head2.next;
        head2.next.next.next = head2;
        head2.prev = head2.next.next;

        Node mergedHead = mergeUtil(head1, head2);
        printList(mergedHead);
    }
}
