package Pacage_20.SubPacage_2;

import Pacage_20.SubPacage_1.A;

public class Main {
    public static void main(String[] args) {
        // Accessing class from current pacage(SubPacage_2)
        X obj1 = new X();
        obj1.print();

        // Accessing class from another pacage(SubPacage_1)
        // for this we have to import the pacage and class
        A obj2 = new A();
        obj2.print();
    }
}
