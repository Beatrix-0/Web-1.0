public class SavingsAccount extends BankAccount{
    public SavingsAccount(int accountNumber, double balance, double interestRate){
        super(accountNumber, balance, interestRate);
    }

    @Override
    double calculateInterest(){
        return balance * (interestRate/100) ;
    }
}
