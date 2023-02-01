package com.example.Division;
import java.io.*;
import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);
        while(true){
            System.out.println("Enter two integers for operation:");
            int num1,num2;
            num1=scannerObject.nextInt();
            num2=scannerObject.nextInt();
            if(num2==0){
                System.out.print("The divisor you entered is 0, which causes the program terminated!");
                System.exit(0);
            }
            else{
                System.out.println("The division result is "+num1/num2+", the remainder is "+num1%num2);
            }

        }
    }
}
