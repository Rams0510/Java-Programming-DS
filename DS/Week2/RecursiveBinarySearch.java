import java.util.Scanner;

public class RecursiveBinarySearch  
{ 
    public static int recursiveBinarySearch(int[] arr, int key, int left, int right) 
    { 
        if (left > right) 
        {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == key) 
        {
            return mid;
        }
        if (arr[mid] > key) 
        {
            return recursiveBinarySearch(arr, key, left, mid - 1);
        }
        return recursiveBinarySearch(arr, key, mid + 1, right);
    } 
  
    public static void main(String[] args)  
    { 
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " sorted elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the element to search: ");
        int target = scanner.nextInt();
        
        int result = recursiveBinarySearch(arr, target, 0, arr.length - 1);
        if (result != -1) 
        {
            System.out.println("Element " + target + " is present at index " + result);
        } 
        else 
        {
            System.out.println("Element " + target + " is not present in arr[]");
        }
        
        scanner.close();
    } 
} 
