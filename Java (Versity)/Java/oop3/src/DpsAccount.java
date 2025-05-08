public class DpsAccount extends BankAccount {
    public DpsAccount(int accountNumber, double balance, double interestRate){
        super(accountNumber, balance, interestRate);
    }

    @Override
    double calculateInterest(){
        return balance * (interestRate/100)*1.5 ;
    }
}
