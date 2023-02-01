package com.example.MoreDuplicate;
import java.io.*;
import java.util.Scanner;

public class MoreDuplicate {
    public static void main(String[] args) {
        Scanner scannerObject=new Scanner(System.in);
        Scanner fileIn = null;
        try{
            fileIn = new Scanner(new FileInputStream("Q4b.txt"));
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
            System.exit(0);
        }

        String str=fileIn.nextLine(); // get the array.
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
        int[] times;
        times=new int[array.length];
        System.out.println("The duplicated elements are :");

        for(int i=0;i<array.length;i++){
            int num1=Integer.parseInt(array[i]);
            times[num1]+=1;
        }
        for(int i=0;i<array.length;i++){
            if(times[i]>1){
                System.out.print("          ");
                System.out.println(i+" appear "+times[i]+" times");
            }
        }
    }
}
