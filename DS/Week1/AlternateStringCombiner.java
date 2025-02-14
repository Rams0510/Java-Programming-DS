public class AlternateStringCombiner {

    public static String combineStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        while (i < a.length() && j < b.length()) {
            result.append(a.charAt(i++));
            result.append(b.charAt(j++));
        }

        while (i < a.length()) {
            result.append(a.charAt(i++));
        }

        while (j < b.length()) {
            result.append(b.charAt(j++));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";
        System.out.println("Input: \"" + a + "\", \"" + b + "\"");
        System.out.println("Output: \"" + combineStrings(a, b) + "\"");

        a = "Iare";
        b = "College";
        System.out.println("Input: \"" + a + "\", \"" + b + "\"");
        System.out.println("Output: \"" + combineStrings(a, b) + "\"");
    }
}
