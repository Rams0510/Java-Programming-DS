public class ArrayLeaders {
    public static void findLeaders(int[] arr) {
        int n = arr.length;
        int maxFromRight = arr[n - 1];
        System.out.print(maxFromRight + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                System.out.print(maxFromRight + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.print("Leaders: ");
        findLeaders(arr);

        arr = new int[]{1, 2, 3, 4, 5, 2};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.print("Leaders: ");
        findLeaders(arr);
    }
}
