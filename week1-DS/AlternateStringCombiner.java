import java.util.Scanner;
public class AlternateStringCombiner{
public static String comebineStrings(String a,String b){
int l=Math.max(a.length(),b.length());
String s1="";
for(int i=0;i<=l;i++){
if(i<a.length()){
s1+=a.charAt(i);
}
if(i<b.length()){
s1+=b.charAt(i);
}
}
return s1;
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
String a=sc.nextLine();
String b=sc.nextLine();
System.out.println(comebineStrings(a,b));
}
}