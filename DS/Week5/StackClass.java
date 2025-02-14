import java.util.Stack;

class StackClass {
    private Stack<Integer> stack;

    public StackClass() {
        stack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
    }

    public int pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return -1;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public void show() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    public void bottomInsertion(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            int top = stack.pop();
            bottomInsertion(stack, element);
            stack.push(top);
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverse(stack);
        bottomInsertion(stack, top);
    }

    public static void main(String[] args) {
        StackClass sc = new StackClass();
        
        sc.push(1);
        sc.push(2);
        sc.push(3);
        sc.push(4);
        sc.push(5);

        System.out.println("Original Stack:");
        sc.show();

        sc.reverse(sc.stack);

        System.out.println("\nStack after Reversing:");
        sc.show();
    }
}
