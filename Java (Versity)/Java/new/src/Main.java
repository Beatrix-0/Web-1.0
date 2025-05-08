public class Main {
    public static void main(String[] args) {
        BankAccount bank1 = new BankAccount(101 , 25 , 2);
//        bank1.deposit(5);
//        bank1.withdraw(100);
        SavingsAccount bank2 = new SavingsAccount(102 , 200 , 3 , 50);
//        System.out.println(bank2.balance);
//        bank2.profit = 10 ;
//        bank2.deposit(5);

        System.out.println(bank2.accountNumber);



    }
}