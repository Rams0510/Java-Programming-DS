import java.util.Scanner;

public class InterpolationSearch  
{ 
    public static int interpolationSearch(int[] arr, int key)  
    { 
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right && key >= arr[left] && key <= arr[right]) 
        {
            int mid = left + ((key - arr[left]) * (right - left)) / (arr[right] - arr[left]);
            
            if (arr[mid] == key) 
            {
                return mid;
            }
            if (arr[mid] < key) 
            {
                left = mid + 1;
            } 
            else 
            {
                right = mid - 1;
            }
        }
        return -1;
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
        
        int result = interpolationSearch(arr, target);
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