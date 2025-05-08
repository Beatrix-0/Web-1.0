package Inheritance_Basic_9;

public class Teacher extends Person {
    String dept ;

    void print_2(){
        print_1();
        System.out.println("Department : "+dept);
    }
}
