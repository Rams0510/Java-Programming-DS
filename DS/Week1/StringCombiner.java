public class StringCombiner {

    public static String combineStrings(String a, String b) {
        if (a.length() < b.length()) {
            return a + b + a;
        } else {
            return b + a + b;
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter the first string: ");
        String a = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String b = scanner.nextLine();

        System.out.println("Output: " + combineStrings(a, b));
        scanner.close();
    }
}
