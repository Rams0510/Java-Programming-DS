import java.util.Scanner;
public class PadovanSequence{
public static void padovan(int n){
int a=1;
System.out.print(a);
int b=1;
System.out.print(b);
int c=1;
System.out.print(c);
int d=0;
while(n!=2){
d=a+b;
a=b;
b=c;
c=d;
n--;
System.out.print(d);
}
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
padovan(n);
}
}