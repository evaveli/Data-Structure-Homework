package HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

public class EvaVeliSolution {
	
	public static void main(String [] args) {
		int[] show = decrement(new int[]{2, 3, 4});
		int[] show1 = decrement(new int[] {3,1});
		int[] show2 = decrement(new int[] {1,0,0});
		System.out.println(Arrays.toString(show)); //Print in array format
		System.out.println(Arrays.toString(show1));
		System.out.println(Arrays.toString(show2));
		
	}
	
	   
	public static int[] decrement(int[] digits) {
        int number=0 ;
        
        for (int i : digits) { //for each loop to iterate through array of digits
        	number = number * 10 + i; //converting elemnts in a real number
        } 
            number -= 1; //decrement by one.

        String[] arrayOfDigits = Integer.toString(number).split("");  //string array to store the numbers seperated by space and convert them to string characters
        int[] resultArray = new int[arrayOfDigits.length]; //create the final array that will have the same size with array of String
        for (int i = 0; i < arrayOfDigits.length; ++i) //iterate through the array of string
            resultArray[i] = Integer.parseInt(arrayOfDigits[i]); // the resultArray will have integers not string characters 

        return resultArray;
    }
}