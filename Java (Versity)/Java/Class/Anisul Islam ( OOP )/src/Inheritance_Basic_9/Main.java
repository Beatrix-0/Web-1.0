package Inheritance_Basic_9;

public class Main {
    public static void main(String[] args) {

        Teacher t1 = new Teacher();
        t1.name = "Siam";
        t1.age = 10 ;
        t1.dept = "Engineering";

        t1.print_1();
        System.out.println();
        t1.print_2();
    }
}
