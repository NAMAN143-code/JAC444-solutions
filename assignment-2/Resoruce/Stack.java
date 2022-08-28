package Resoruce;

public class Stack{
	private char arr[];
	private int top;
	
	public Stack(int size) {  
		  arr= new char[size];
		  top= -1;
	}

	public boolean isEmpty(){
		return top == -1;	
	}
	
	public boolean isFull(){
		return top == arr.length - 1;
	}
		
	public void push(char i) {
	   
	      arr[++top] = i;	    
	}
	
	public char pop() {
	 	    
	    return arr[top--];
	}
}