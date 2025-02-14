public class SecondLastDigit {

    public static int getSecondLastDigit(int number) {
        number = Math.abs(number);

        if (number < 10) {
            return -1;
        }

        int secondLastDigit = (number / 10) % 10;

        return secondLastDigit;
    }

    public static void main(String[] args) {
        System.out.println("Input: 197 -> Output: " + getSecondLastDigit(197));
        System.out.println("Input: 5 -> Output: " + getSecondLastDigit(5));
        System.out.println("Input: -197 -> Output: " + getSecondLastDigit(-197));
        System.out.println("Input: 0 -> Output: " + getSecondLastDigit(0));
        System.out.println("Input: -9 -> Output: " + getSecondLastDigit(-9));
    }
}
