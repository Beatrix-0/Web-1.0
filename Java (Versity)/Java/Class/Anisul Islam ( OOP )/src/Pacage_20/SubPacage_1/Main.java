package Pacage_20.SubPacage_1;
import Pacage_20.SubPacage_2.X;
public class Main {
    public static void main(String[] args) {
        // Accessing class from current pacage(SubPacage_1)
        A obj1 = new A();
        obj1.print();

        // Accessing class from another pacage(SubPacage_1)
        // for this we have to import the pacage and class
        X obj2 = new X();
        obj2.print();
    }
}
