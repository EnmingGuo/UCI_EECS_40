package com.example.HelloWorld;

public class HelloWorld {
    public static void main(String[] args) {
        for (int i=1;i<=11;i++){
            if(i==6)
                System.out.println("My Hello World");
            else{
                if(i>=7){
                    for(int j=1;j<=12-i;j++){
                        System.out.print("*");
                        if(j!=12-i)System.out.print("   ");
                    }
                }
                else{
                    for(int j=1;j<=i;j++){
                        System.out.print("*");
                        if(j!=i)System.out.print("   ");
                    }
                }
                if(i!=11)
                    System.out.println("");
            }
        }
    }
}
