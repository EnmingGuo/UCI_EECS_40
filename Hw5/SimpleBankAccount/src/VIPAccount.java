public class VIPAccount implements bankAccount{
    public VIPAccount(double rate,double balance,String name,String type){
        this.rate=rate;
        this.balance=balance;
        this.name=name;
        this.type=type;
    }
    public VIPAccount(){
        this.rate=0;
        this.balance=0;
        this.name="";
        this.type="";
    }
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    private double rate;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private  String type;
    @Override
    public void Display(){
        System.out.println("Name: "+getName());
        System.out.println("Account Type: "+getType());
        System.out.println("Balance: "+getBalance());
    }
    @Override
    public void Deposit(double money){
        System.out.println("Name: "+getName());
        setBalance(getBalance()+money);
        System.out.println("Balance: "+getBalance());
    }
    @Override
    public void Withdraw(double money){
        System.out.println("Name: "+getName());
        setBalance(getBalance()-money);
        System.out.println("Balance: "+getBalance());
    }
    @Override
    public double Calculate(int month){
        double interest=0;
        if(getType().equals("Standard")){
            interest=getBalance()*0.005*month;
        }
        else{
            interest=getBalance()*0.01*month;
        }
        return interest;
    }
}
