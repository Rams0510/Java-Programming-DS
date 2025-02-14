import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedListOperations {
    Node head;
    int ctr;

    DoublyLinkedListOperations() {
        this.head = null;
        this.ctr = 0;
    }

    void insertBeg(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        ctr++;
    }

    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        ctr++;
    }

    void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        ctr--;
    }

    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }
        ctr--;
    }

    void insertPos(int pos, int data) {
        if (pos < 1 || pos > ctr + 1) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(data);
        if (pos == 1) {
            insertBeg(data);
        } else {
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        ctr++;
    }

    void deletePos(int pos) {
        if (pos < 1 || pos > ctr) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            deleteBeg();
        } else {
            Node temp = head;
            for (int i = 1; i < pos; i++) {
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
            ctr--;
        }
    }

    void traverseF() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void traverseR() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedListOperations list = new DoublyLinkedListOperations();

        list.insertBeg(10);
        list.insertBeg(20);
        list.insertBeg(30);
        System.out.print("After inserting at the beginning: ");
        list.traverseF();

        list.insertEnd(40);
        list.insertEnd(50);
        System.out.print("After inserting at the end: ");
        list.traverseF();

        list.insertPos(3, 35);
        System.out.print("After inserting 35 at position 3: ");
        list.traverseF();

        list.deleteBeg();
        System.out.print("After deleting from the beginning: ");
        list.traverseF();

        list.deleteEnd();
        System.out.print("After deleting from the end: ");
        list.traverseF();

        list.deletePos(2);
        System.out.print("After deleting at position 2: ");
        list.traverseF();

        System.out.print("Traversing in reverse: ");
        list.traverseR();
        scanner.close();
    }
}
