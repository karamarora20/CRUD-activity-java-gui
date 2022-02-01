package application;
import java.util.ArrayList;
import java.util.Scanner;
class numprime{
	boolean isprime(int n) {
		int c=0;
		for (int i=1;i<=n;i++) {
			if(n%i==0)
				c++;
		}
		if(c==2)
			return true;
		else
			return false;
	}
	void numprime(String n) {
		int l= n.length();
		int max=0;
		String s="";
		char ch;
		for (int i=0;i<l;i++) {
			ch= n.charAt(i);
			if(Character.isDigit(ch)) {
				s=s+ch;
				if(isprime(Integer.parseInt(s))) {
					if(max<=Integer.parseInt(s)) {
						max= Integer.parseInt(s);
						
					}
				}
			} s="";
		}
		
		System.out.println("the maximum prime digit is :"+max);
		
		
	}
	void numprime(int[]a) {
		int l= a.length;
		int max=0;
		for (int i=0;i<l;i++)
		{ if(isprime(a[i]))	{
			if(max<=a[i])
				max=a[i];
			}}
	System.out.println("the largest number in the array is: "+max);	
	}
	}

	 class maincount{
		 public static void main(String args[]) {
		 Scanner sc= new Scanner(System.in);
		 numprime obj= new numprime();
		 System.out.println("enter the number"); 
		 int arr []= new int[10];
		 System.out.println("enter the array");
		 for(int i=0;i<10;i++) {
			 arr[i]= sc.nextInt();
		 }
		 String s= sc.nextLine();
		 int ll=1;
		 obj.numprime(s);
		 obj.numprime(arr);
		 
	 }
	 } 
	 

