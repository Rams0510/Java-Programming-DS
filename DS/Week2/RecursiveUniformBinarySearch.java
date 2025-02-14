import java.util.Scanner;

public class RecursiveUniformBinarySearch  
{ 
    public static int recursiveUniformBinarySearch(int[] arr, int key, int[] lookupTable, int left, int right)  
    { 
        if (left > right) 
        {
            return -1;
        }
        int mid = lookupTable[left + right];
        if (arr[mid] == key) 
        {
            return mid;
        }
        if (arr[mid] > key) 
        {
            return recursiveUniformBinarySearch(arr, key, lookupTable, left, mid - 1);
        }
        return recursiveUniformBinarySearch(arr, key, lookupTable, mid + 1, right);
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
        
        int[] lookupTable = new int[n];
        for (int i = 0; i < n; i++) {
            lookupTable[i] = i;
        }
        
        System.out.print("Enter the element to search: ");
        int target = scanner.nextInt();
        
        int result = recursiveUniformBinarySearch(arr, target, lookupTable, 0, arr.length - 1);
        if (result != -1) 
        {
            System.out.println("Position of " + target + " in array = " + result);
        } 
        else 
        {
            System.out.println(target + " is not present in the array");
        }
        
        scanner.close();
    } 
}
