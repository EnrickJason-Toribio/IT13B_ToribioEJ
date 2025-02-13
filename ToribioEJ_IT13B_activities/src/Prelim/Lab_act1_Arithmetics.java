package Prelim;

import java.util.Scanner;

public class Lab_act1_Arithmetics {
    public static void main(String[] args){
        
        int first_number,second_number,third_number;
        int x = 3;
       
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        first_number = in.nextInt();
        System.out.print("Enter second number: ");
        second_number = in.nextInt();
        System.out.print("Enter third number: ");
        third_number = in.nextInt();
        
        System.out.println(first_number + " * " + second_number + " + " + third_number + " = " + (first_number * second_number + third_number));
        System.out.println("(" + first_number + " - " + second_number + ")" + " % " + third_number + " = " + ((first_number - second_number) % third_number));
        System.out.println("(" + first_number + " + " + second_number + " + " + third_number + ")" + " / " + x + " = " + ((first_number + second_number + third_number)/ x));
        System.out.println(first_number + " * " + third_number + " - " + "(" + second_number + " * " + second_number + ")" +  " = " + (first_number * third_number - (second_number * second_number)));
    }
}
