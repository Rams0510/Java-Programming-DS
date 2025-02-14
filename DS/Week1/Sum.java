import java.util.Scanner;

class AddLastDigitsFunction {
    int addLastDigits(int n1, int n2) {
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);

        int lastDigit1 = n1 % 10;
        int lastDigit2 = n2 % 10;

        return lastDigit1 + lastDigit2;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = scanner.nextInt();

        AddLastDigitsFunction obj = new AddLastDigitsFunction();

        System.out.println("The sum of the last digits is: " + obj.addLastDigits(n1, n2));
        scanner.close();
    }
}
