import java.util.*;
public class SecondLastDigit
{
public static int getSecondLastDigit(int n){
if(n>0 && n>=10){
n=n%100;
n=n/10;
return n;
}
else{
return -1;
}
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
n=Math.abs(n);
System.out.println(getSecondLastDigit(n));
}
}