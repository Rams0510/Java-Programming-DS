public class NumberCounter {

    public static int countNumbers(int num1, int num2, int num3, int num4, int num5, String type) {
        int count = 0;

        if (type.equalsIgnoreCase("even")) {
            if (num1 % 2 == 0) count++;
            if (num2 % 2 == 0) count++;
            if (num3 % 2 == 0) count++;
            if (num4 % 2 == 0) count++;
            if (num5 % 2 == 0) count++;
        } else if (type.equalsIgnoreCase("odd")) {
            if (num1 % 2 != 0) count++;
            if (num2 % 2 != 0) count++;
            if (num3 % 2 != 0) count++;
            if (num4 % 2 != 0) count++;
            if (num5 % 2 != 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int num1 = 12, num2 = 17, num3 = 19, num4 = 14, num5 = 115;

        String type = "odd";
        System.out.println("Output for type '" + type + "': " + countNumbers(num1, num2, num3, num4, num5, type));

        type = "even";
        System.out.println("Output for type '" + type + "': " + countNumbers(num1, num2, num3, num4, num5, type));
    }
}
