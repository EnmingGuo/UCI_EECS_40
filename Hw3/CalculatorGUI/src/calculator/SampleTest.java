package calculator;

public class SampleTest {
    public static void main(String[] args){
        Calculator myCal = new Calculator();

        //test addition
        System.out.println("Testing addition");
        myCal.test("1");
        myCal.test("+");
        myCal.test("2");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 3");

        //test subtraction
        System.out.println("Testing subtraction");
        myCal.test("1");
        myCal.test(".");
        myCal.test("2");
        myCal.test("-");
        myCal.test("2");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: -0.8");

        //test multiplication
        System.out.println("Testing multiplication");
        myCal.test("1");
        myCal.test("*");
        myCal.test("2");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 2");

        //test division
        System.out.println("Testing multiplication");
        myCal.test("1");
        myCal.test(".");
        myCal.test("2");
        myCal.test("/");
        myCal.test("2");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 0.6");

        //test power
        System.out.println("Testing power");
        myCal.test("2");
        myCal.test("**");
        myCal.test("3");
        myCal.test("=");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 8");

        //test square
        System.out.println("Testing square");
        myCal.test("2");
        myCal.test("*2");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 4");

        //test percentage
        System.out.println("Testing percentage");
        myCal.test("1");
        myCal.test("%");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 0.01");

        //test square root
        System.out.println("Testing square root");
        myCal.test("4");
        myCal.test("sqr");
        myCal.test("txt");
        myCal.test("AC");
        System.out.println("The reference result is: 2");
    }
}