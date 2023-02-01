package com.example.Score;

import java.util.Random;

public class Score {
    public static void main(String[] args) {
        int studentNum=100;
        int passNum=0;
        Random rand=new Random();
        for(int i=1;i<=studentNum;i++){
            int randomScore=rand.nextInt(101);
            if(randomScore>=60)
                passNum+=1;
            System.out.println("The score of Student "+i+" is: "+randomScore);
        }
        if(passNum<=1)
            System.out.print(passNum+" student pass the exam");
        else
            System.out.print(passNum+" students pass the exam");
    }
}
