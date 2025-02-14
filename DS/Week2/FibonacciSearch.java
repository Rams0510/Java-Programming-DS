import java.util.Scanner;

public class FibonacciSearch  
{ 
    public static int fibonacciSearch(int[] arr, int key)  
    { 
        int n = arr.length;
        int fibM_2 = 0;  
        int fibM_1 = 1;  
        int fibM = fibM_1 + fibM_2;  
        
        while (fibM < n) 
        {
            fibM_2 = fibM_1;
            fibM_1 = fibM;
            fibM = fibM_1 + fibM_2;
        }

        int offset = -1;
        
        while (fibM > 1) 
        {
            int i = Math.min(offset + fibM_2, n - 1);
            
            if (arr[i] == key) 
            {
                return i;
            }
            if (arr[i] < key) 
            {
                fibM = fibM_1;
                fibM_1 = fibM_2;
                fibM_2 = fibM - fibM_1;
                offset = i;
            } 
            else 
            {
                fibM = fibM_2;
                fibM_1 = fibM_1 - fibM_2;
                fibM_2 = fibM - fibM_1;
            }
        }

        if (fibM_1 == 1 && arr[offset + 1] == key) 
        {
            return offset + 1;
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
        
        int result = fibonacciSearch(arr, target);
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
