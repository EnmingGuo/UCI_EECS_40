package com.example.Duplicate;
import java.io.*;
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner scannerObject=new Scanner(System.in);
        Scanner fileIn = null ;
        try{
           fileIn = new Scanner(new FileInputStream("Q4a.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
            System.exit(0);
        }
        String str=fileIn.nextLine();
        str=str.substring(1,str.length()-1); //remove "{" and "}".
        str=str.replace(" ","");//remove space
        //split the str into array
        String[] array;
        String delimeter = ",";
        array = str.split(delimeter);
        if(array.length==0){
            System.out.println("You enter 0 number!");
            System.exit(0);
        }
        System.out.print("The duplicated elements are :");
        for(int i=0;i< array.length;i++){
            for(int j=i+1;j<array.length;j++){
                int num1 = Integer.parseInt(array[i]);
                int num2=Integer.parseInt(array[j]);
                if(num1==num2){
                    System.out.print(" "+num1);
                    break;
                }
            }
        }
    }
}
