package Static_Method_6;

public class Student {

    void print1(){
        System.out.println("Need to create a object as the method is not static");
    }

    static void print2(){
        System.out.println("Need not to create a object as the method is static");
    }
}
