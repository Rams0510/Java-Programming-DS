import java.util.Scanner;

public class LinearQueue {
    static final int MAX = 5;
    static int front = 0;
    static int rear = 0;
    static int[] queue = new int[MAX];

    public static boolean isEmpty() {
        return front == rear;
    }

    public static boolean isFull() {
        return rear == MAX;
    }

    public static void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
        } else {
            queue[rear] = item;
            rear++;
            System.out.println("Enqueued: " + item);
        }
    }

    public static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
        } else {
            int dequeuedItem = queue[front];
            front++;
            System.out.println("Dequeued: " + dequeuedItem);
        }
    }

    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i < rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, item;

        while (true) {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item to enqueue: ");
                    item = sc.nextInt();
                    enqueue(item);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
