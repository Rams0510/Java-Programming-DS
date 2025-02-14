public class PadovanSequence {

    public static int padovan(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }
        return padovan(n - 2) + padovan(n - 3);
    }

    public static void main(String[] args) {
        int num = 10;

        System.out.println("Padovan Sequence up to " + num + ":");

        for (int i = 0; i <= num; i++) {
            System.out.print(padovan(i) + " ");
        }
    }
}
