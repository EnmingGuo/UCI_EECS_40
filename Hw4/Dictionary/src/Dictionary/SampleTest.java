package Dictionary;

import javax.swing.*;
 
public class SampleTest {
    public static void main(String[] args) {
        Dictionary myDictionary = new Dictionary();
 
        // Test for ADD
        // InvalidWordError
        myDictionary.TextWord.setText("s1mple");
        myDictionary.TextFrequency.setText("1");
        myDictionary.TextArea.setText("Best AWPer");
        try {
            myDictionary.ADDButton.doClick();
        } catch (InvalidWordError ex) {
            System.out.println("InvalidWordError passed");
        }
 
        // InvalidFrequencyError
        myDictionary.TextWord.setText("niko");
        myDictionary.TextFrequency.setText("-11");
        myDictionary.TextArea.setText("Bad luck buddy");
        try {
            myDictionary.ADDButton.doClick();
        } catch (InvalidFrequencyError ex) {
            System.out.println("InvalidFrequencyError passed");
        }
 
        // WordDuplicatedError
        myDictionary.TextWord.setText("niko");
        myDictionary.TextFrequency.setText("11");
        myDictionary.TextArea.setText("Fortunate entry fragger");
        myDictionary.ADDButton.doClick();
 
        myDictionary.TextWord.setText("niko");
        myDictionary.TextFrequency.setText("12");
        myDictionary.TextArea.setText("Rifler");
        try {
            myDictionary.ADDButton.doClick();
        } catch (WordDuplicatedError ex) {
            System.out.println("WordDuplicatedError passed");
        }
 
        // Test for CLEAR button
        myDictionary = new Dictionary();
 
        myDictionary.TextWord.setText("niko");
        myDictionary.TextFrequency.setText("11");
        myDictionary.TextFreqWord1.setText("aaa");
        myDictionary.TextFreqWord2.setText("bbb");
        myDictionary.TextFreqWord3.setText("ccc");
        myDictionary.TextArea.setText("Fortunate entry fragger");
 
        myDictionary.CLEARButton.doClick();
        String tmp0 = myDictionary.TextWord.getText();
        String tmp1 = myDictionary.TextFrequency.getText();
        String tmp2 = myDictionary.TextFreqWord1.getText();
        String tmp3 = myDictionary.TextFreqWord2.getText();
        String tmp4 = myDictionary.TextFreqWord3.getText();
        String tmp5 = myDictionary.TextArea.getText();
 
        if (tmp0.equals("") && tmp1.equals("") && tmp2.equals("") && tmp3.equals("") && tmp4.equals("") && tmp5.equals("")){
            System.out.println("CLEAR button test passed");
        }
 
        // Test for REMOVE button
        myDictionary = new Dictionary();
 
        myDictionary.TextWord.setText("niko");
        myDictionary.TextFrequency.setText("11");
        myDictionary.TextArea.setText("Fortunate entry fragger");
        myDictionary.ADDButton.doClick();
 
        myDictionary.CLEARButton.doClick();
        // test for WordNotFoundError
        myDictionary.TextWord.setText("NIKO");
        try {
            myDictionary.REMOVEButton.doClick();
        } catch (WordNotFoundError ex) {
            System.out.println("WordNotFoundError passed");
        }
 
        myDictionary.TextWord.setText("niko");
        myDictionary.REMOVEButton.doClick(); // ok here
        try {
            myDictionary.REMOVEButton.doClick();
        } catch (WordNotFoundError ex) {
            System.out.println("WordNotFoundError passed");
        }
 
        // Test for FIND button
        myDictionary = new Dictionary();
 
        myDictionary.TextWord.setText("niko");
        myDictionary.TextFrequency.setText("11");
        myDictionary.TextArea.setText("Fortunate entry fragger");
        myDictionary.ADDButton.doClick();
 
        myDictionary.TextWord.setText("nIko");
        myDictionary.TextFrequency.setText("2");
        myDictionary.TextArea.setText("Least Fortunate entry fragger");
        myDictionary.ADDButton.doClick();
 
        myDictionary.TextWord.setText("nIKO");
        myDictionary.TextFrequency.setText("7");
        myDictionary.TextArea.setText("So-so Fortunate entry fragger");
        myDictionary.ADDButton.doClick();
 
        myDictionary.TextWord.setText("niKo");
        myDictionary.TextFrequency.setText("9");
        myDictionary.TextArea.setText("Second Fortunate entry fragger");
        myDictionary.ADDButton.doClick();
 
        myDictionary.CLEARButton.doClick();
 
        myDictionary.TextWord.setText("n");
        myDictionary.FINDButton.doClick();
 
        String textFreq1 = myDictionary.TextFreqWord1.getText();
        String textFreq2 = myDictionary.TextFreqWord2.getText();
        String textFreq3 = myDictionary.TextFreqWord3.getText();
 
        if (textFreq1.equals("niko") && textFreq2.equals("niKo") && textFreq3.equals("nIKO")) {
            System.out.println("(partially) pass the FIND button check");
            System.out.println("Make sure to print out meanings of each word in TextArea");
        }
 
        // Test for IMPORT and EXPORT Button
        myDictionary = new Dictionary();
        myDictionary.TextFilePath.setText("input.txt"); // change your path to input.txt
        myDictionary.IMPORTButton.doClick();
 
        myDictionary.TextFilePath.setText("output.txt"); // change your path to output.txt
        myDictionary.EXPORTButton.doClick();
        // compare output.txt with output_ref.txt
    }
}
 