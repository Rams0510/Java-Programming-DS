import java.util.Scanner;
class MultipleChecker{
int Checker(int n1,int n2)
{
if(n1==0 || n2==0)
{
return 3;
}
else if(n1==0)
{
return 3;
}
else if(n1%n2==0)
{
return 2;
}
else
{
return 1;
}
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int n1=sc.nextInt();
int n2=sc.nextInt();
MultipleChecker obj=new MultipleChecker();
System.out.println(obj.Checker(n1,n2));
}
}