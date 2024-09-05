import java.util.Scanner;
class NumberCounter{
    static int CountNumber(int num1,int num2,int num3,int num4,int num5,String type){
        int[] arr={num1,num2,num3,num4,num5};
        int c=0;
        for(int i=0;i<5;i++){
            if(type.equalsIgnoreCase("even") && arr[i]%2==0){
                c+=1;
            }
            if(type.equalsIgnoreCase("odd") && arr[i]%2==1){
                c+=1;
            }
        }
    return c;
    }
	public static void main(String[] args){
	    Scanner sc=new Scanner(System.in);
	    int num1=sc.nextInt();
	    int num2=sc.nextInt();
	    int num3=sc.nextInt();
	    int num4=sc.nextInt();
	    int num5=sc.nextInt();
	    String type=sc.nextLine();
	    System.out.println(CountNumber(num1,num2,num3,num4,num5,type));
		//write your code here
	}
}