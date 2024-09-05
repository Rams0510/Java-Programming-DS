import java.util.Scanner;
class AddLastDigitsFunction{
int addLastDigits(int n1,int n2)
{
n1=n1%10;
n2=n2%10;
return n1+n2;
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int n1=sc.nextInt();
int n2=sc.nextInt();
AddLastDigitsFunction obj=new AddLastDigitsFunction();
System.out.println(obj.addLastDigits(n1,n2));
}
}