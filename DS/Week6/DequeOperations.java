import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeOperations {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        append(deque, 10);
        append(deque, 20);
        appendleft(deque, 5);

        System.out.println("Deque after append and appendleft: " + deque);
        System.out.println("Popped from right: " + pop(deque));
        System.out.println("Popped from left: " + popleft(deque));

        insert(deque, 1, 15);
        System.out.println("Deque after insert: " + deque);

        remove(deque, 15);
        System.out.println("Deque after remove: " + deque);
        System.out.println("Count of 10: " + count(deque, 10));
        System.out.println("Size of deque: " + len(deque));
        System.out.println("Front element: " + deque.peekFirst());
        System.out.println("Back element: " + deque.peekLast());

        extend(deque, new int[] {25, 30});
        System.out.println("Deque after extend: " + deque);

        extendleft(deque, new int[] {0, 2});
        System.out.println("Deque after extendleft: " + deque);

        reverse(deque);
        System.out.println("Deque after reverse: " + deque);

        rotate(deque, 2);
        System.out.println("Deque after rotate right by 2: " + deque);

        rotate(deque, -1);
        System.out.println("Deque after rotate left by 1: " + deque);

        System.out.println("Index of 10: " + index(deque, 10, 0, 4));
    }

    public static void append(Deque<Integer> deque, int value) {
        deque.offerLast(value);
    }

    public static void appendleft(Deque<Integer> deque, int value) {
        deque.offerFirst(value);
    }

    public static int pop(Deque<Integer> deque) {
        return deque.pollLast();
    }

    public static int popleft(Deque<Integer> deque) {
        return deque.pollFirst();
    }

    public static void insert(Deque<Integer> deque, int index, int value) {
        if (index < 0 || index > deque.size()) {
            System.out.println("Index out of range");
            return;
        }
        Iterator<Integer> iterator = deque.iterator();
        Deque<Integer> tempDeque = new ArrayDeque<>();
        int i = 0;
        while (iterator.hasNext()) {
            int elem = iterator.next();
            if (i == index) {
                tempDeque.add(value);
            }
            tempDeque.add(elem);
            i++;
        }
        if (index == deque.size()) {
            tempDeque.add(value);
        }
        deque.clear();
        deque.addAll(tempDeque);
    }

    public static void remove(Deque<Integer> deque, int value) {
        deque.removeFirstOccurrence(value);
    }

    public static int count(Deque<Integer> deque, int value) {
        int count = 0;
        for (int elem : deque) {
            if (elem == value) {
                count++;
            }
        }
        return count;
    }

    public static int len(Deque<Integer> deque) {
        return deque.size();
    }

    public static void extend(Deque<Integer> deque, int[] values) {
        for (int value : values) {
            deque.offerLast(value);
        }
    }

    public static void extendleft(Deque<Integer> deque, int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            deque.offerFirst(values[i]);
        }
    }

    public static void reverse(Deque<Integer> deque) {
        Deque<Integer> tempDeque = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            tempDeque.offerFirst(deque.pollFirst());
        }
        deque.addAll(tempDeque);
    }

    public static void rotate(Deque<Integer> deque, int n) {
        for (int i = 0; i < Math.abs(n); i++) {
            if (n > 0) {
                deque.offerFirst(deque.pollLast());
            } else {
                deque.offerLast(deque.pollFirst());
            }
        }
    }

    public static int index(Deque<Integer> deque, int value, int beg, int end) {
        int index = -1;
        int i = 0;
        for (int elem : deque) {
            if (i >= beg && i <= end && elem == value) {
                index = i;
                break;
            }
            i++;
        }
        return index;
    }
}
