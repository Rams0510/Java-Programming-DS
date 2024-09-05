import java.util.Scanner;
class StringCombiner{
String Combiner(String n1,String n2)
{
int l1=n1.length();
int l2=n2.length();
if(l1>l2)
{
return(n2+n1+n2);
}
else
{
return(n1+n2+n1);
}
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
String n1=sc.nextLine();
String n2=sc.nextLine();
StringCombiner obj=new StringCombiner();
System.out.println(obj.Combiner(n1,n2));
}
}