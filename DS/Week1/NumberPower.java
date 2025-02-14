public class NumberPower {
    public static long powerOfReverse(int N, int R) {
        final int MOD = 1000000007;
        
        long result = 1;
        long base = N % MOD;
        
        while (R > 0) {
            if (R % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            R /= 2;
        }
        
        return result;
    }

    public static void main(String[] args) {
        int N1 = 2, R1 = 2;
        System.out.println("Output: " + powerOfReverse(N1, R1));

        int N2 = 57, R2 = 75;
        System.out.println("Output: " + powerOfReverse(N2, R2));
    }
}
