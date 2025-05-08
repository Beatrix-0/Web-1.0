public class Main {
    public static void main(String[] args) {
        SavingsAccount saving = new SavingsAccount( 101 , 5000 , 4 );
        DpsAccount dps = new DpsAccount( 102 , 1000 , 5 );
        FixedDepositAccount fix_dp = new FixedDepositAccount(103 , 20000 , 6 , 3);

        System.out.println("***************Saving Account Information***************");
        saving.deposit(2000);
        saving.withdraw(1000);
        System.out.println("Interest Earned :" + " " + saving.calculateInterest());
        saving.display();

        System.out.println("***************DpsAccount***************");
        dps.deposit(2000);
        dps.withdraw(1000);
        System.out.println("Interest Earned :" + " " + dps.calculateInterest());
        dps.display();

        System.out.println("***************FixedDepositAccount***************");
        fix_dp.deposit(2000);
        fix_dp.withdraw(1000);
        System.out.println("Interest Earned :" + " " + fix_dp.calculateInterest());
        fix_dp.display();
    }
}