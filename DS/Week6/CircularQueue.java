class CircularQueue {
    private int size;
    private int front, rear;
    private int[] queue;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = this.rear = -1;
    }

    public void enqueue(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = data;
            System.out.println(data + " enqueued to queue.");
        }
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            int data = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return data;
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            int i = front;
            while (true) {
                System.out.print(queue[i] + " ");
                if (i == rear) {
                    break;
                }
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        
        q.enqueue(60);
        
        q.display();

        System.out.println(q.dequeue() + " dequeued from queue.");

        q.display();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        System.out.println(q.dequeue());
    }
}
