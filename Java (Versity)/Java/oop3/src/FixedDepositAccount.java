public class FixedDepositAccount extends BankAccount {
    int year;
    public FixedDepositAccount(int accountNumber, double balance, double interestRate , int year){
        super(accountNumber, balance, interestRate);
        this.year = year;
    }

    @Override
    double calculateInterest(){
        return balance * (interestRate/100)*year ;
    }

    @Override
    void display(){
        System.out.println("Account number : " + accountNumber);
        System.out.println("Balance : " + balance);
        System.out.println("Interest Rate : " + interestRate);
        System.out.println("Deposit Year : " + year);
    }
}
