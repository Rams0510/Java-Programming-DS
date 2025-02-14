import java.util.Scanner;

class SelectionSort {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of elements in the array:");
            int n = sc.nextInt();
            int[] arr = new int[n];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("Original Array:");
            printArray(arr);

            selectionSort(arr);

            System.out.println("Sorted Array:");
            printArray(arr);
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println("Pass " + (i + 1) + ":");
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
