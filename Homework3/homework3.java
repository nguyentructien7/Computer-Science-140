/*
 * Homework 3
 * author: Tien Nguyen
 * date: September-18-2015
 * description: Write a short program involving spacing and alignment, empty lines, new lines, input on the same line and math.
 */
package homework3;

import java.util.Scanner;

public class homework3 {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    //Declare your variables first.
     int num1,num2;
    
    
    System.out.println("Let me teach you some math...");   
    System.out.println("");
    
    
    //Get numbers from user
    System.out.print("Enter a whole number:");
        num1=input.nextInt();
    System.out.print("Enter a whole number not equal to zero:");
        num2=input.nextInt();
        System.out.println("");
        
    
    //Error
    if (num2==0){
        System.out.println("I asked you to make it not zero. See what you did...:");
        System.exit(-1);
        
} 
    //Declare variables
    
            int num3= num1+num2;
            int num4= num1-num2;
            int num5= num1*num2;
            int num6= num1/num2;
            double num7=(double)num1/(double)num2;
            int num8=num1%num2;
            
    //Output the results of the calculations
    System.out.printf("%-18s %d + %d = %d\n", "addition:", num1, num2, num3);
    System.out.printf("%-18s %d - %d = %d\n", "substraction:", num1, num2, num4);
    System.out.printf("%-18s %d * %d = %d\n","multiplication:", num1, num2, num5);
    System.out.printf("%-18s %d / %d = %d\n","integer division:", num1, num2,num6);
    System.out.printf("%-18s %d / %d = %1.1f\n","regular division:", num1, num2, num7);
    System.out.printf("%-18s %d %% %d = %d ","modulo:", num1, num2, num8);
    
 
    
    
          
            
}  
}