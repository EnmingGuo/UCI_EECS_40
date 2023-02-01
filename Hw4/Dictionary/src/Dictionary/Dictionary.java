package Dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

class Word{
    String itself;
    int frequency;
    String content;
    Word(String a,int b,String c){
        itself=a;
        frequency=b;
        content=c;
    }
}

public class Dictionary {

    public static ArrayList<Word> dictionary = new ArrayList<Word>();
    public static JButton FINDButton;
    public static JButton ADDButton;
    public static JButton REMOVEButton;
    public static JButton CLEARButton;
    public static JButton IMPORTButton;
    public static JButton EXPORTButton;

    public static JLabel WordLabel;
    public static JLabel FrequencyLabel;
    public static JLabel FrequentWordOneLabel;
    public static JLabel FrequentWordTwoLabel;
    public static JLabel FrequentWordThreeLabel;
    public static JLabel FilePathLabel;
    public static JLabel BatchProcessingLabel;

    public static JTextField TextFilePath;
    public static JTextField TextWord;
    public static JTextField TextFrequency;
    public static JTextField TextFreqWord1;
    public static JTextField TextFreqWord2;
    public static JTextField TextFreqWord3;

    public static JTextArea TextArea;

    /**
     * This is the method to judge whether a string is number!
     * @param temp
     * @return
     */
    public static boolean isAllInteger(String temp){
        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i)<'0'||temp.charAt(i)>'9'){
                return false;
            }
        }
        return true;
    }

    /**
     * This is the method for clear!
     * @param options
     */
    public static void clear(int options){
        if(((options >> 5)&1)==1)
            Dictionary.TextWord.setText("");
        if(((options >> 4)&1)==1)
            Dictionary.TextFrequency.setText("");
        if(((options >> 3)&1)==1)
            Dictionary.TextFreqWord1.setText("");
        if(((options >> 2)&1)==1)
            Dictionary.TextFreqWord2.setText("");
        if(((options >> 1)&1)==1)
            Dictionary.TextFreqWord3.setText("");
        if((options&1)==1)
            Dictionary.TextArea.setText("");
    }

    /**
     * This is the method to judge whether a word does not contain letters!
     * @param temp
     * @return
     */
    public static boolean isAllLetter(String temp){
        temp=temp.toLowerCase();
        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i)<'a'||temp.charAt(i)>'z'){
                return false;
            }
        }
        return true;
    }

    /**
     * This is to check whether a word is contained in the dictionary!
     * @param word
     * @return
     */
    public static boolean isExist(String word){
        for(Word item:Dictionary.dictionary){
            if(item.itself.equals(word)){
                return true;
            }
        }
        return false;
    }

    /**
     * This is subfunction to remove the word away from the dictionary!
     * @param word
     */
    public static void remove(String word){
        int i=0;
        for(Word item:Dictionary.dictionary){
            if(item.itself.equals(word)){
                Dictionary.dictionary.remove(i);
                return;
            }
            i++;
        }
    }
    /**
     * This is the method for add button!
     * @throws InvalidWordError
     * @throws InvalidFrequencyError
     * @throws WordDuplicatedError
     */
    public static  void addWord() throws InvalidWordError,InvalidFrequencyError,WordDuplicatedError{
        String word=Dictionary.TextWord.getText();
        String tempFrequency=Dictionary.TextFrequency.getText();
        String content = Dictionary.TextArea.getText();
        if(word.equals("")||!isAllLetter(word)){
            throw new InvalidWordError("Word: "+word+"\tFrequency: "+tempFrequency+"\tContent: "+content+"\nInvalid Word Error!");
        }
        if(!isAllInteger(tempFrequency)){
            throw new InvalidFrequencyError("Word: "+word+"\tFrequency: "+tempFrequency+"\tContent: "+content+"\nInvalid Frequency Error!");
        }
        int frequency;
        if(tempFrequency.equals("")){
            frequency=1;
        }
        else
            frequency=Integer.parseInt(tempFrequency);
        if(Dictionary.isExist(word)){
            throw new WordDuplicatedError("Word: "+word+"\tFrequency: "+tempFrequency+"\tContent: "+content+"\nWord Duplicated Error!");
        }
        dictionary.add(new Word(word,frequency,content));
    }

    /**
     * This is the method for remove button!
     * @throws InvalidWordError
     * @throws WordNotFoundError
     */
    public static  void removeWord() throws InvalidWordError,WordNotFoundError{
        String word=Dictionary.TextWord.getText();
        if(word.equals("")||!isAllLetter(word)){
            throw new InvalidWordError("Word: "+word+"\nInvalid Word Error!");
        }

        if(!Dictionary.isExist(word)){
            throw new WordNotFoundError("Word: "+word+"\nWord Not Found Error!");
        }
        remove(word);
    }

    /**
     * This is the method for find button!
     * @return
     * @throws WordNotFoundError
     * @throws InvalidWordError
     */
    public static ArrayList<Word> findWord() throws WordNotFoundError,InvalidWordError{
        String word=Dictionary.TextWord.getText();
        if(word.equals("")||!isAllLetter(word)){
            throw new InvalidWordError("Word: "+word+"\nInvalid Word Error!");
        }
        ArrayList <Word> res =frequencyWord(word);
        if(res.size()==0)
            throw new WordNotFoundError("Word: "+word+"\nWord Not Found Error!");
        return res;
    }

    /**
     * This is to check at most three most frequent words!
     * @param word
     * @return
     */
    public static ArrayList<Word>frequencyWord(String word){
        ArrayList<Word> temp=new ArrayList<Word>();
        for(Word item:Dictionary.dictionary){
            if(isSuffix(item.itself,word)){
                temp.add(item);
            }
        }
        Comparator<Word> comparator = new Comparator<Word>() {
            public int compare(Word o1, Word o2) {
                if (o1.frequency > o2.frequency) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        };
        Collections.sort(temp,comparator);
        ArrayList<Word> res=new ArrayList<Word>();
        if(temp.size()<=3)return temp;
        int cnt=0;
        for(Word item:temp){
            if(cnt>=3)break;
            res.add(item);
        }
        return res;
    }

    /**
     * This is to check whether a given word contains the suffix!
     * @param word
     * @param suffix
     * @return
     */
    public static boolean isSuffix(String word,String suffix){
        if(word.length()<suffix.length())return false;
        for(int i=0;i<suffix.length();i++){
            if(word.charAt(i)!=suffix.charAt(i))return false;
        }
        return true;
    }

    /**
     * This is the construction method
     */
    public Dictionary(){
        JFrame f= new JFrame("Dictionary");
        f.setSize(500,750);


        WordLabel=new JLabel("Word",JLabel.CENTER);
        WordLabel.setBounds(20,40,150,30);
        f.add(WordLabel);

        TextWord=new JTextField("");
        TextWord.setBounds(170,40,310,30);
        f.add(TextWord);

        FrequencyLabel=new JLabel("Frequency",JLabel.CENTER);
        FrequencyLabel.setBounds(20,80,150,30);
        f.add(FrequencyLabel);

        TextFrequency=new JTextField("");
        TextFrequency.setBounds(170,80,310,30);
        f.add(TextFrequency);

        FrequentWordOneLabel=new JLabel("Frequent Word 1",JLabel.CENTER);
        FrequentWordOneLabel.setBounds(20,120,150,30);
        f.add(FrequentWordOneLabel);

        TextFreqWord1=new JTextField("");
        TextFreqWord1.setBounds(170,120,310,30);
        f.add(TextFreqWord1);

        FrequentWordTwoLabel=new JLabel("Frequent Word 2",JLabel.CENTER);
        FrequentWordTwoLabel.setBounds(20,160,150,30);
        f.add(FrequentWordTwoLabel);

        TextFreqWord2=new JTextField("");
        TextFreqWord2.setBounds(170,160,310,30);
        f.add(TextFreqWord2);

        FrequentWordThreeLabel=new JLabel("Frequent Word 3",JLabel.CENTER);
        FrequentWordThreeLabel.setBounds(20,200,150,30);
        f.add(FrequentWordThreeLabel);

        TextFreqWord3=new JTextField("");
        TextFreqWord3.setBounds(170,200,310,30);
        f.add(TextFreqWord3);

        TextArea=new JTextArea("");
        TextArea.setBounds(20,250,460,230);
        f.add(TextArea);

        FINDButton=new JButton("FIND");
        FINDButton.setBounds(20,500,100,40);
        f.add(FINDButton);
        FindListener findListener = new FindListener();
        FINDButton.addActionListener(findListener);

        ADDButton = new JButton("ADD");
        ADDButton.setBounds(140,500,100,40);
        f.add(ADDButton);
        AddListener addListener = new AddListener();
        ADDButton.addActionListener(addListener);

        REMOVEButton=new JButton("REMOVE");
        REMOVEButton.setBounds(260,500,100,40);
        f.add(REMOVEButton);
        RemoveListener removeListener = new RemoveListener();
        REMOVEButton.addActionListener(removeListener);

        CLEARButton=new JButton("CLEAR");
        CLEARButton.setBounds(380,500,100,40);
        f.add(CLEARButton);
        ClearListener clearListener = new ClearListener();
        CLEARButton.addActionListener(clearListener);

        BatchProcessingLabel=new JLabel("Batch  Processing",JLabel.CENTER);
        BatchProcessingLabel.setBounds(20,560,460,30);
        f.add(BatchProcessingLabel);

        FilePathLabel=new JLabel("File Path",JLabel.CENTER);
        FilePathLabel.setBounds(20,610,150,30);
        f.add(FilePathLabel);

        TextFilePath=new JTextField("");
        TextFilePath.setBounds(170,610,310,30);
        f.add(TextFilePath);

        IMPORTButton=new JButton("IMPORT");
        IMPORTButton.setBounds(20,660,200,40);
        f.add(IMPORTButton);
        ImportListener importListener = new ImportListener();
        IMPORTButton.addActionListener(importListener);

        EXPORTButton = new JButton("EXPORT");
        EXPORTButton.setBounds(280,660,200,40);
        f.add(EXPORTButton);
        ExportListener exportListener = new ExportListener();
        EXPORTButton.addActionListener(exportListener);

        f.setLayout(null);
        f.setVisible(true);
        dictionary.clear();
    }

    /**
     * This is the main method , you can get a dictionary!
     * @param args
     */

    public static void main(String[] args) {
        Dictionary myDictionary =new Dictionary();
    }
}

class AddListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) throws InvalidWordError,InvalidFrequencyError,WordDuplicatedError{
        try{
            Dictionary.addWord();
        } catch(InvalidFrequencyError error){
            Dictionary.clear(63);
            Dictionary.TextArea.setText(error.getMessage());
            throw new InvalidFrequencyError();
        } catch (InvalidWordError error){
            Dictionary.clear(63);
            Dictionary.TextArea.setText(error.getMessage());
            throw new InvalidWordError();
        }catch (WordDuplicatedError error){
            Dictionary.clear(63);
            Dictionary.TextArea.setText(error.getMessage());
            throw new WordDuplicatedError();
        }
        Dictionary.clear(31);
        Dictionary.TextArea.setText("Successfully Add!");
    }
}
class FindListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) throws WordNotFoundError,InvalidWordError{
        ArrayList <Word> words;
        try{
            words=Dictionary.findWord();
        } catch (InvalidWordError error){
            Dictionary.clear(63);
            Dictionary.TextArea.setText(error.getMessage());
            throw new InvalidWordError();
        }catch (WordNotFoundError error){
            Dictionary.clear(63);
            Dictionary.TextArea.setText(error.getMessage());
            throw new WordNotFoundError();
        }
        String contents="";
        Dictionary.clear(31);
        if(words.size()>0){
            Dictionary.TextFreqWord1.setText(words.get(0).itself);
            contents+="Frequent Word 1 Meaning: "+words.get(0).content+'\n';
        }
        if(words.size()>1){
            Dictionary.TextFreqWord2.setText(words.get(1).itself);
            contents+="Frequent Word 2 Meaning: "+words.get(1).content+'\n';
        }
        if(words.size()>2){
            Dictionary.TextFreqWord3.setText(words.get(2).itself);
            contents+="Frequent Word 3 Meaning: "+words.get(2).content;
        }
        Dictionary.TextArea.setText(contents);
    }
}
class RemoveListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) throws WordNotFoundError,InvalidWordError {
        try{
            Dictionary.removeWord();
        } catch (InvalidWordError error){
            Dictionary.clear(63);
            Dictionary.TextArea.setText(error.getMessage());
            throw new InvalidWordError();
        }catch (WordNotFoundError error){
            Dictionary.clear(63);
            Dictionary.TextArea.setText(error.getMessage());
            throw new WordNotFoundError();
        }
        Dictionary.clear(31);
        Dictionary.TextArea.setText("Successfully Remove!");
    }
}
class ClearListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Dictionary.clear(63);
    }
}
class ImportListener implements  ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) throws FileNotFoundError{
        String filePath="";
        try
        {
            filePath = Dictionary.TextFilePath.getText();
            BufferedReader inputStream = new BufferedReader(new FileReader(filePath));
            String word;
            while ((word=inputStream.readLine())!=null) {
                if(word.equals("")||word.equals("\n"))continue;
                int frequency=Integer.parseInt(inputStream.readLine());
                String content=inputStream.readLine();
                Dictionary.dictionary.add(new Word(word,frequency,content));
            }
            inputStream.close( );
        }
        catch(FileNotFoundException f)
        {
            Dictionary.clear(63);
            Dictionary.TextFilePath.setText("");
            Dictionary.TextArea.setText("File ("+filePath+") Not Found Error!");
            throw new FileNotFoundError();
        }
        catch(IOException f)
        {
            System.out.println("Error reading from input.txt.");
        }
        Dictionary.clear(63);
        Dictionary.TextFilePath.setText("");
        Dictionary.TextArea.setText("Successfully Import File ("+filePath+")!");
    }
}
class ExportListener implements  ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) throws FileNotFoundError{
        PrintWriter outputStream = null;
        String filePath="";
        try
        {
            filePath=Dictionary.TextFilePath.getText();
            File file=new File(filePath);
            if(!file.exists()){
                Dictionary.TextArea.setText("File ("+filePath+") Not Found Error!");
                throw new FileNotFoundError();
            }
            outputStream = new PrintWriter(new FileOutputStream(filePath));
            Comparator<Word> comparator = new Comparator<Word>() {
                public int compare(Word o1, Word o2) {
                    if (o1.frequency > o2.frequency) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
            };
            ArrayList<Word>res=Dictionary.dictionary;
            Collections.sort(res,comparator);
            for(Word item:res){
                outputStream.println(item.itself);
                outputStream.println(item.frequency);
                outputStream.println(item.content);
                outputStream.println("");
            }
        }
        catch(FileNotFoundException f)
        {
            Dictionary.TextArea.setText("File Not Found Error!");
            Dictionary.TextFilePath.setText("");
            outputStream.close( );
            throw new FileNotFoundError();
        }
        outputStream.close( );
        Dictionary.clear(63);
        Dictionary.TextFilePath.setText("");
        Dictionary.TextArea.setText("Successfully Export File ("+filePath+")!");
    }
}

class InvalidWordError extends RuntimeException {
    public InvalidWordError() {
        super("Invalid Word Error!");
    }
    public InvalidWordError(String message) {
        super(message);
    }
}
class WordNotFoundError extends RuntimeException {
    public WordNotFoundError() {
        super("Word Not Found Error!");
    }
    public WordNotFoundError(String message) {
        super(message);
    }
}
class InvalidFrequencyError extends RuntimeException {
    public InvalidFrequencyError() {
        super("Invalid Frequency Error!");
    }
    public InvalidFrequencyError(String message) {
        super(message);
    }

}
class WordDuplicatedError extends RuntimeException {
    public WordDuplicatedError() {
        super("Division by Zero!");
    }
    public WordDuplicatedError(String message) {
        super(message);
    }
}
class FileNotFoundError extends RuntimeException {
    public FileNotFoundError() {
        super("File Not Found Error!");
    }
    public FileNotFoundError(String message) {
        super(message);
    }
}