package HomeWork;

import java.util.Scanner;

public class EvaVeliSolution2 {

	public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);

        System.out.println("The inputs are : ");
		int n = sc.nextInt();
		int i = sc.nextInt();

		System.out.println("Using first way the output is : ");
		System.out.println(findBit(n, i));
		System.out.println("Using second way the output is : ");
		System.out.println(findBit1(n,i));

	}
/////////////////////////////////////////////FIRST WAY////////////////////////////////////////////////////////////////////////
   
	private static String invert(String s) {
		String s1 = s;
		char[] c = new char[s1.length()]; // char array will have the size of the string
		for (int i = 0; i < s1.length(); i++) {
			c[i] = s1.charAt(i); //store the elements char by char
		}
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '0')  //if the element is 0, make it 1
				c[i] = '1';
			else
				c[i] = '0'; //if it is 1 , make it 0
		}
		for (int i = 0; i < c.length; i++) //iterate through char array
			s1 += c[i]; // and the string will contain the char array elements
		return s1; //return the new string
	}

         private static String reverse(String s) {
		String s1 = "";
                char c1;
		for (int i = 0; i < s.length(); i++) { //iterate through the string
			c1 = s.charAt(i); //reverse the string , charAt() returns the character at a specified index
			s1 = c1 + s1;
		}
		return s1; //return the new string
	}

	private static String buildS(int n) {
		if (n >0)
		   return buildS(n - 1) + "0" + invert(reverse(buildS(n - 1))); //anothercase
                else  //base case
                   return "1" ;
	}
	
	public static char findBit1(int n, int i) {
		String s = buildS(n); 
		return s.charAt(i-1);
	}



///////////////////////////////////////////SECOND WAY//////////////////////////////////////////////////
	public static char findBit(int n, int i) { //visible method 
		return findingBit(n).charAt(i - 1); //charAt() returns the character at the specified index in our string
	}

	private static String findingBit(int n, String s) { //implementation method 

		if (n > 1) {
			StringBuilder s1 = new StringBuilder(); //creates mutable sequence of characters since String class is immutable
			
			s1.append(s); //append a value to the current sequence.
			s1.append(0);
		
			for (int i = 0; i < s.length(); i++) { //iterate through the entire string
				s1.append('1' - s.charAt(s.length() - 1 - i)); 
			}
			return findingBit(n - 1, s1.toString()); //our updated case

		} else {  //if n==1 base case
			return s;
		}
	}

	private static String findingBit(int n) {
		return findingBit(n, "1");
	}
}
