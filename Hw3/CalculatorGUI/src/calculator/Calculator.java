package calculator;
/**
 * This is Calculator class to form a calculator
 * @author Enming Guo
 * @version 1.0
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    /**
     * This is the test method provide by the teaching assistant!
     * @param button
     */
    public void test( String button){

        switch (button){
            case "0": zeroBtn.doClick();break;
            case "1": oneBtn.doClick();break;
            case "2": twoBtn.doClick();break;
            case "3": threeBtn.doClick();break;
            case "4": fourBtn.doClick();break;
            case "5": fiveBtn.doClick();break;
            case "6": sixBtn.doClick();break;
            case "7": sevenBtn.doClick();break;
            case "8": eightBtn.doClick();break;
            case "9": nineBtn.doClick();break;
            case "%": percentageBtn.doClick();break;
            case "-/+": signBtn.doClick();break;
            case "AC": clearBtn.doClick();break;
            case "*2": squareBtn.doClick();break;
            case "sqr": sqrBtn.doClick();break;
            case "log": logBtn.doClick();break;
            case ".": digitBtn.doClick();break;
            case "+": addBtn.doClick();break;
            case "-": minusBtn.doClick();break;
            case "*": mulBtn.doClick();break;
            case "/": divideBtn.doClick();break;
            case "**": powerBtn.doClick();break;
            case "=": equalBtn.doClick();break;
            case "txt": System.out.println("The result is: " + textField.getText());break;
            default:System.out.println("invalid input");break;
        }
    }

    /**
     * This is test the whether the binary operator has just been inputted.
     * @return
     */
    public static boolean isAfterSymbol() {
        return afterSymbol;
    }

    /**
     * This is to set the binary operator type!
     * @param afterSymbol
     */

    public static void setAfterSymbol(boolean afterSymbol) {
        Calculator.afterSymbol = afterSymbol;
    }


    private static boolean afterSymbol=false;

    /**
     * This is to get the first operand number!
     *@return
     */
    public static String getLeftOperand() {
        return leftOperand;
    }

    /**
     * This is to set the first operand number!
     * @param leftOperand
     */

    public static void setLeftOperand(String leftOperand) {
        Calculator.leftOperand = leftOperand;
    }


    private static String leftOperand="";

    /**
     * This is to get the rightoperand!
     * @return
     */
    public static String getRightOperand() {
        return rightOperand;
    }

    /**
     * This is to set the rightoperand!
     * @param rightOperand
     */
    public static void setRightOperand(String rightOperand) {
        Calculator.rightOperand = rightOperand;
    }

    private static String rightOperand="";

    public static String getBinaryOperator() {
        return binaryOperator;
    }

    public static void setBinaryOperator(String binaryOperator) {
        Calculator.binaryOperator = binaryOperator;
    }

    private static String binaryOperator="";
    private static JTextField textField;
    public static void setTextField(String text){
        textField.setText(text);
    }
    public static String getTextField(){
        return textField.getText();
    }
    private static JButton sevenBtn;
    private static JButton fourBtn;
    private static JButton oneBtn;
    private static JButton zeroBtn;
    private static JButton eightBtn;
    private static JButton fiveBtn;
    private static JButton twoBtn;
    private static JButton nineBtn;
    private static JButton sixBtn;
    private static JButton threeBtn;
    private static JButton digitBtn;
    private static JButton logBtn;
    private static JButton powerBtn;
    private static JButton squareBtn;
    private static JButton signBtn;
    private static JButton sqrBtn;
    private static JButton mulBtn;
    private static JButton addBtn;
    private static JButton percentageBtn;
    private static JButton clearBtn;
    private static JButton divideBtn;
    private static JButton minusBtn;
    private static JButton equalBtn;

    /**
     * This is to generate all the function together!
     * @param args
     */

    public static void main(String[] args) {
        Calculator mycal=new Calculator();
    }

    /**
     * This is to create the Frame.
     */
   public Calculator (){
       JFrame f= new JFrame("Calculator");
       textField=new JTextField("0");
       textField.setBounds(40,20,510,40);
       textField.setEditable(false);
       f.add(textField);

       sevenBtn=new JButton("7");
       sevenBtn.setBounds(40,80,60,40);
       SimpleListener ourListener = new SimpleListener();

       sevenBtn.addActionListener(ourListener);
       f.add(sevenBtn);
       fourBtn=new JButton("4");
       fourBtn.setBounds(40,140,60,40);
       fourBtn.addActionListener(ourListener);
       f.add(fourBtn);
       oneBtn=new JButton("1");
       oneBtn.setBounds(40,200,60,40);
       oneBtn.addActionListener(ourListener);
       f.add(oneBtn);
       zeroBtn=new JButton("0");
       zeroBtn.setBounds(40,260,60,40);
       zeroBtn.addActionListener(ourListener);
       f.add(zeroBtn);

       eightBtn=new JButton("8");
       eightBtn.setBounds(130,80,60,40);
       eightBtn.addActionListener(ourListener);
       f.add(eightBtn);
       fiveBtn=new JButton("5");
       fiveBtn.setBounds(130,140,60,40);
       fiveBtn.addActionListener(ourListener);
       f.add(fiveBtn);
       twoBtn=new JButton("2");
       twoBtn.setBounds(130,200,60,40);
       twoBtn.addActionListener(ourListener);
       f.add(twoBtn);


       nineBtn=new JButton("9");
       nineBtn.setBounds(220,80,60,40);
       nineBtn.addActionListener(ourListener);
       f.add(nineBtn);
       sixBtn=new JButton("6");
       sixBtn.setBounds(220,140,60,40);
       sixBtn.addActionListener(ourListener);
       f.add(sixBtn);
       threeBtn=new JButton("3");
       threeBtn.setBounds(220,200,60,40);
       threeBtn.addActionListener(ourListener);

       f.add(threeBtn);
       digitBtn=new JButton(".");
       digitBtn.setBounds(220,260,60,40);
       digitBtn.addActionListener(ourListener);
       f.add(digitBtn);

       logBtn=new JButton("ln");
       logBtn.setBounds(310,80,60,40);
       logBtn.addActionListener(ourListener);
       f.add(logBtn);
       powerBtn=new JButton("x^y");
       powerBtn.setBounds(310,140,60,40);
       powerBtn.addActionListener(ourListener);
       f.add(powerBtn);
       squareBtn=new JButton("x^2");
       squareBtn.setBounds(310,200,60,40);
       squareBtn.addActionListener(ourListener);
       f.add(squareBtn);
       signBtn=new JButton("-/+");
       signBtn.setBounds(310,260,60,40);
       signBtn.addActionListener(ourListener);
       f.add(signBtn);

       sqrBtn=new JButton("√");
       sqrBtn.setBounds(400,80,60,40);
       sqrBtn.addActionListener(ourListener);
       f.add(sqrBtn);
       mulBtn=new JButton("*");
       mulBtn.setBounds(400,140,60,40);
       mulBtn.addActionListener(ourListener);
       f.add(mulBtn);
       addBtn=new JButton("+");
       addBtn.setBounds(400,200,60,40);
       addBtn.addActionListener(ourListener);
       f.add(addBtn);
       percentageBtn=new JButton("%");
       percentageBtn.setBounds(400,260,60,40);
       percentageBtn.addActionListener(ourListener);
       f.add(percentageBtn);

       clearBtn=new JButton("AC");
       clearBtn.setBounds(490,80,60,40);
       clearBtn.addActionListener(ourListener);
       f.add(clearBtn);
       divideBtn=new JButton("/");
       divideBtn.setBounds(490,140,60,40);
       divideBtn.addActionListener(ourListener);
       f.add(divideBtn);
       minusBtn=new JButton("-");
       minusBtn.setBounds(490,200,60,40);
       minusBtn.addActionListener(ourListener);
       f.add(minusBtn);
       equalBtn=new JButton("=");
       equalBtn.setBounds(490,260,60,40);
       equalBtn.addActionListener(ourListener);
       f.add(equalBtn);

       f.setSize(590,360);
       f.setLayout(null);
       f.setVisible(true);
   }
   class SimpleListener implements ActionListener{
        /**
         * This is action capture method, to find which button is clicked!
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String text=((JButton)e.getSource()).getText();
            operateBtnClicked operateClick= new operateBtnClicked();
            switch (text){
                case ".":
                    digitBtnClicked digitClick = new digitBtnClicked();
                    digitClick.writeTextField();
                    break;

                case "0":
                    zeroBtnClicked zeroClick=new zeroBtnClicked();
                    zeroClick.writeTextField();
                    break;
                case "1":
                    oneBtnClicked oneClick=new oneBtnClicked();
                    oneClick.writeTextField();
                    break;
                case "2":
                    twoBtnClicked twoClick=new twoBtnClicked();
                    twoClick.writeTextField();
                    break;
                case "3":
                    threeBtnClicked threeClick=new threeBtnClicked();
                    threeClick.writeTextField();
                    break;
                case "4":
                    fourBtnClicked fourClick=new fourBtnClicked();
                    fourClick.writeTextField();
                    break;
                case "5":
                    fiveBtnClicked fiveClick=new fiveBtnClicked();
                    fiveClick.writeTextField();
                    break;
                case "6":
                    sixBtnClicked sixClick=new sixBtnClicked();
                    sixClick.writeTextField();
                    break;
                case "7":
                    sevenBtnClicked sevenClick=new sevenBtnClicked();
                    sevenClick.writeTextField();
                    break;
                case "8":
                    eightBtnClicked eightClick=new eightBtnClicked();
                    eightClick.writeTextField();
                    break;
                case "9":
                    nineBtnClicked nineClick=new nineBtnClicked();
                    nineClick.writeTextField();
                    break;
                case "+":
                    operateClick.addBtnClicked();
                    break;
                case "-":
                    operateClick.minusBtnClicked();
                    break;
                case "*":
                    operateClick.mulBtnClicked();
                    break;
                case "/":
                    operateClick.divideBtnClicked();
                    break;
                case "x^y":
                    operateClick.powerBtnClicked();
                    break;
                case "%":
                    operateClick.percentageBtnClicked();
                    break;
                case "ln":
                    operateClick.logBtnClicked();
                    break;
                case "x^2":
                    operateClick.squareBtnClicked();
                    break;
                case "√":
                    operateClick.sqrBtnClicked();
                    break;
                case "AC":
                    operateClick.clearBtnClicked();
                    break;
                case "=":
                    operateClick.equalBtnClicked();
                    break;
                case "-/+":
                    operateClick.signBtnClicked();
                    break;
            }
        }
   }


    /**
     * This is the class of operateBtn!
     */
    class operateBtnClicked{
        public static void equalBtnClicked(){
            if(Calculator.getBinaryOperator().equals("")){
                return ;
            }
            else{
                String right=Calculator.getTextField();
                if(right.equals("ERROR"))return;
                Calculator.setRightOperand(right);
                Double doubleObject= new Double(Calculator.getLeftOperand());
                double leftNumber= doubleObject;
                doubleObject=new Double(Calculator.getRightOperand());
                double rightNumber=doubleObject;
                double result=0;
                boolean error=false;
                switch(Calculator.getBinaryOperator()){
                    case "+":
                        result=rightNumber+leftNumber;
                        break;
                    case "-":
                        result=leftNumber-rightNumber;
                        break;
                    case "*":
                        result=leftNumber*rightNumber;
                        break;
                    case "/":
                        if(rightNumber==0){
                            error=true;
                        }
                        else{
                            result=leftNumber/rightNumber;
                        }

                        break;
                    case "power":
                        result=Math.pow(leftNumber,rightNumber);
                        break;
                }
                Calculator.setBinaryOperator("");
                if(error){
                    Calculator.setTextField("ERROR");
                }
                else if(isInt(result)){
                    Calculator.setTextField(String.valueOf((int)result));
                    Calculator.setLeftOperand(String.valueOf(result));
                }
                else{
                    Calculator.setTextField(String.valueOf(result));
                    Calculator.setLeftOperand(String.valueOf(result));
                }
            }
        }
        public static void clearBtnClicked(){
            Calculator.setTextField("0");
            Calculator.setBinaryOperator("");
            Calculator.setLeftOperand("");
            Calculator.setRightOperand("");
            Calculator.setAfterSymbol(false);
        }
        public static String complexCalculate(){
            String left=Calculator.getTextField();
            boolean Error = false;
            if(Calculator.getBinaryOperator() !="" && Calculator.getLeftOperand()!=""){
                Double doubleObject= new Double(left);
                double rightNumber= doubleObject;
                doubleObject=new Double(Calculator.getLeftOperand());
                double leftNumber=doubleObject;
                double result;
                String operator=Calculator.getBinaryOperator();
                if(operator =="+"){
                    result=leftNumber+rightNumber;
                }
                else if (operator =="-"){
                    result=leftNumber-rightNumber;
                }
                else if (operator =="*"){
                    result=leftNumber*rightNumber;
                }
                else if(operator == "/"){
                    if(rightNumber==0){
                        Error=true;
                        result=0;
                    }
                    else{
                        result=leftNumber/rightNumber;
                    }
                }
                else{
                    result=Math.pow(leftNumber,rightNumber);
                }
                if(Error){
                    Calculator.setTextField("ERROR");
                }
                else if(isInt(result)){
                    Calculator.setTextField(String.valueOf((int)result));
                    Calculator.setLeftOperand(String.valueOf(result));
                }
                else{
                    Calculator.setTextField(String.valueOf(result));
                    Calculator.setLeftOperand(String.valueOf(result));
                }
                left=Calculator.getTextField();
            }
            return left;
        }

        public static void addBtnClicked(){

            String left=Calculator.getTextField();
            if(!left.equals("ERROR")){
                left=complexCalculate();
                Calculator.setLeftOperand(left);
                Calculator.setBinaryOperator("+");
                Calculator.setAfterSymbol(true);
            }
        }
        public static void minusBtnClicked(){

            String left=Calculator.getTextField();
            if(!left.equals("ERROR")){
                left=complexCalculate();
                Calculator.setLeftOperand(left);
                Calculator.setBinaryOperator("-");
                Calculator.setAfterSymbol(true);
            }
        }
        public static void mulBtnClicked(){
            String left=Calculator.getTextField();
            if(!left.equals("ERROR")){
                left=complexCalculate();
                Calculator.setLeftOperand(left);
                Calculator.setBinaryOperator("*");
                Calculator.setAfterSymbol(true);
            }
        }
        public static void divideBtnClicked(){
            String left=Calculator.getTextField();
            if(!left.equals("ERROR")){
                left=complexCalculate();
                Calculator.setLeftOperand(left);
                Calculator.setBinaryOperator("/");
                Calculator.setAfterSymbol(true);
            }
        }
        public static void powerBtnClicked(){
            String left=Calculator.getTextField();
            if(!left.equals("ERROR")){
                left=complexCalculate();
                Calculator.setLeftOperand(left);
                Calculator.setBinaryOperator("power");
                Calculator.setAfterSymbol(true);
            }
        }
        public static void sqrBtnClicked(){
            String number = Calculator.getTextField();
            if(!number.equals("ERROR")){
                Double doubleObject= new Double(number);
                double temp= doubleObject;
                if(temp>=0){
                    temp=Math.sqrt(temp);
                    if(isInt(temp)){
                        Calculator.setTextField(String.valueOf((int)temp));
                    }
                    else{
                        Calculator.setTextField(String.valueOf(temp));
                    }
                }
                else{
                    Calculator.setTextField("ERROR");
                }
            }
        }
        public static void logBtnClicked(){
            String number = Calculator.getTextField();
            if(!number.equals("ERROR")){
                Double doubleObject= new Double(number);
                double temp= doubleObject;
                //System.out.println(temp);
                if(temp>0){
                    //System.out.println("进");
                    temp=Math.log(temp);
                    //System.out.println(temp);
                    if(isInt(temp)){
                        Calculator.setTextField(String.valueOf((int)temp));
                    }
                    else{
                        Calculator.setTextField(String.valueOf(temp));
                    }
                }
                else{
                    Calculator.setTextField("ERROR");
                }

            }
        }
        public static void percentageBtnClicked(){
            String number = Calculator.getTextField();
            if(!number.equals("ERROR")){
                Double doubleObject= new Double(number);
                double temp= doubleObject;
                temp=temp/100;
                if(isInt(temp)){
                    Calculator.setTextField(String.valueOf((int)temp));
                }
                else{
                    Calculator.setTextField(String.valueOf(temp));
                }
            }
        }
        public static void squareBtnClicked(){
            String number = Calculator.getTextField();
            if(!number.equals("ERROR")) {
                Double doubleObject = new Double(number);
                double temp = doubleObject;
                temp *= temp;
                if (isInt(temp)) {
                    Calculator.setTextField(String.valueOf((int) temp));
                } else {
                    Calculator.setTextField(String.valueOf(temp));
                }
            }
        }
        public static void signBtnClicked(){
            String number = Calculator.getTextField();
            if(!number.equals("ERROR")) {
                Double doubleObject = new Double(number);
                double temp = doubleObject;
                temp = -temp;
                if (isInt(temp)) {
                    Calculator.setTextField(String.valueOf((int) temp));
                } else {
                    Calculator.setTextField(String.valueOf(temp));
                }
            }
        }
        private static boolean isInt(double number){
            double temp=number;
            int temp1=(int)number;
            if(temp == 0.0 || temp%temp1 == 0){
                return true;
            }
            else
                return false;
        }

    }

    /**
     * This is the base class of all the numberBtn
     */
    class numberBtnClicked {
        String myText;
        numberBtnClicked(){
            myText="";
        }

        public void writeTextField(){
            if(Calculator.getTextField().equals("ERROR")){
                return;
            }
            if(Calculator.isAfterSymbol()){
                Calculator.setTextField("0");
                Calculator.setAfterSymbol(false);
            }
            String tmp=Calculator.getTextField();
            if(tmp.equals("0")){
                tmp="";
            }
            tmp+=myText;
            Calculator.setTextField(tmp);
        }
    }

    /**
     * This is the derived class about dealing with the digit button!
     */
    class digitBtnClicked extends numberBtnClicked{
        digitBtnClicked(){
            myText=".";
        }
        @Override
        public void writeTextField(){
            if(Calculator.getTextField().equals("ERROR")){
                return;
            }
            if(Calculator.isAfterSymbol()){
                Calculator.setTextField("0");
                Calculator.setAfterSymbol(false);
            }
            String tmp=Calculator.getTextField();
            tmp=tmp+myText;
            Calculator.setTextField(tmp);
        }

    }
    class zeroBtnClicked extends numberBtnClicked{
        zeroBtnClicked(){
            myText="0";
        }
    }
    class oneBtnClicked extends numberBtnClicked{
        oneBtnClicked(){
            myText="1";
        }
    }
    class twoBtnClicked extends numberBtnClicked{
        twoBtnClicked(){
            myText="2";
        }
    }
    class threeBtnClicked extends numberBtnClicked{
        threeBtnClicked(){
            myText="3";
        }
    }
    class fourBtnClicked extends numberBtnClicked{
        fourBtnClicked(){
            myText="4";
        }
    }
    class fiveBtnClicked extends numberBtnClicked{
        fiveBtnClicked(){
            myText="5";
        }
    }
    class sixBtnClicked extends numberBtnClicked{
        sixBtnClicked(){
            myText="6";
        }
    }
    class sevenBtnClicked extends numberBtnClicked{
        sevenBtnClicked(){
            myText="7";
        }
    }
    class eightBtnClicked extends numberBtnClicked{
        eightBtnClicked(){
            myText="8";
        }
    }
    class nineBtnClicked extends numberBtnClicked{
        nineBtnClicked(){
            myText="9";
        }
    }


}

