public class CircularLinkedList {
    
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedListOperations {

        public Node insertAtBeginning(Node head, int data) {
            Node newNode = new Node(data);

            if (head == null) {
                newNode.next = newNode;
                return newNode;
            }

            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
            return newNode;
        }

        public Node insertAtEnd(Node head, int data) {
            Node newNode = new Node(data);

            if (head == null) {
                newNode.next = newNode;
                return newNode;
            }

            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
            return head;
        }

        public Node addAfter(Node head, int data, int item) {
            Node temp = head;
            while (temp != null) {
                if (temp.data == item) {
                    Node newNode = new Node(data);
                    newNode.next = temp.next;
                    temp.next = newNode;
                    return head;
                }
                temp = temp.next;
                if (temp == head) {
                    break;
                }
            }
            System.out.println("Node with value " + item + " not found!");
            return head;
        }

        public Node deleteNode(Node last, int key) {
            if (last == null) {
                System.out.println("List is empty!");
                return null;
            }

            Node temp = last;
            if (temp.data == key) {
                if (temp.next == last) {
                    return null;
                }
                while (temp.next != last) {
                    temp = temp.next;
                }
                temp.next = last.next;
                return last.next;
            }

            while (temp.next != last) {
                if (temp.next.data == key) {
                    temp.next = temp.next.next;
                    return last;
                }
                temp = temp.next;
            }
            System.out.println("Node with value " + key + " not found!");
            return last;
        }

        public void printList(Node head) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedListOperations listOps = new CircularLinkedListOperations();
        Node head = null;

        head = listOps.insertAtBeginning(head, 10);
        head = listOps.insertAtBeginning(head, 20);
        head = listOps.insertAtBeginning(head, 30);

        System.out.print("Circular Linked List after insertion at the beginning: ");
        listOps.printList(head);

        head = listOps.insertAtEnd(head, 40);
        head = listOps.insertAtEnd(head, 50);

        System.out.print("Circular Linked List after insertion at the end: ");
        listOps.printList(head);

        head = listOps.addAfter(head, 35, 30);

        System.out.print("Circular Linked List after inserting 35 after 30: ");
        listOps.printList(head);

        head = listOps.deleteNode(head, 40);

        System.out.print("Circular Linked List after deleting 40: ");
        listOps.printList(head);

        head = listOps.deleteNode(head, 30);

        System.out.print("Circular Linked List after deleting 30: ");
        listOps.printList(head);

        head = listOps.deleteNode(head, 100);
    }
}
