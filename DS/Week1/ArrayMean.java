public class ArrayMean {
    
    public static double findArrayMean(int[] arr, int N) {
        if (N == 1) {
            return arr[0];
        }

        double meanOfNMinus1 = findArrayMean(arr, N - 1);
        double sumOfNMinus1 = meanOfNMinus1 * (N - 1);
        double meanOfN = (sumOfNMinus1 + arr[N - 1]) / N;
        
        return meanOfN;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Mean: " + findArrayMean(arr1, arr1.length));

        int[] arr2 = {1, 2, 3};
        System.out.println("Mean: " + findArrayMean(arr2, arr2.length));
    }
}
