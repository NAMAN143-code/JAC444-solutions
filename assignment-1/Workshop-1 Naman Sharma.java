//Name: Naman Sharma 
//Student Id: 157151200
//Email: nsharma173@myseneca.ca

//JAC444 ZAA Workshop 1 

import java.util.*;
 
public class MainClass
{
    public static void main(String[] args)
    {
       
        int noOfRows = 8; 
        int rowCount = 1;
 
        for (int i = noOfRows; i > 0; i--)
        {
          
            for (int j = 1; j <= i*2; j++)
            {
                System.out.print("  ");
            }
            
            for (int j = 1; j <= rowCount; j++)          
            {
               
                if((int)(Math.pow(2,j-1)) < 9){
                    System.out.print("   ");
                }
                else if((int)(Math.pow(2,j-1))> 9 ){
                    
                    if((int)(Math.pow(2,j-1))> 99){
                        System.out.print(" ");
                    }else {
                        System.out.print("  ");
                    }
                }
                
                System.out.print((int)(Math.pow(2,j-1)));  
            }
             
            for (int j = rowCount-1; j >= 1; j--)
            {               
                  
                if((int)(Math.pow(2,j-1)) < 9){
                    System.out.print("   ");
                }
                else if((int)(Math.pow(2,j-1))> 9 ){
                    
                    if((int)(Math.pow(2,j-1))> 99){
                        System.out.print(" ");
                    }else {
                        System.out.print("  ");
                    }
                }   
                System.out.print((int)(Math.pow(2,j-1)));     
            }                       
             
            System.out.println(); 
            rowCount++;
        }
    }
}



