package Polymorphism_one_15;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.print();
        Person p2 = new Teacher();
        p2.print();
        Person p3 = new Student();
        p3.print();
    }
}
