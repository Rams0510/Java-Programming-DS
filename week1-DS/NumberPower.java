import java.util.Scanner;
public class NumberPower{
public static long powerOfReverse(int N,int R){
long pro=1;
long res=1000000000+7;
while(R!=0){
pro*=N;
pro%=res;
R--;
}
return pro;
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int N=sc.nextInt();
int R=sc.nextInt();
System.out.println(powerOfReverse(N,R));
}
}