public class MultipleChecker {

    public static int checkMultiple(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 3;
        }

        if (num1 % num2 == 0) {
            return 2;
        }

        return 1;
    }

    public static void main(String[] args) {
        int num1 = 10, num2 = 5;
        System.out.println("Input: num1 = " + num1 + ", num2 = " + num2 + " -> Output: " + checkMultiple(num1, num2));

        num1 = -10;
        num2 = 5;
        System.out.println("Input: num1 = " + num1 + ", num2 = " + num2 + " -> Output: " + checkMultiple(num1, num2));

        num1 = 0;
        num2 = 5;
        System.out.println("Input: num1 = " + num1 + ", num2 = " + num2 + " -> Output: " + checkMultiple(num1, num2));

        num1 = 10;
        num2 = 3;
        System.out.println("Input: num1 = " + num1 + ", num2 = " + num2 + " -> Output: " + checkMultiple(num1, num2));
    }
}
