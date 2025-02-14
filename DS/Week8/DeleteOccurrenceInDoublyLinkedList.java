class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DeleteOccurrenceInDoublyLinkedList {

    // Helper function to delete a node from the doubly linked list
    static void deleteNode(Node head_ref, Node nodeToDelete) {
        if (head_ref == null || nodeToDelete == null) {
            return;
        }

        // If the node to be deleted is the head node
        if (head_ref == nodeToDelete) {
            head_ref = nodeToDelete.next;
        }

        // If the node to be deleted is not the last node
        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = nodeToDelete.prev;
        }

        // If the node to be deleted is not the first node
        if (nodeToDelete.prev != null) {
            nodeToDelete.prev.next = nodeToDelete.next;
        }

        nodeToDelete = null;  // Remove reference to the node to be deleted
    }

    // Function to delete all occurrences of key x in the doubly linked list
    static Node deleteAllOccurOfX(Node head, int x) {
        if (head == null) {
            return null;
        }

        Node current = head;
        Node next = null;

        // Traverse the list
        while (current != null) {
            next = current.next;  // Save next node

            // If current node contains data equal to x, delete it
            if (current.data == x) {
                deleteNode(head, current);
            }

            current = next;
        }

        return head;
    }

    // Helper function to print the doubly linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case: Create a doubly linked list with some nodes
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(10);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(8);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        
        // Print the original list
        System.out.print("Original List: ");
        printList(head);

        // Delete all occurrences of key 2
        head = deleteAllOccurOfX(head, 2);
        
        // Print the modified list
        System.out.print("Modified List: ");
        printList(head);
    }
}
