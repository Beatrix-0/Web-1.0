public class BankAccount {
    int accountNumber;
    double balance;
    double interestRate;

    BankAccount(int accountNumber, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance ;
        this.interestRate = interestRate;
    }

    void deposit( double x ){
        balance += x;
        System.out.println("Current amount : " + balance);
    }

    void withdraw( double y ){
        if ( balance >= y ){
            balance = balance - y;
            System.out.println("Current amount : " + balance);
        }
        else{
            System.err.println("No sufficient funds");
        }
    }

}