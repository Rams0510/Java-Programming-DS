import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int topElement = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return topElement;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int topElement = queue1.peek();
        queue2.add(queue1.remove());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return topElement;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        System.out.println(stack.empty());
        
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
