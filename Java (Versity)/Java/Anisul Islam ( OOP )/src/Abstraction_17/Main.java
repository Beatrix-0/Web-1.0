package Abstraction_17;

public class Main {
    public static void main(String[] args) {
        Mobile m1 = new Rahim();
        Mobile m2 = new Karim();
        System.out.println(m1);
        m1.SendMessage();
        m2.SendMessage();

        m1.call();

    }
}
