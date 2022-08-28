//Name: Naman Sharma 
//JAC444ZAA
//Student ID: 157151200
//EmailId: nsharma173@myseneca.ca

import java.util.Scanner;

import Resoruce.Stack;

public class Main{
	
	public static String reverseString(String input) {
		Stack stack = new Stack(100);
		
		String temp = "";
		
		for(int i=0; i<input.length();i++) {
			stack.push(input.charAt(i));	
		}
		
		while (!stack.isEmpty()){
			temp = temp + stack.pop();
		}
		
		return temp;		
	}
	
	public static void checkPalindrome(String str){
		String reversedData = reverseString(str);
				
	  if(reversedData.equals(str)) 
		  System.out.print( str + " is a palindrome.");	  
	  
	  else
		  System.out.print( str + " is not a palindrome.");
	}

	public static void main(String[] args) {
		 try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter your string or number:");		 
             String input = scanner.nextLine();		 
             checkPalindrome(input);
        }		
	}
}