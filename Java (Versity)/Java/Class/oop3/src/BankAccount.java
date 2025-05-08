public class BankAccount {
    int accountNumber ;
    double balance ;
    double interestRate;

    BankAccount(int accountNumber, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    void deposit(double amount) {
        if ( amount > 0 ) {
            balance = balance + amount;
            System.out.println("Deposit amount :" + amount + " Current balance : " + balance);
        }
        else {
            System.out.println("Invalid Amount");
        }
    }

    void withdraw(double amount) {
        if ( balance >= amount ){
            balance = balance - amount;
            System.out.println("Withdraw amount :" + amount + "Current balance : " + balance);
        }
        else{
            System.err.println("Gorib");
        }
    }

    double calculateInterest(){
        return balance * (interestRate/100) ;
    }

    void display(){
        System.out.println("Account number : " + accountNumber);
        System.out.println("Balance : " + balance);
        System.out.println("Interest Rate : " + interestRate);
    }
}
