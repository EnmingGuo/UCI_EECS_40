import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class SimpleBankAccount {
    /**
     * This is the main method which organizes the whole functions
     * @param args
     */
    public static void main(String[] args) {
        while(true){
            drawMenu();
            System.out.print("Enter your choice: ");
            Scanner scanner= new Scanner(System.in);
            int choice=scanner.nextInt();
            System.out.println("");
            if(choice>=9){
                System.out.println("Wrong Choice!!");
                System.out.println("");
            }
            else {
                switch (choice){
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        display();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        deposit();
                        break;
                    case 5:
                        displayAll();
                        break;
                    case 6:
                        removeAccount();
                        break;
                    case 7:
                        calculateInterest();
                        break;
                    case 8:
                        System.out.println("Thanks for banking with us!!");
                        exit(0);
                        break;
                }


            }

        }


    }

    /**
     * This is the withdraw method which provides the function of withdrawing money!
     */
    public static void withdraw(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("**Transaction - Withdraw**");
        System.out.print("Enter Your Name: ");
        String enterName=scanner.next();
        System.out.print("Enter amount to withdraw: ");
        double enterAmount=scanner.nextDouble();
        if(standardMember.containsKey(enterName)){
            standardAccount temp=standardMember.get(enterName);
            if(temp.getBalance()>=enterAmount){

                standardMember.put(enterName,new standardAccount(0.005,temp.getBalance()-enterAmount,enterName,temp.getType()));
                System.out.println("Name: "+enterName);
                temp=standardMember.get(enterName);
                System.out.println("Balance: "+temp.getBalance()+'\n');
            }
            else{
                System.out.println("Not enough balance\n");
            }

        }
        else if(VIPMember.containsKey(enterName)){
            VIPAccount temp=VIPMember.get(enterName);
            if(temp.getBalance()>=enterAmount){
                VIPMember.put(enterName,new VIPAccount(0.01,temp.getBalance()-enterAmount,temp.getName(),temp.getType()));
                System.out.println("Name: "+enterName);
                temp=VIPMember.get(enterName);
                System.out.println("Balance: "+temp.getBalance()+'\n');
            }
            else{
                System.out.println("Not enough balance\n");
            }

        }
        else{
            System.out.println("Name : "+enterName+" does not exist\n");
        }
    }

    /**
     * This is the deposit method which provides the function of depositing money!
     */
    public static void deposit(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("**Transaction - Deposit**");
        System.out.print("Enter Your Name: ");
        String enterName=scanner.next();
        System.out.print("Enter amount to deposit: ");
        double enterAmount=scanner.nextDouble();
        if(standardMember.containsKey(enterName)){
            standardAccount temp=standardMember.get(enterName);
            standardMember.put(enterName,new standardAccount(0.005,temp.getBalance()+enterAmount,enterName,temp.getType()));
            System.out.println("Name: "+enterName);
            temp=standardMember.get(enterName);
            System.out.println("Balance: "+temp.getBalance()+'\n');
        }
        else if(VIPMember.containsKey(enterName)){
            VIPAccount temp=VIPMember.get(enterName);
            VIPMember.put(enterName,new VIPAccount(0.01,temp.getBalance()+enterAmount,temp.getName(),temp.getType()));
            System.out.println("Name: "+enterName);
            temp=VIPMember.get(enterName);
            System.out.println("Balance: "+temp.getBalance()+'\n');
        }
        else{
            System.out.println("Name : "+enterName+" does not exist\n");
        }
    }

    /**
     * This is the displayAll method which provides the function of displaying all the information in two HashMaps!
     */
    public static void displayAll(){
        if(!standardMember.isEmpty()){
            System.out.println("Standard Account Details");
            Iterator iterator=standardMember.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry me = (Map.Entry)iterator.next();
                standardAccount member=standardMember.get(me.getKey());
                System.out.println("**Account Details**");
                System.out.println("Name: "+member.getName());
                System.out.println("Account Type: "+member.getType());
                System.out.println("Balance: "+member.getBalance()+'\n');
            }
            System.out.println("");
        }
        if(!VIPMember.isEmpty()){
            System.out.println("VIP Account Details");
            Iterator iterator=VIPMember.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry me = (Map.Entry)iterator.next();
                VIPAccount member=VIPMember.get(me.getKey());
                System.out.println("**Account Details**");
                System.out.println("Name: "+member.getName());
                System.out.println("Account Type: "+member.getType());
                System.out.println("Balance: "+member.getBalance()+'\n');
            }
            System.out.println("");
        }

    }

    /**
     * This is the removeAccount method which provides the function of removing a certain account!
     */
    public static void removeAccount(){
        System.out.println("**Transaction - remove Account**");
        System.out.print("Enter Your Name: ");
        Scanner scanner=new Scanner(System.in);
        String enterName=scanner.next();
        if(standardMember.containsKey(enterName)){
            standardMember.remove(enterName);
            System.out.println("Account has been removed!!\n");
        }
        else if(VIPMember.containsKey(enterName)){
            VIPMember.remove(enterName);
            System.out.println("Account has been removed!!\n");
        }
        else{
            System.out.println("Name : "+enterName+" does not exist\n");
        }
    }

    /**
     * This is the calculateInterest method which provides the function of calculating the interest!
     */
    public static void calculateInterest(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("**Transaction - calculate interests**");
        System.out.print("Enter Your Name: ");
        String enterName=scanner.next();
        System.out.println("Enter the number of months");
        Integer enterMonth=scanner.nextInt();
        if(standardMember.containsKey(enterName)){
            standardAccount temp=standardMember.get(enterName);
            System.out.println("The expected interest is: "+temp.getBalance()*enterMonth*temp.getRate());
        }
        else if(VIPMember.containsKey(enterName)){
            VIPAccount temp=VIPMember.get(enterName);
            System.out.println("The expected interest is: "+temp.getBalance()*enterMonth*temp.getRate());
        }
        else{
            System.out.println("Name : "+enterName+" does not exist\n");
        }

    }

    /**
     * This is the createAccount method which provides the function of creating an account!
     */
    public static void createAccount(){
        System.out.println("**Create New Account**");
        System.out.println("1. Create Standard Account");
        System.out.println("2. Create VIP Account");
        Scanner scanner= new Scanner(System.in);
        int choice=0;
        while(true){
            System.out.print("Enter your choice: ");
            choice=scanner.nextInt();
            if(choice==1||choice==2){
                break;
            }
            else{
                System.out.println("Wrong Choice!!");
                System.out.println("");
            }
        }
        System.out.print("Enter name: ");
        String enterName=scanner.next();
        System.out.print("Starting balance: ");
        Double enterBalance=scanner.nextDouble();
        if(choice==1){
            standardMember.put(enterName,new standardAccount(0.005,enterBalance,enterName,"Standard"));
        }
        else{
            VIPMember.put(enterName,new VIPAccount(0.01,enterBalance,enterName,"VIP"));
        }
        System.out.println("Account Created!!\n");

    }

    /**
     * This is the drawMenu method
     */
    public static void drawMenu(){
        System.out.println("*** Menu ***");
        System.out.println("1. Create Account");
        System.out.println("2. Display");
        System.out.println("3. Withdraw");
        System.out.println("4. Deposit");
        System.out.println("5. Display All");
        System.out.println("6. Remove Account");
        System.out.println("7. Calculate Interest");
        System.out.println("8. Exit");
        System.out.println("");
    }

    /**
     * This is the display method which provides the function of displaying information of a certain user!
     */
    public static void display(){
        System.out.print("Enter Your name: ");
        Scanner scanner=new Scanner(System.in);
        String enterName=scanner.next();
        if(standardMember.containsKey(enterName)){
            standardAccount temp=standardMember.get(enterName);
            System.out.println("**Account Details**");
            System.out.println("Name: "+enterName);
            System.out.println("Account Type: "+temp.getType());
            System.out.println("Balance: "+temp.getBalance());
            System.out.println("");
        }
        else if(VIPMember.containsKey(enterName)){
            VIPAccount temp=VIPMember.get(enterName);
            System.out.println("**Account Details**");
            System.out.println("Name: "+enterName);
            System.out.println("Account Type: "+temp.getType());
            System.out.println("Balance: "+temp.getBalance());
            System.out.println("");
        }
        else{
            System.out.println("Name : "+enterName+" does not exist\n");
        }
    }
    public static HashMap<String,standardAccount> standardMember=new HashMap<String ,standardAccount>();
    public static HashMap<String,VIPAccount> VIPMember=new HashMap<String,VIPAccount>();
}
