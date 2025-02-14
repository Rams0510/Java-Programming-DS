class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertAtEnd(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtBeginning(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtMiddle(String data, int index) {
        if (index < 0 || index > sizeOfLL()) {
            System.out.println("Invalid index");
            return;
        }
        Node newNode = new Node(data);
        if (index == 0) {
            insertAtBeginning(data);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void updateNode(String val, int index) {
        if (index < 0 || index >= sizeOfLL()) {
            System.out.println("Invalid index");
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = val;
    }

    public void removeFirstNode() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public void removeLastNode() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= sizeOfLL()) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            removeFirstNode();
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void removeNode(String data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.data.equals(data)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Node not found");
        }
    }

    public int sizeOfLL() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.insertAtEnd("Node1");
        list.insertAtEnd("Node2");
        list.insertAtEnd("Node3");
        list.printLL();

        list.insertAtBeginning("Node0");
        list.printLL();

        list.insertAtMiddle("Node1.5", 2);
        list.printLL();

        list.updateNode("UpdatedNode1", 1);
        list.printLL();

        list.removeFirstNode();
        list.printLL();

        list.removeLastNode();
        list.printLL();

        list.removeAtIndex(1);
        list.printLL();

        list.removeNode("Node2");
        list.printLL();
    }
}
